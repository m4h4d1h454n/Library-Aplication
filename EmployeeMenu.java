package Management;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EmployeeMenu 
{
	public void emMenu()
	{
		Members mem = new Members();
		GridLayout gl = new GridLayout();
		JFrame f = new JFrame("Members Menu");
		JPanel jp = new JPanel();
		
		JButton bAtt = new JButton("Give Attandance");
		JButton bChAtt = new JButton("Check Attandance");
		JButton bAdLi = new JButton("Admin Login");
		JButton bSOut = new JButton("Sign Out");
		bAtt.setSize(30, 10);
		f.setSize(300, 500);
		f.setLocation(450,150);
		jp.setSize(100, 50);
		gl.setVgap(10);
		gl.setColumns(1);
		gl.setRows(17);
		f.getContentPane().setLayout(gl);
		f.setVisible(true);
		
		f.add(bAtt);
		f.add(bChAtt);
		f.add(bAdLi);
		f.add(bSOut);
		JLabel dateTime = new JLabel();
	    dateTime.setText(JFrameDate.timeNow());
		f.add(dateTime);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bAtt.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		         mem.CountAttandance();
		         JOptionPane.showMessageDialog(f,"Attandance Successfull");
		        }
		    } );
		bChAtt.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		         JOptionPane.showMessageDialog(f,"Attandance: "+mem.getAttandance());
		        }
		    } );
		
		bAdLi.addActionListener(new ActionListener() 
		{
		        public void actionPerformed(ActionEvent e) 
		        {
		        	AdminMenuGUI amg = new AdminMenuGUI();
		        	f.setVisible(false);
		        	amg.login();
		        }
		    } );
		
		bSOut.addActionListener(new ActionListener() 
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
