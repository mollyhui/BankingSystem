
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import BackEnd.*;

public class Deposit extends JFrame {

	private JPanel contentPane;
	private JTextField textField_enterDeposit;
	private String SSN;
	private String type;
	private double initial;
	private String value;
	private JLabel lblNewLabel_1_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String ssn,String type) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit(ssn,type);
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
	public Deposit(String ssn,String type) {
		this.type = type;
		this.SSN = ssn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Deposit");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_enterDeposit = new JTextField();
		textField_enterDeposit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_enterDeposit.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Deposit Amount:");
		lblNewLabel_1.setForeground(new Color(165, 42, 42));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.CYAN);
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
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mainMenu = new MainMenu();
		        dispose();
		        mainMenu.setVisible(true);
			}
		});
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckingorSaving_Deposit cspage = new CheckingorSaving_Deposit(SSN);
		        dispose();
		        cspage.setVisible(true);
				
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1_1_2 = new JButton("Exit");
		btnNewButton_1_1_2.setForeground(Color.RED);
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.exitButtonActionPerformed(e);
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_enterDeposit.setText("");
				
			}
		});
		btnClear.setForeground(Color.BLUE);
		btnClear.setBackground(Color.RED);
		if (this.type == "Checking") {
		    try {
				value = AppBackup.getUserAttribute(SSN,"customer",4);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		}else {
			try {
				value = AppBackup.getUserAttribute(SSN,"customer",7);
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(206)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(249, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(177)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(155)
							.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(106, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(345)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_enterDeposit, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_enterDeposit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//Ok button performed
			private void okButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
				StringBuilder warnings = new StringBuilder();
			   double amount =0;
			   
			   if(textField_enterDeposit.getText().isEmpty()) {
		    	   JOptionPane.showMessageDialog(this, "Error! Deposit Amount cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
		    	   warnings.append("Deposit error");
		       }else {
		    	   try {
		    		   amount = Double.parseDouble(textField_enterDeposit.getText());
		    		   
		    	   }
		    		   catch (NumberFormatException ex) {
		    			   JOptionPane.showMessageDialog(this, "Error! Deposit amount must be a number!","Input Error",JOptionPane.WARNING_MESSAGE);
		    			   warnings.append("Deposit error");
		    			   
		    		   }
		       }
		    	   
		      
		       
		       if (amount<100.0) {
				   JOptionPane.showMessageDialog(this, "Your deposit amount must be at least 100.0!","Input Error",JOptionPane.WARNING_MESSAGE);
				   warnings.append("Deposit error");
			   }
		       
		       if (warnings.length()==0) {
		    	   if (type.contentEquals("Checking")) {
		    		   value = AppBackup.getUserAttribute(SSN,"customer",4);
		    		   if (value.equals("null")) {
		    			   JOptionPane.showMessageDialog(this, "Your don't have a checking account yet!","Failed",JOptionPane.WARNING_MESSAGE);
		    			   
		    		   }else {
		    		     initial = Double.parseDouble(value); 
		    	         AppBackup.updateUserAttribute(SSN, "customer", 4, Double.toString(amount + initial));
		    	         JOptionPane.showMessageDialog(this, "Your deposit has sucessfully been made!" + "\n" + "Now your balance is " + Double.toString(amount + initial));
		    	         AppBackup.createTransactionRecord(SSN, "Deposit", amount, 6, 5, 2020);
		    	         
		    		   }
		    	   
		           }else {
		    	      value = AppBackup.getUserAttribute(SSN,"customer",7);
	    		      if (value.equals("null")) {
	    			   JOptionPane.showMessageDialog(this, "Your don't have a savings account yet!","Failed",JOptionPane.WARNING_MESSAGE);
	                  }else {
	    		        initial = Double.parseDouble(value); 
	    	            AppBackup.updateUserAttribute(SSN, "customer", 7, Double.toString(amount + initial));
	    	            JOptionPane.showMessageDialog(this, "Your deposit has sucessfully been made!" + "\n" + "Now your balance is " + Double.toString(amount + initial));
	    	            AppBackup.createTransactionRecord(SSN, "Deposit", amount, 6, 5, 2020);
	    		   }
	    		      
		       }
		    	   
		       }
			}
}
