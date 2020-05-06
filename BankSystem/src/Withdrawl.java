
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackEnd.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Withdrawl extends JFrame {

	private JPanel contentPane;
	private JTextField textField_enterWithdrawl;
	private String SSN;
	private String type;
	private String value;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String ssn,String type) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawl frame = new Withdrawl(ssn,type);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Withdrawl(String ssn,String type) {
		this.type = type;
		this.SSN = ssn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 418);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWithdraw = new JLabel("Withdrawl");
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Enter Withdrawl Amount:");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField_enterWithdrawl = new JTextField();
		textField_enterWithdrawl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_enterWithdrawl.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(Color.GREEN);
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mainMenu = new MainMenu();
		        dispose();
		        mainMenu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1_1_2 = new JButton("Exit");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.exitButtonActionPerformed(e);
			}
		});
		btnNewButton_1_1_2.setForeground(Color.RED);
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckingorSaving_Withdrawl cspage = new CheckingorSaving_Withdrawl(SSN);
		        dispose();
		        cspage.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_enterWithdrawl.setText("");
			}
		});
		btnClear.setBackground(Color.RED);
		
		JButton btnConfirm_1 = new JButton("Ok");
		btnConfirm_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfirm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					okButtonActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfirm_1.setBackground(Color.GREEN);
		
		if (this.type == "Checking") {
		    try {
				value = AppBackup.getUserAttribute(SSN,"customer",4);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		}else if (this.type == "Saving"){
			try {
				value = AppBackup.getUserAttribute(SSN,"customer",7);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			try {
				value = AppBackup.getUserAttribute(SSN,"customer",11);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		String value2;
		if (value.equals("null")) {
			
			   value2 =  " null."+"\n"+" Maybe you don't have this type of account for now?";
			} else {
				Double value3 = Double.parseDouble(value);
				   
			    value2 =  Double.toString(value3);
			}
		
		lblNewLabel_1_1 = new JLabel("Your current balance is: " + value2);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Remember you will be charged a 10 dollar fee for each withdrawl!");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.MAGENTA);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(198)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(183)
									.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(209))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnConfirm_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_enterWithdrawl, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)))
									.addGap(53)
									.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(224)
							.addComponent(lblWithdraw, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(706, Short.MAX_VALUE)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(278))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 835, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 835, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(182, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWithdraw, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
							.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_enterWithdrawl, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfirm_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1_1_1, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//Ok button performed
	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
	   StringBuilder warnings = new StringBuilder();
	   double amount =0;
	   double initial;
	   String value;
	   if(textField_enterWithdrawl.getText().isEmpty()) {
    	   JOptionPane.showMessageDialog(this, "Error! Withdrawl Amount cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
    	   warnings.append("Withdrawl error");
       }else {
    	   try {
    		   amount = Double.parseDouble(textField_enterWithdrawl.getText());
    		   
    	   }
    		   catch (NumberFormatException ex) {
    			   JOptionPane.showMessageDialog(this, "Error! Withdrawl amount must be a number!","Input Error",JOptionPane.WARNING_MESSAGE);
    			   warnings.append("Withdrawl error");
    			   
    		   }
       }
    	   
      
       
      
       
       if (warnings.length()==0) {
    	   if (type.contentEquals("Checking")) {
    		   value = AppBackup.getUserAttribute(SSN,"customer",4);
    		   if (value.equals("null")) {
    			   JOptionPane.showMessageDialog(this, "Your don't have a checking account yet!","Failed",JOptionPane.WARNING_MESSAGE);
    			   
    		   }else {
    		     initial = Double.parseDouble(value); 
    		     if (initial < amount + 10.00) {
    		    	 JOptionPane.showMessageDialog(this, "Your don't have enough money to withdrawl","Failed",JOptionPane.WARNING_MESSAGE);
    		     }else {
    	         AppBackup.updateUserAttribute(SSN, "customer", 4, Double.toString(initial - amount-10.0));
    	         JOptionPane.showMessageDialog(this, "Your withdrawl has sucessfully been made!" + "\n" + "Now your balance is " + Double.toString(initial-amount-10.00));
    	         Double initial_balance = Double.parseDouble(AppBackup.getUserAttribute("123-456-789", "manager", 3));
         	     // manager will earn the open account fee
         	      AppBackup.changeAttributeOfAll("manager",3,Double.toString((initial_balance + 10.0)));
         	     AppBackup.createTransactionRecord(SSN, "Withdrawl", amount, 5, 5, 2020);
    		     }
    		   }
    	   
           }else if (type.contentEquals("Saving")){
        	   value = AppBackup.getUserAttribute(SSN,"customer",7);
    		   if (value.equals("null")) {
    			   JOptionPane.showMessageDialog(this, "Your don't have a savings account yet!","Failed",JOptionPane.WARNING_MESSAGE);
    			   
    		   }else {
    		     initial = Double.parseDouble(value); 
    		     if (initial < amount + 10.00) {
    		    	 JOptionPane.showMessageDialog(this, "Your don't have enough money to withdrawl","Failed",JOptionPane.WARNING_MESSAGE);
    		     }else {
    	         AppBackup.updateUserAttribute(SSN, "customer", 7, Double.toString(initial - amount-10.0));
    	         JOptionPane.showMessageDialog(this, "Your withdrawl has sucessfully been made!" + "\n" + "Now your balance is " + Double.toString(initial-amount-10.0));
    	         Double initial_balance = Double.parseDouble(AppBackup.getUserAttribute("123-456-789", "manager", 3));
       	         // manager will earn the open account fee
       	         AppBackup.changeAttributeOfAll("manager",3,Double.toString((initial_balance + 10.0)));
       	         AppBackup.createTransactionRecord(SSN, "Withdrawl", amount, 4, 5, 2020);
    		     }
    		   }
          }else {
        	  value = AppBackup.getUserAttribute(SSN,"customer",11);
   		   if (value.equals("null")) {
   			   JOptionPane.showMessageDialog(this, "Your don't have a checkings account yet!","Failed",JOptionPane.WARNING_MESSAGE);
   			   
   		   }else {
   		     initial = Double.parseDouble(value); 
   		     if (initial < amount + 10.00) {
   		    	 JOptionPane.showMessageDialog(this, "Your don't have enough money to withdrawl","Failed",JOptionPane.WARNING_MESSAGE);
   		     }else {
   	         AppBackup.updateUserAttribute(SSN, "customer", 11, Double.toString(initial - amount-10.0));
   	         JOptionPane.showMessageDialog(this, "Your withdrawl has sucessfully been made!" + "\n" + "Now your balance is " + Double.toString(initial-amount-10.0));
   	         Double initial_balance = Double.parseDouble(AppBackup.getUserAttribute("123-456-789", "manager", 3));
      	     // manager will earn the open account fee
      	     AppBackup.changeAttributeOfAll("manager",3,Double.toString((initial_balance + 10.0)));
      	   AppBackup.createTransactionRecord(SSN, "Withdrawl", amount, 4, 5, 2020);
   		     }
   		   }
        	  
          }
    	   
       }
	}


}
