import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackEnd.AppBackup;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnLoan extends JFrame {

	private JPanel contentPane;
	private String SSN;
	private JTextArea textField_amount;
	private JComboBox FromBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String ssn) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnLoan frame = new ReturnLoan(ssn);
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
	public ReturnLoan(String ssn) {
		this.SSN = ssn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 409);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		JLabel lblCustomerLoanReturn = new JLabel("Customer Loan Return");
		lblCustomerLoanReturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerLoanReturn.setFont(new Font("Tahoma", Font.BOLD, 29));
		
		JLabel lblReturnFrom = new JLabel("Return From:");
		lblReturnFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnFrom.setForeground(Color.BLUE);
		lblReturnFrom.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setForeground(Color.BLUE);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		textField_amount = new JTextArea();
		textField_amount.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_amount.setBackground(Color.WHITE);
		
		FromBox = new JComboBox();
		FromBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		FromBox.setModel(new DefaultComboBoxModel(new String[] {"checkings", "savings"}));
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					okButtonActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.GREEN);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClear.setBackground(Color.RED);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Loans loanpage = new Loans(SSN);
					setVisible(false);
					loanpage.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1_1_2 = new JButton("Exit");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.exitButtonActionPerformed(e);
			}
		});
		btnNewButton_1_1_2.setForeground(Color.RED);
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			MainMenu mainMenu = new MainMenu();
	        setVisible(false);
	        mainMenu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(108)
							.addComponent(lblCustomerLoanReturn, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(22)
									.addComponent(lblReturnFrom, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(FromBox, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
									.addComponent(textField_amount, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(95)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(114)
							.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCustomerLoanReturn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReturnFrom, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(FromBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_amount, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
		   StringBuilder warnings = new StringBuilder();
		   Double amount = 0.0;
		   String selectedFrom = FromBox.getSelectedItem().toString();
		   boolean hasAccountFrom = AppBackup.customerAccountExists(SSN,selectedFrom);
		   if (hasAccountFrom == false) {
			   JOptionPane.showMessageDialog(this, "Error! You don't have the selected account type ! Please create one first.","Input Error",JOptionPane.WARNING_MESSAGE);
	     	    warnings.append("Account lack error");
		   }
	    	   
	       if(textField_amount.getText().isEmpty()) {
	    	   JOptionPane.showMessageDialog(this, "Error! Return amount cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
	    	   warnings.append("amount error");
	       }else {
	    	   try {
	    		   amount = Double.parseDouble(textField_amount.getText());
	    		   
	    	   }
	    		   catch (NumberFormatException ex) {
	    			   JOptionPane.showMessageDialog(this, "Error! loan return amount must be a number!","Input Error",JOptionPane.WARNING_MESSAGE);
	    			   warnings.append("amount error");
	    			   
	    		   }
	       }
	       Double loan = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer", 13));
	       Double interest = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer", 15));
	       Double total = loan + interest;
	       Double saving_balance = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer", 7));
	       Double checking_balance = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer", 4));
	       if (selectedFrom == "checkings" && amount > checking_balance) {
	    	   JOptionPane.showMessageDialog(this, "Error! You don't have enough balance in this account given your input!","Input Error",JOptionPane.WARNING_MESSAGE);
			   warnings.append("amount error");
	    	}else if (selectedFrom == "savings" && amount > saving_balance) {
		    	   JOptionPane.showMessageDialog(this, "Error! You don't have enough balance in this account given your input!","Input Error",JOptionPane.WARNING_MESSAGE);
				   warnings.append("amount error");
		    }
	       if (warnings.length() == 0) {
	    	   double manager_balance = AppBackup.getBalanceOfManagers();
	    	   if (amount >=total) {
	    		     //update manager balance and customer loan status
	    	   
	    		     
	    	  
	    		      AppBackup.changeAttributeOfAll("manager",3,Double.toString((total+manager_balance)));
		    		  AppBackup.updateUserAttribute(SSN, "customer", 13, "null");
		    		  AppBackup.updateUserAttribute(SSN, "customer", 14, "null");
		    		  AppBackup.updateUserAttribute(SSN, "customer", 15, "null");
		    		  AppBackup.updateUserAttribute(SSN, "customer", 16, "null");
		    		  
		    		  JOptionPane.showMessageDialog(this, "You have fully repaied youe loans!");
		    		  AppBackup.createTransactionRecord(SSN, "RepayLoans", total, 6, 5, 2020);
	    	          //update customer balance
	    		      if (selectedFrom.contentEquals("checkings")) {
	    		    	  AppBackup.updateUserAttribute(SSN, "customer", 4, Double.toString(checking_balance-total));
	    		    	  
	    		      }else {
	    		    	  AppBackup.updateUserAttribute(SSN, "customer", 7, Double.toString(saving_balance-total));
	    		      }
	    	   }else {
	    		   AppBackup.changeAttributeOfAll("manager",3,Double.toString((amount+manager_balance)));
	    		   double diff =  amount-interest;
	    		   if (diff <0) {
	    			   AppBackup.updateUserAttribute(SSN, "customer", 15, Double.toString(interest-amount));
	    		   }else {
	    			   AppBackup.updateUserAttribute(SSN, "customer", 15, Double.toString(0.0));
	    		   
	    		       AppBackup.updateUserAttribute(SSN, "customer", 13, Double.toString(loan-diff));
	    		   }
	    		   AppBackup.createTransactionRecord(SSN, "RepayLoans", amount, 6, 5, 2020);
	    		   JOptionPane.showMessageDialog(this, "You have repaied youe loans! You got " +  (Double.toString(loan-amount+interest)) +  " unpaid");
	    		   //update customer balance
	    		      if (selectedFrom.contentEquals("checkings")) {
	    		    	  AppBackup.updateUserAttribute(SSN, "customer", 4, Double.toString(checking_balance-amount));
	    		    	  
	    		      }else {
	    		    	  AppBackup.updateUserAttribute(SSN, "customer", 7, Double.toString(saving_balance-amount));
	    		      }
	    	   }
	    			   
	    		
	    	 
	    		   
	    		  
	    	   
	    	   
	    	}
	      
		
	}
}
