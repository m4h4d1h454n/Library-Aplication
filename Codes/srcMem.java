package Management;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class srcMem 
{
	public srcMem()
	{
		
	}
	public void search()
	{
		JFrame f = new JFrame("Book Search Menu");
		GridLayout gl = new GridLayout();
		gl.setRows(7);
		gl.setColumns(2);
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		f.setLocation(450,150);
		JLabel jl1 = new JLabel("Enter Member Name to Search");
		JTextField tfSrch = new JTextField("                                      ");
		JButton jbSrch = new JButton("Search");
		JButton jbBack = new JButton("Back");
		JLabel jlBook = new JLabel("Member Name");
		JTextField tfBook = new JTextField("                                      ");
		JLabel jlAuthor = new JLabel("Dessignation");
		JTextField tfAuthor = new JTextField("                                      ");
		JLabel jlDep = new JLabel("UserID");
		JTextField tfDep = new JTextField("                                      ");
		JLabel jlSub = new JLabel("PassWord");
		JTextField tfSub  = new JTextField("It's Confidential                     ");
		
		
		f.setLayout(gl);
		
		f.add(jp);
		f.add(jp1);
		f.add(jp2);
		f.add(jp3);
		f.add(jp4);
		f.add(jp5);
		f.add(jp6);
		

		
		
		
		jp.add(jl1);
		jp.add(tfSrch);
		jp.add(jbSrch);
		jp.add(jbBack);
		jp1.add(jlBook);
		jp1.add(tfBook);
		jp2.add(jlAuthor);
		jp2.add(tfAuthor);
		jp3.add(jlDep);
		jp3.add(tfDep);
		jp4.add(jlSub);
		jp4.add(tfSub);
		
		
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
		                PreparedStatement st = connection.prepareStatement("SELECT * FROM pol  where memName=?");

		                        st.setString(1, str);

		                        ResultSet rs = st.executeQuery();
		            		if (rs.next()) {

		            			
		    		        	 	
		                            tfBook.setText(rs.getString(3));
		                            tfAuthor.setText(rs.getString(4));
		                            tfDep.setText(rs.getString(2));
		                           
		                           
		                            
		                            
		                            
		                        } else {

		                            JOptionPane.showMessageDialog(null, "Member Not Found -_-");

		                        }
		            }catch(Exception e1) {}
		            
						
		        }
		});
		
		jbBack.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
		        {
				 f.setVisible(false);
     		    
		        }
				
		});
		
	}
	

}
