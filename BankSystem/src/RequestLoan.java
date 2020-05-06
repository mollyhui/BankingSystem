import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackEnd.AppBackup;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class RequestLoan extends JFrame {

	private JPanel contentPane;
	private JTextArea textField_loanrequest;

	/**
	 * Launch the application.
	 */
	private String SSN;
	public static void main(String[] args,String ssn) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestLoan frame = new RequestLoan(ssn);
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
	public RequestLoan(String ssn) {
		this.SSN = ssn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 337);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCustomerLoanRequest = new JLabel("Customer Loan Request");
		lblCustomerLoanRequest.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerLoanRequest.setFont(new Font("Tahoma", Font.BOLD, 29));
		
		JLabel lblEnterTheAmount = new JLabel("Enter the amount you request:");
		lblEnterTheAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheAmount.setForeground(Color.BLUE);
		lblEnterTheAmount.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		textField_loanrequest = new JTextArea();
		textField_loanrequest.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_loanrequest.setBackground(Color.WHITE);
		
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
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_loanrequest.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClear.setBackground(Color.RED);
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mainMenu = new MainMenu();
		        setVisible(false);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(154)
							.addComponent(lblCustomerLoanRequest, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(466)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(122)
									.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
									.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnterTheAmount, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_loanrequest, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))))
					.addGap(60))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCustomerLoanRequest, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_loanrequest, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterTheAmount))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
		   StringBuilder warnings = new StringBuilder();
		   Double amount = 0.0;
	    	   
	       if(textField_loanrequest.getText().isEmpty()) {
	    	   JOptionPane.showMessageDialog(this, "Error! amount cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
	    	   warnings.append("amount error");
	       }else {
	    	   try {
	    		   amount = Double.parseDouble(textField_loanrequest.getText());
	    		   
	    	   }
	    		   catch (NumberFormatException ex) {
	    			   JOptionPane.showMessageDialog(this, "Error! loan request amount must be a number!","Input Error",JOptionPane.WARNING_MESSAGE);
	    			   warnings.append("amount error");
	    			   
	    		   }
	       }
	     
	       if (amount >5000 ) {
	    	   JOptionPane.showMessageDialog(this, "Error! We cannot offer a loan above 5000!","Input Error",JOptionPane.WARNING_MESSAGE);
	    	   warnings.append("amount error");
	    	}
	       double balance_manager = Double.parseDouble(AppBackup.getUserAttribute("123-456-789", "manager", 3));
	       
           if (amount > balance_manager - 2000 ) {
        	   JOptionPane.showMessageDialog(this, "Error! We cannot offer such a great amount!","Input Error",JOptionPane.WARNING_MESSAGE);
	    	   warnings.append("amount error");
           }
        	
	       if (warnings.length() == 0) { 
	    		   
	    		   //add loan and update data
		           AppBackup.changeAttributeOfAll("manager", 3, Double.toString(balance_manager -amount));
		           Double balance_customer= Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer", 7));
		          
		           AppBackup.addLoan(SSN,amount,12,amount*0.10,0);
		           AppBackup.updateUserAttribute(SSN, "customer", 7, Double.toString(balance_customer+amount));
		           JOptionPane.showMessageDialog(this,"You have sucessfully made a loan of: " + amount + " This moeny will be added to"
		    		   		+ "your savings account.");
		           AppBackup.createTransactionRecord(SSN, "RequestLoan", amount, 6, 5, 2020);
	    	 }
		
	}

}
