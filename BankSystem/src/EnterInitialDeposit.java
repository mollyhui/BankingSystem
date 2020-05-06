import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackEnd.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnterInitialDeposit extends JFrame {

	private JPanel contentPane;
	private JTextField textField_InitialDeposit;
	private String SSN;
	private String type;
	private JButton btnNewButton;
	private JButton btnBack;
	private JLabel lblToCreateNew_1;
	private JLabel lblToCreateNew_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String ssn,String type) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterInitialDeposit frame = new EnterInitialDeposit(ssn,type);
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
	public EnterInitialDeposit(String ssn,String type) {
		this.SSN= ssn;
		this.type=type;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTransfer = new JLabel("Customer");
		lblTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfer.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		textField_InitialDeposit = new JTextField();
		textField_InitialDeposit.setColumns(10);
		
		btnNewButton = new JButton("Ok");
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
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewAccounts create = new CreateNewAccounts(SSN);
				setVisible(false);
				create.setVisible(true);
				
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBackground(Color.RED);
		
		lblToCreateNew_1 = new JLabel("To create a new Account, please enter initial Deposit:");
		lblToCreateNew_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblToCreateNew_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblToCreateNew_2 = new JLabel("Remember you will be charged 10 dollars when creating a new account.");
		lblToCreateNew_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblToCreateNew_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addComponent(lblTransfer, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(129)
							.addComponent(lblToCreateNew_1, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(102, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(159)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 661, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(161))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(291)
					.addComponent(textField_InitialDeposit, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(689, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addComponent(lblToCreateNew_2)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTransfer, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblToCreateNew_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblToCreateNew_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(textField_InitialDeposit, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(33))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//Ok button performed
		private void okButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
			StringBuilder warnings = new StringBuilder();
			double amount = 0;
			int acc_number;
			if(textField_InitialDeposit.getText().isEmpty()) {
		    	   JOptionPane.showMessageDialog(this, "Error! Initial Deposit cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
		   }else {
		    	   try {
		    		   amount = Double.parseDouble(textField_InitialDeposit.getText());
		    		   
		    	   }
		    		   catch (NumberFormatException ex) {
		    			   JOptionPane.showMessageDialog(this, "Error! Initial deposit must be a number!","Input Error",JOptionPane.WARNING_MESSAGE);
		    			   warnings.append("InitialDeposit error");
		    			   
		    		   }
		       }
			if (amount<100.0) {
				   JOptionPane.showMessageDialog(this, "Initial deposit must be at least 100.0!","Input Error",JOptionPane.WARNING_MESSAGE);
				   warnings.append("InitialDeposit error");
			   }
			
			if (warnings.length()==0) {
				amount -=10.0;
				
				if (type.contentEquals("checkings")) {
					Account account = new Checking(amount);
					acc_number = Account.getNextAccountNumber();
	        	    AppBackup.addCheckingsAccount(SSN, Integer.toString(acc_number),amount,10.0);
	        	    
					
				}else if (type.contentEquals("savings")) {
					Account account = new Saving(amount);
					acc_number = Account.getNextAccountNumber();
	        	    AppBackup.addSavingsAccount(SSN, Integer.toString(acc_number),amount,10.0,0.0);
	        	    
					
				}else if (type.contentEquals("security")) {
					Account account = new SecurityAccount(amount);
					acc_number = Account.getNextAccountNumber();
	        	    AppBackup.addSecurityAccount(SSN, Integer.toString(acc_number),amount,10.0);
	        	    
					
				}
				JOptionPane.showMessageDialog(this,"Your account has been sucessfully created!");
				Double initial = Double.parseDouble(AppBackup.getUserAttribute("123-456-789", "manager", 3));
	       	    // manager will earn the open account fee
	       	    AppBackup.changeAttributeOfAll("manager",3,Double.toString((initial + 10.0)));
		   }
		}

}
