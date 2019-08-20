package Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminMenuGUI 
{
	 Books[] p1 = new Books[4];
	 
	public AdminMenuGUI()
	{
		
	}
	public void login()
	{
		JFrame f = new JFrame("Admin Menu");
		GridLayout gl = new GridLayout();
		
		JLabel jlBook = new JLabel("Admin Password");
		JPasswordField jpf = new JPasswordField();
		JButton LO = new JButton("LogIn");
		JButton Bck = new JButton("Back");
		f.setSize(300, 200);
		f.setLocation(450,150);
		f.getContentPane().setLayout(gl);
		gl.setColumns(1);
		gl.setRows(3);
		gl.setVgap(3);
		
		f.add(jlBook);
		f.add(jpf);
		f.add(LO);
		f.add(Bck);
		JLabel dateTime = new JLabel();
	    dateTime.setText(JFrameDate.timeNow());
		f.add(dateTime);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LO.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		         if(jpf.getText().equals("pol"))
		         {
		        	f.setVisible(false);
		        	Admin();
		         }
		         else
		         {
		        	 JOptionPane.showMessageDialog(f,"Fail");
		         }
		        }
		    } );
		
		Bck.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		         EmployeeMenu em = new EmployeeMenu();
		         f.setVisible(false);
		         em.emMenu();
		        }
		    } );
	}
	
	public void Admin()
	{
		JFrame f = new JFrame("Admin Menu");
		GridLayout gl = new GridLayout();
		
		JLabel jlBook = new JLabel("Book Options");
		JButton jbAddBook = new JButton("Add Book");
		JButton jbVwBook = new JButton("View Book");
		JButton jbDltBook = new JButton("Delete Book");
		JButton jbEdtBook = new JButton("Edit Book");
		JButton jbHirBook = new JButton("View Hired Book");
		JButton jbSrcBook = new JButton("Search Book");
		
		JLabel jlMem = new JLabel("Member Options");
		JButton jbAddMem = new JButton("Add Member");
		JButton jbVwMem = new JButton("View Member");
		JButton jbDltMem = new JButton("Dismiss Member");
		JButton jbSrcMem = new JButton("Search Member");
		JLabel jlExt = new JLabel("\n\n");
		JButton LO = new JButton("Log Out");
		
		f.setSize(300, 600);
		f.setLocation(100, 100);
		f.getContentPane().setLayout(gl);
		gl.setColumns(1);
		gl.setRows(14);
		gl.setVgap(7);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(jlBook);
		f.add(jbAddBook);
		f.add(jbVwBook);
		f.add(jbDltBook);
		
		f.add(jbHirBook);
		f.add(jbSrcBook);
		f.add(jlMem);
		f.add(jbAddMem);
		f.add(jbVwMem);
		f.add(jbDltMem);
		f.add(jbSrcMem);
		f.add(jlExt);
		f.add(LO);
		JLabel dateTime = new JLabel();
	    dateTime.setText(JFrameDate.timeNow());
		f.add(dateTime);
		jbHirBook.addActionListener(new ActionListener() 
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
				        			 "\nSubject : " + resultSet.getString(4)
				        			);
			        	}
			        	
			        	
			        	 	
			        }
			        
			        
			    }
			    catch(SQLException sqlex){
			        sqlex.printStackTrace();
			    }
    
			}
		});
		jbSrcMem.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				srcMem sm = new srcMem();
				sm.search();
			}
	
	
		});
		jbDltMem.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				disMem dm = new disMem();
				dm.delete();
			}
	
	
		});
		jbVwMem.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				viewMem vm = new viewMem();
				vm.view();
			}
	
	
		});
		jbAddMem.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
					{
						f.setVisible(false);
						Members[] mem1 = new Members[4];
						MemberGUI mem = new MemberGUI();
						mem.addMemBer(mem1);
						
					}
			
			
				});
		jbDltBook.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		         f.setVisible(false);
		         DeleteBook db = new DeleteBook();
		 		db.delete();
		        }
		    } );
		
		jbSrcBook.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		        
		         SearchBook sb = new SearchBook();
		 		sb.search();
		        }
		    } );
		jbAddBook.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		         f.setVisible(false);
		        
		         BooksGUI addBook = new BooksGUI();
		         addBook.addBook(p1);
		        }
		    } );
		jbVwBook.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		         f.setVisible(false);
		         ViewBook vb = new ViewBook();
		         vb.view();
		         Admin();
		        }
		    } );
		jbAddMem.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		        	BooksGUI vwBook = new BooksGUI();
		        	vwBook.disBook(p1);
		        }
		    } );
		LO.addActionListener(new ActionListener() 
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
