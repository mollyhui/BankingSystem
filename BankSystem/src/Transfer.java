import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import BackEnd.*;

public class Transfer extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> FromBox;
	private JComboBox<String> ToBox;
	private boolean hasAccountFrom;
	private boolean hasAccountTo;
	private String SSN;
    private	JTextArea textField_Amount;
    private Double amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String ssn) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer frame = new Transfer(ssn);
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
	public Transfer(String ssn) {
		this.SSN = ssn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTransfer = new JLabel("Transfer");
		lblTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfer.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton_1_1 = new JButton("MainMenu");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mainMenu = new MainMenu();
		        setVisible(false);
		        mainMenu.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.exitButtonActionPerformed(e);
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterLogin_Customer afterlogin = new AfterLogin_Customer(SSN);
				setVisible(false);
				afterlogin.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(150)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 853, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(113)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
					.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(245)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(325, Short.MAX_VALUE)
					.addComponent(lblTransfer, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
					.addGap(294))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTransfer, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
							.addGap(50))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JLabel lblNewLabel = new JLabel("From:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		FromBox = new JComboBox();
		FromBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		FromBox.setModel(new DefaultComboBoxModel(new String[] {"checkings", "savings", "security"}));
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		ToBox = new JComboBox();
		ToBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ToBox.setModel(new DefaultComboBoxModel(new String[] {"checkings", "savings", "security"}));
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					okButtonActionPerformed(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnOk.setForeground(new Color(34, 139, 34));
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_Amount = new JTextArea();
		textField_Amount.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_Amount.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(142)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(220)
							.addComponent(textField_Amount, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
							.addGap(78))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(FromBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(ToBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addGap(199))))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(709, Short.MAX_VALUE)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(FromBox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(ToBox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_Amount, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmount, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	//Ok button performed
		private void okButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
			StringBuilder warnings = new StringBuilder();
			String selectedFrom = FromBox.getSelectedItem().toString();
			String selectedTo = ToBox.getSelectedItem().toString();
	       
	        if (selectedFrom.contentEquals(selectedTo)) {
	        	JOptionPane.showMessageDialog(this, "Error! Cannot transfer to the same Account !","Error",JOptionPane.WARNING_MESSAGE);
	     	    warnings.append("Same type error");
	        }
	        
	     	hasAccountFrom = AppBackup.customerAccountExists(SSN,selectedFrom);
	     	hasAccountTo = AppBackup.customerAccountExists(SSN,selectedTo);
	     	
	     	if(hasAccountFrom == false || hasAccountTo == false) {
	     		JOptionPane.showMessageDialog(this, "Error! You don't have one or more of the selected account type ! Please create one first.","Input Error",JOptionPane.WARNING_MESSAGE);
	     	    warnings.append("Account lack error");
	     	}else if (textField_Amount.getText().isEmpty()) {
		        	JOptionPane.showMessageDialog(this, "Error! Transfer amount cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
		     	    warnings.append("Empty input error");
		        
	     	}else if (textField_Amount.getText().isEmpty()) {
	        	JOptionPane.showMessageDialog(this, "Error! Transfer amount cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
	     	    warnings.append("Empty input error");
	        
     	   }else{
     		   try {
	    		   amount = Double.parseDouble(textField_Amount.getText());
	    		   
	    	   }
	    		 catch (NumberFormatException ex) {
	    			   JOptionPane.showMessageDialog(this, "Error! The input amount must be a number!","Input Error",JOptionPane.WARNING_MESSAGE);
	    			   warnings.append("error");
	    			   
	    		}
     		   
	     		if (selectedFrom.contentEquals("checkings")) {
	     			if (selectedTo.contentEquals("security")) {
	     				JOptionPane.showMessageDialog(this, "Cannot transfer from checking to security.","Error",JOptionPane.WARNING_MESSAGE);
	    	     	    warnings.append("transfer error");
	     			}else {
	     				double initialFrom = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer",4));
	     				
	     				if (initialFrom < amount) {
	     		          JOptionPane.showMessageDialog(this, "Error! You don't have enough balance to make this transfer!","Error",JOptionPane.WARNING_MESSAGE);
		     	          warnings.append("Amount error");
	     				}else if (warnings.length()==0){
	     					double initialTo = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer",7));
	     					AppBackup.updateUserAttribute(SSN,"customer",4,Double.toString(initialFrom-amount));
	     					AppBackup.updateUserAttribute(SSN,"customer",7,Double.toString(initialTo+amount));
	     					JOptionPane.showMessageDialog(this, "Transfer Completed. Your saving balance is now: " + (initialTo+amount));
	     					 AppBackup.createTransactionRecord(SSN, "Account Transfer", amount, 6, 5, 2020);
	     				}
	     			}
	     		}else if (selectedFrom.contentEquals("savings")) {
	     			double initialFrom = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer",7));
	     			if (initialFrom < amount) {
    		             JOptionPane.showMessageDialog(this, "Error! You don't have enough balance to make this transfer!","Error",JOptionPane.WARNING_MESSAGE);
	     	             warnings.append("Amount error");
    				  }else {
	     			     if (selectedTo.contentEquals("security")) {
	     			    	
	     				    if (initialFrom < 5000) {
	     				       JOptionPane.showMessageDialog(this, "If you want to transfer to security your balance should be at least 5000!.","Error",JOptionPane.WARNING_MESSAGE);
	    	     	            warnings.append("Insuffcient error");
	    	                }else if (initialFrom < amount + 2500) {
		     			    		JOptionPane.showMessageDialog(this, "Error! You should have at least 2500 dollar in your deposit!","Error",JOptionPane.WARNING_MESSAGE);
		   	     	                warnings.append("Amount error");
		     			    }else if(amount < 1000) {
	     			    		JOptionPane.showMessageDialog(this, "Error! Your transfer to security should be at least 1000 dollar!","Error",JOptionPane.WARNING_MESSAGE);
	   	     	                warnings.append("Amount error");
	     			       }else if (warnings.length()==0){
	    	                
	    	                	double initialTo = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer",11));
	    	                	
	    	                	AppBackup.updateUserAttribute(SSN,"customer",7,Double.toString(initialFrom-amount));
		     					AppBackup.updateUserAttribute(SSN,"customer",11,Double.toString(initialTo+amount));
		     					JOptionPane.showMessageDialog(this, "Transfer Completed. Your security balance is now: " + (initialTo+amount));
		     					 AppBackup.createTransactionRecord(SSN, "Account Transfer", amount, 6, 5, 2020);
		     					
	    	                }
	     			     }else if (warnings.length()==0){
	     			    	double initialTo = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer",4));
	     					AppBackup.updateUserAttribute(SSN,"customer",7,Double.toString(initialFrom-amount));
	     					AppBackup.updateUserAttribute(SSN,"customer",4,Double.toString(initialTo+amount));
	     					JOptionPane.showMessageDialog(this, "Transfer Completed. Your checking balance is now: " + (initialTo+amount));
	     					AppBackup.createTransactionRecord(SSN, "Account Transfer", amount, 6, 5, 2020);
	     			     }
	     			}
	     		}else {
	     			double initialFrom = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer",11));
	     			if (initialFrom < amount) {
    		             JOptionPane.showMessageDialog(this, "Error! You don't have enough balance to make this transfer!","Error",JOptionPane.WARNING_MESSAGE);
	     	             warnings.append("Amount error");
    				  }else if (warnings.length()==0){
	     			     if (selectedTo.contentEquals("checkings")) {
	     			    	    double initialTo = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer",4));
	     				    
	    	                	AppBackup.updateUserAttribute(SSN,"customer",11,Double.toString(initialFrom-amount));
		     					AppBackup.updateUserAttribute(SSN,"customer",4,Double.toString(initialTo+amount));
		     					JOptionPane.showMessageDialog(this, "Transfer Completed. Your checking balance is now: " + (initialTo+amount));
		     					AppBackup.createTransactionRecord(SSN, "Account Transfer", amount, 6, 5, 2020);
	    	              }else {
	    	            	  double initialTo = Double.parseDouble(AppBackup.getUserAttribute(SSN, "customer",7));
	     					  AppBackup.updateUserAttribute(SSN,"customer",11,Double.toString(initialFrom-amount));
	     					  AppBackup.updateUserAttribute(SSN,"customer",7,Double.toString(initialTo+amount));
	     					  JOptionPane.showMessageDialog(this, "Transfer Completed. Your saving balance is now: " + (initialTo+amount));
	     					  AppBackup.createTransactionRecord(SSN, "Account Transfer", amount, 6, 5, 2020);
	     				}
	     			}
	     		}
     		   
	     		  
	        	   
	        }
	    }
	
}
