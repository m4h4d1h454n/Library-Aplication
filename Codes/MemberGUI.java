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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberGUI 
{
	
	private String tempMemName;
	private String tempMemDes;
	private String tempMemID;
	private String tempMemPass;
	
	public MemberGUI()
	{
		
	}
	
	public void addMemBer(Members[] mem)
	{
		GridLayout gl = new GridLayout();
		JFrame f = new JFrame("Add Member Menu");
		JButton b1 = new JButton("Save");
		JButton b2 = new JButton("Back");
		JLabel tlName = new JLabel("Enter Name");
		JLabel tlDess = new JLabel("Dessignation");
		JLabel tlID = new JLabel("User ID");
		JLabel tlPass = new JLabel("User Password");
		
		JTextField tfName = new JTextField("", 10);
		String Dess[] = {"","Employee", "Student"};
		JComboBox CBDess = new JComboBox(Dess);
		JTextField tfID = new JTextField("", 10);
		JTextField tfPass = new JTextField("", 10);
		
		JPanel pan = new JPanel();
		Color cl = new Color(255,0,0);
		
		gl.setColumns(0);
		gl.setRows(17);
		f.setSize(300, 400);
		f.getContentPane().setLayout(gl);
		f.setLocation(450,150);
		f.add(tlName);
		f.add(tfName);
		f.add(tlDess);
		f.add(CBDess);
		f.add(tlID);
		f.add(tfID);
		f.add(tlPass);
		f.add(tfPass);
		f.add(b1);
		f.add(b2);
		JLabel dateTime = new JLabel();
	    dateTime.setText(JFrameDate.timeNow());
		f.add(dateTime);
		f.setVisible(true);
		
		Members p1 = new Members(tempMemName, tempMemDes, tempMemID, tempMemPass);
		
		//Members p1 = new Members("pol", "Employee", "pol", "pol");
		for(int i = 0; i<mem.length; i++)
		{
			if(mem[i] == null)
			{
				mem[i] = p1;
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
		    		    cn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\database\\idPass.accdb");
		    		    String q = "INSERT INTO pol ([memName],[memDes], [memID], [memPass]) VALUES (?,?,?,?)";
		    		    PreparedStatement st = cn.prepareStatement (q);
		    		    st.setString(1, tfName.getText());
		    		    st.setString(2, (String) CBDess.getSelectedItem());
		    		    st.setString(3, tfID.getText());
		    		    st.setString(4, tfPass.getText());
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

	public void disMem(Members [] mem)
	{
		int i=0;
		while(mem[i] != null)
		{
			System.out.println(mem[i]+ "\n");
			i++;
		}
	}
	
	
	
}
