package Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Login1 extends javax.swing.JFrame


{
	
	  public Login1() {
	        initComponents();
	    }
	
	 public void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jTextField2 = new javax.swing.JTextField();
	        jPasswordField1 = new javax.swing.JPasswordField();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jLabel5 = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);

	        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
	        jLabel1.setText("User Password");
	        getContentPane().add(jLabel1);
	        jLabel1.setBounds(10, 190, 245, 44);

	        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	        jLabel2.setText("User ID");
	        getContentPane().add(jLabel2);
	        jLabel2.setBounds(10, 80, 245, 44);

	        jTextField2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jTextField2ActionPerformed(evt);
	            }
	        });
	        getContentPane().add(jTextField2);
	        jTextField2.setBounds(10, 120, 304, 46);

	        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jPasswordField1ActionPerformed(evt);
	            }
	        });
	        getContentPane().add(jPasswordField1);
	        jPasswordField1.setBounds(10, 250, 304, 47);

	        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
	        jLabel3.setText("Welcome");
	        getContentPane().add(jLabel3);
	        jLabel3.setBounds(108, 0, 97, 46);

	        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
	        jLabel4.setText("Library Management System");
	        getContentPane().add(jLabel4);
	        jLabel4.setBounds(10, 40, 304, 46);

	        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
	        jButton2.setText("Login");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });
	        getContentPane().add(jButton2);
	        jButton2.setBounds(50, 310, 96, 36);

	        jButton3.setText("CLOSE");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });
	        getContentPane().add(jButton3);
	        jButton3.setBounds(180, 310, 98, 35);

	        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\1_book shelf.jpg")); // NOI18N
	        jLabel5.setText("jLabel5");
	        getContentPane().add(jLabel5);
	        jLabel5.setBounds(-70, 0, 400, 360);

	        pack();
	    }// </editor-fold>                        

	    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
	      
	    }                                           

	    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
	      
	    }                                               

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
	    {
	    	
	    	 PreparedStatement pst = null;
             ResultSet rst = null;
            
            	
				
            	 try {
            		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            		 Connection conn =  DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\msmhp\\Documents\\JAVA\\LMS\\database\\idPass.accdb");
					String sql = "select * from pol where memID= '"+jTextField2.getText()+"'and memPass='"+jPasswordField1.getText()+"'";
	            	 pst = conn.prepareStatement(sql);
	            	 rst = pst.executeQuery();
	            	 
	            	 if(rst.next())
	            	 {
	            		 if(rst.getString(4).equals("Employee"))
	            		 {
	            		 EmployeeMenu em = new EmployeeMenu();
	            		 em.emMenu();
	            		 this.setVisible(false);
	            		 }
	            		 if(rst.getString(4).equals("Student"))
	            		 {
	            		StudentMenu em = new  StudentMenu();
	            		 em.sMenu();
	            		 this.setVisible(false);
	            		 }
	            		
	            	 }
	            	 else
	            	 {
	            		 JOptionPane.showMessageDialog(null, "Wrong User ID or Password");
	            	 }
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1);
				} 
        }

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String args[]) {
	        /* Set the Nimbus look and feel */
	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	         */
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Login1().setVisible(true);
	            }
	        });
	    }

	    // Variables declaration - do not modify                     
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JPasswordField jPasswordField1;
	    private javax.swing.JTextField jTextField2;
	    // End of variables declaration                   
	}


