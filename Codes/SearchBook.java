package Management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class SearchBook
{
	
	public SearchBook()
	{
		
	}
	public void search()
	{
		JFrame f = new JFrame("Book Search Menu");
		GridLayout gl = new GridLayout();
		gl.setRows(7);
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		f.setLocation(450,150);
		JLabel jl1 = new JLabel("Enter Book Name to Search");
		JTextField tfSrch = new JTextField("                                      ");
		JButton jbSrch = new JButton("Search");
		JButton jbBack = new JButton("Back");
		JLabel jlBook = new JLabel("Book Name");
		JTextField tfBook = new JTextField("                                      ");
		JLabel jlAuthor = new JLabel("Author Name");
		JTextField tfAuthor = new JTextField("                                      ");
		JLabel jlDep = new JLabel("Department");
		JTextField tfDep = new JTextField("                                      ");
		JLabel jlSub = new JLabel("Subject");
		JTextField tfSub  = new JTextField("                                      ");
		JLabel jlHir = new JLabel("Book is Hired");
		JTextField tfHir = new JTextField("                                      ");
		JLabel jlSer = new JLabel("Serial Number");
		JTextField tfSer = new JTextField("                                      ");
		
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
		jp5.add(jlHir);
		jp5.add(tfHir);
		jp6.add(jlSer);
		jp6.add(tfSer);
		
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
		                connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\database\\booklist.accdb");
		                PreparedStatement st = connection.prepareStatement("SELECT * FROM Books  where bName=?");

		                        st.setString(1, str);

		                        ResultSet rs = st.executeQuery();
		            		if (rs.next()) {

		            			/*JOptionPane.showMessageDialog(null, 
		    		        			
		    		        			"Book Name         : "+rs.getString(1) +
		    		        			 "\n         : " +  rs.getString(2) + 
		    		        			 "\nDepartment    : " + rs.getString(3) + 
		    		        			 "\nSubject : " + rs.getString(4)+ 
		    		        			 "\nHired: " + rs.getString(5)
		    		        			 + "\nSerial: " + rs.getString(6));*/
		    		        	 	
		                            tfBook.setText(rs.getString(1));
		                            tfAuthor.setText(rs.getString(2));
		                            tfDep.setText(rs.getString(3));
		                            tfSub.setText(rs.getString(4));
		                            tfSer.setText(rs.getString(5));
		                            tfHir.setText(rs.getString(6));
		                            
		                            
		                            
		                        } else {

		                            JOptionPane.showMessageDialog(null, "Name not Found");

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
