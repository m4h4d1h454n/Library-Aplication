package Management;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BooksGUI 
{
	private String tempB;
	private String tempA;
	private String tempD;
	private String tempS;
	private int tempInt;
	
	public BooksGUI()
	{
		
	}
	
	public void addBook(Books[] b)
	{
		
		GridLayout gl = new GridLayout();
		JFrame f = new JFrame("Add Book Menu");
		JButton b1 = new JButton("Save");
		JButton b2 = new JButton("Back");
		JLabel tlName = new JLabel("Enter Book Name");
		JLabel tlAuthor = new JLabel("Author Name");
		JTextField tfBookName = new JTextField("", 10);
		JTextField tfAuthor = new JTextField("", 10);
		JLabel tlDepartment = new JLabel("Department");
		String Dept[] = {"","ECE","BBA","Pharmaceutical Science", "Civil", "Others"};
		JComboBox cbDepartment = new JComboBox(Dept);
		JLabel tlSubject = new JLabel("Subject");
		String Sub[] = {"","EEE","CSE","ETE", "MAT", "PHY","MGT","MKT","POL", "ACT", "HIS","BEN","BUS","PBH", "PHRM", "ENG"};
		JComboBox cbSub = new JComboBox(Sub);
		JLabel tlSerial = new JLabel("Serial No (Numbers Only)");
		JTextField tfSerial = new JTextField("", 10);
		JLabel tlHr = new JLabel("Hire book");
		JCheckBox cbHr = new JCheckBox();
		
		JPanel pan = new JPanel();
		Color cl = new Color(255,0,0);
		gl.setColumns(0);
		gl.setRows(17);
		f.setSize(300, 400);
		f.getContentPane().setLayout(gl);
		f.setLocation(450,150);
		f.add(tlName);
		f.add(tfBookName);
		f.add(tlAuthor);
		f.add(tfAuthor);
		f.add(tlDepartment);
		f.add(cbDepartment);
		f.add(tlSubject);
		f.add(cbSub);
		f.add(tlSerial);
		f.add(tfSerial);
		//f.add(tlHr);
		//f.add(cbHr);
		f.add(b1);
		f.add(b2);
		JLabel dateTime = new JLabel();
	    dateTime.setText(JFrameDate.timeNow());
		f.add(dateTime);
		f.setVisible(true);
		
		Books p1 = new Books(tempB, tempA, tempD, tempS, tempInt);

		for(int i = 0; i<b.length; i++)
		{
			if(b[i] == null)
			{
				b[i] = p1;
				break;
			}
		}
		b1.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		        	Connection cn;
		    		Statement st1;
		    		  ResultSet re;
		    		  try{
		    			  
		    		    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		    		    cn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\database\\booklist.accdb");
		    		    String q = "INSERT INTO Books ([bName],[aName],[dept], [sub], [serial], [isHired]) VALUES (?,?,?,?,?,?)";
		    		    PreparedStatement st = cn.prepareStatement (q);
		    		    st.setString(1, tfBookName.getText());
		    		    st.setString(2, tfAuthor.getText());
		    		    st.setString(3, (String) cbDepartment.getSelectedItem());
		    		    st.setString(4, (String) cbSub.getSelectedItem());
		    		    st.setString(5, tfSerial.getText());
		    		    st.setBoolean(6, cbHr.isSelected());
		    		    st.executeUpdate();
		    		    JOptionPane.showMessageDialog(null,"Entry Successfull");
		    		    f.setVisible(false);
		    		    AdminMenuGUI amg = new AdminMenuGUI();
		    		    amg.Admin();
		    		  }catch(ClassNotFoundException | SQLException e1)
		    		    {
		    		      System.out.println(e1);
		    		    }
		        }
		    } );
		b2.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		         f.setVisible(false);
		         AdminMenuGUI amg = new AdminMenuGUI();
		         amg.Admin();
		         
		        }
		    } );
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void disBook(Books [] b)
	{
		
		int i=0;
		while(b[i] != null)
		{
			Books bk = new Books();
			JOptionPane.showMessageDialog(null,"hvhvjbjb");
			i++;
		}
		
	}
	
}


