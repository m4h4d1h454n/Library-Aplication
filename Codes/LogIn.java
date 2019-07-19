package Management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class LogIn 
{

	public int att;

	public LogIn()
	{
		
	}
	
	
	public void Check()
	{
		
		
		
		EmployeeMenu em = new EmployeeMenu();
		GridLayout gl = new GridLayout();
		FlowLayout fl = new FlowLayout();
		JFrame f = new JFrame("Welcome to LMS");
		AdminMenu am = new AdminMenu();
		JPanel jp = new JPanel();
		jp.setLayout(fl);
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\1_book shelf.jpg"));
		JLabel forName = new JLabel("For Employee");
		JLabel lblEnterName = new JLabel("Enter ID:");
		JTextField tfName = new JTextField();
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		JPasswordField  tfPass = new JPasswordField ();
		JButton btnLogin = new JButton("LOGIN");
		JButton btncls = new JButton("CLOSE");
		
		
		gl.setColumns(0);
		gl.setRows(8);
		gl.setVgap(5);
		f.setSize(300, 400);
		f.getContentPane().setLayout(gl);
		f.setLocation(450,150);
		f.add(background);
		f.add(lblEnterName);
		f.add(tfName);
		f.add(lblEnterPassword);
		f.add(tfPass);
		
		jp.add(btnLogin);
		jp.add(btncls);
		
		f.add(jp);
		JLabel dateTime = new JLabel();
	    dateTime.setText(JFrameDate.timeNow());
		f.add(dateTime);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnLogin.addActionListener(new ActionListener() 
		{
		       

				public void actionPerformed(ActionEvent e) 
		        {
		        	 PreparedStatement pst = null;
		             ResultSet rst = null;
		            
		            	
						
		            	 try {
		            		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            		 Connection conn =  DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\database\\idPass.accdb");
							String sql = "select * from pol where memID= '"+tfName.getText()+"'and memPass='"+tfPass.getText()+"'";
			            	 pst = conn.prepareStatement(sql);
			            	 rst = pst.executeQuery();
			            	 
			            	 if(rst.next())
			            	 {
			            		 if(rst.getString(4).equals("Employee"))
			            		 {
			            		 EmployeeMenu em = new EmployeeMenu();
			            		 em.emMenu();
			            		 f.setVisible(false);
			            		 }
			            		 if(rst.getString(4).equals("Student"))
			            		 {
			            		StudentMenu em = new  StudentMenu();
			            		 em.sMenu();
			            		 f.setVisible(false);
			            		 }
			            		 att = rst.getInt(5);
			            	 }
			            	 else
			            	 {
			            		 JOptionPane.showMessageDialog(null, "Wrong User ID or Password");
			            	 }
						} catch (Exception e1) {
							
							JOptionPane.showMessageDialog(null, e1);
						} 
		        }
		}
		         );
		btncls.addActionListener(new ActionListener() 
		{
		       

				public void actionPerformed(ActionEvent e) 
		        {
		        f.setVisible(false);	
		        }
		});

		
		}
}
	
	
	


