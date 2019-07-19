package Management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class StudentMenu 
{
	public StudentMenu()
	{
		
	}
	public void sMenu()
	{
		JFrame f = new JFrame("Student Menu");
		GridLayout gl = new GridLayout();
		JButton jbVwBook = new JButton("View Available Books");
		JButton jbHrBook = new JButton("Hired Book");
		JButton jbSrcBook = new JButton("Search Book");
		JButton jbLo = new JButton("Log Out");
		JLabel jlExt = new JLabel("\n");
		
		f.setSize(300, 400);
		f.setLocation(450,150);
		gl.setColumns(1);
		gl.setRows(12);
		gl.setVgap(8);
		f.getContentPane().setLayout(gl);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		f.add(jbVwBook);
		f.add(jbHrBook);
		f.add(jbSrcBook);
		f.add(jlExt);
		f.add(jbLo);
		JLabel dateTime = new JLabel();
	    dateTime.setText(JFrameDate.timeNow());
		f.add(dateTime);
		
		jbHrBook.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {

			        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			    }
			    catch(ClassNotFoundException cnfex) {

			        System.out.println("Problem in loading or "
			                + "registering MS Access JDBC driver");
			        cnfex.printStackTrace();
			    }
			    try {
			    	 Connection connection = null;
			         Statement statement = null;
			         ResultSet resultSet = null;
			        connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\database\\booklist.accdb");
			        statement = connection.createStatement();
			        resultSet = statement.executeQuery("SELECT * FROM Books");
			        JFrame f = new JFrame("Book List");
					
					
					
					f.setSize(300, 500);
					f.setVisible(false);
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    	
			        while(resultSet.next()) {
			        	if(resultSet.getString(6).equals("true"))
			        	{
			        		JOptionPane.showMessageDialog(null, 
				        			
				        			"Book Name         : "+resultSet.getString(1) +
				        			 "\nAuthor Name         : " +  resultSet.getString(2) + 
				        			 "\nDepartment    : " + resultSet.getString(3) + 
				        			 "\nSubject : " + resultSet.getString(4)+ 
				        			 "\nSerial: " + resultSet.getString(5)
				        			 + "\nHired: " + resultSet.getString(6));
			        	}
			        	
			        	
			        	 	
			        }
			        
			        
			    }
			    catch(SQLException sqlex){
			        sqlex.printStackTrace();
			    }
		       
				
				
				
				
				
				
		        
			}
		});
		jbVwBook.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						 f.setVisible(false);
				         ViewBook vb = new ViewBook();
				         vb.view();
				         sMenu();	
					}
				});
		jbSrcBook.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 
		         SearchBook sb = new SearchBook();
		         sb.search();
		         	
			}
		});
		jbLo.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		         f.setVisible(false);
		         LogIn lg = new LogIn();
		         lg.Check();
		        }
		    } );
	}
}
