package Management;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class viewMem 
{
	public viewMem()
	{
		
	}
	public void view()
	{
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 Connection conn =  DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\database\\idPass.accdb");
	         
	         Vector < Vector < String >> dataVector = new Vector < Vector < String >> ();
	 
	         PreparedStatement pre = conn.prepareStatement ("SELECT * FROM pol");
	         ResultSet rs = pre.executeQuery ();
	         while (rs.next ())
	 
	         {
	 
	             Vector < String > data = new Vector < String > ();
	 
	             data.add (rs.getString (3)); 
	 
	             data.add (rs.getString (4)); 
	 
	             data.add (rs.getString (2));
	             dataVector.add (data);
	 
	         }
	 
	         JFrame f = new JFrame("Member List");
			    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    JButton back = new JButton("Back");
			    Vector<Vector> rowData = new Vector<Vector>();
			    Vector<String> columnNames = new Vector<String>();
			    columnNames.addElement("Name");
			    columnNames.addElement("Dessignation");
			    columnNames.addElement("User ID");
			    GridLayout gl = new GridLayout();
			    FlowLayout fl = new FlowLayout();
			    JPanel jp1 = new JPanel();
			    JPanel jp2 = new JPanel();
			    JTable table = new JTable(dataVector, columnNames);
			    gl.setRows(2);
			    JScrollPane scrollPane = new JScrollPane(table);
			    jp1.add(scrollPane, BorderLayout.CENTER);
			    jp2.setLayout(fl);
			    jp2.add(back);
			    f.setSize(471, 500);
			    f.setLocation(450,150);
			    f.setLayout(gl);
			    f.add(jp1);
			    f.add(jp2);
			    f.setVisible(true);
			    
			    back.addActionListener(new ActionListener()
				{
					 public void actionPerformed(ActionEvent e) 
				        {
						 f.setVisible(false);
		     		    
				        }
						
				});
			

		       
		        
		    }
		    catch(Exception e)
		 	{
		        
		    }
	}

}
