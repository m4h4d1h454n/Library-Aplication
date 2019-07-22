package Management;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class disMem 
{
	public disMem()
	{
		
	}
	public void delete()
	{
		JFrame f = new JFrame("Dismiss Member");
		GridLayout gl = new GridLayout();
		gl.setRows(4);
		JPanel jp = new JPanel();
		
		
		JLabel jl1 = new JLabel("Enter Member Name to Search");
		JTextField tfSrch = new JTextField("                                      ");
		JButton jbSrch = new JButton("Search & Delete");
		JButton jbBack = new JButton("Back");
		f.setLocation(450,150);
		f.setLayout(gl);
		
		f.add(jp);
		
		jp.add(jl1);
		jp.add(tfSrch);
		jp.add(jbSrch);
		jp.add(jbBack);
		
		JLabel dateTime = new JLabel();
	    dateTime.setText(JFrameDate.timeNow());
		f.add(dateTime);
		f.setSize(300, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jbSrch.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
		        {
				 Connection connection = null;
			        ResultSet resultSet = null;
			        try {
			 
			            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			        }
			        catch(ClassNotFoundException cnfex) {
			 
			            System.out.println("Problem in loading or "
			                    + "registering MS Access JDBC driver");
			            cnfex.printStackTrace();
			        }
			        try {
			        	String str = tfSrch.getText();
			            connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\database\\idPass.accdb");
			            
			            String sql = "DELETE FROM pol WHERE memName = ?";
			            PreparedStatement pstmt = connection.prepareStatement(sql);
			            pstmt.setString(1, str);
			            pstmt.executeUpdate();
			     
			            JOptionPane.showMessageDialog(null, "Delete Successful -_-");
			            
			            } catch (SQLException e1) {
			                System.out.println(e1.getMessage());
			            }
		        }
				
		});
		
		jbBack.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
		        {
				 f.setVisible(false);
     		    AdminMenuGUI amg = new AdminMenuGUI();
     		    amg.Admin();
		        }
				
		});
		
	}
}
