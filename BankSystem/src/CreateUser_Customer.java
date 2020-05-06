

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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import BackEnd.*;

public class CreateUser_Customer extends JFrame {

	private JPanel contentPane;
	private JTextField txtPleaseFillOut;
	private JTextField textField_Name;
	private JTextField textField_SSN;
	private JTextField textField_Password;
	private JTextField textField_IntialDeposit;
	private JComboBox<String> comboBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser_Customer frame = new CreateUser_Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser_Customer().setVisible(true);
            }
        });
	}

	/**
	 * Create the frame.
	 */
	public CreateUser_Customer() {
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.exitButtonActionPerformed(e);
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_1_1 = new JButton("MainMenu");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuButtonActionPerformed(e);
			}
			
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Please remember you will be charged 100 dollars when you create a new user!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(220))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
											.addGap(87)
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
										.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 671, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addContainerGap(57, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)
							.addGap(83))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		txtPleaseFillOut = new JTextField();
		txtPleaseFillOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPleaseFillOut.setHorizontalAlignment(SwingConstants.CENTER);
		txtPleaseFillOut.setBackground(new Color(173, 216, 230));
		txtPleaseFillOut.setForeground(new Color(255, 0, 0));
		txtPleaseFillOut.setText("Please fill out the following information!");
		txtPleaseFillOut.setColumns(10);
		
		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("SSN:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_SSN = new JTextField();
		textField_SSN.setColumns(10);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Password:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_Name.setText("");
				textField_SSN.setText("");
				textField_Password.setText("");
				textField_IntialDeposit.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 0, 0));
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					okButtonActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnOk.setForeground(new Color(34, 139, 34));
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("InitialDeposit:");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_IntialDeposit = new JTextField();
		textField_IntialDeposit.setColumns(10);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Account Type");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Checking", "Saving", "Security"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(txtPleaseFillOut, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(104)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_2)
								.addComponent(lblNewLabel_1_1_2_1_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(91)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addGap(154)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_SSN, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
								.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Name, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(textField_Password, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addComponent(textField_IntialDeposit, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
							.addGap(77))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtPleaseFillOut, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(textField_Name, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_SSN, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_Password, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_2_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_IntialDeposit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	//Menu button performed
	private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainMenu mainMenu = new MainMenu();
        setVisible(false);
        mainMenu.setVisible(true);
        
    }
	//Ok button performed
	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
		StringBuilder warnings = new StringBuilder();
		String name = "",password = "",ssn = "";
		int acc_number;
		Account account;
	   double amount =0;
       if(textField_Name.getText().isEmpty()) {
    	   JOptionPane.showMessageDialog(this, "Error! Name cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
    	   warnings.append("Name error");
       }else {
    	   name = textField_Name.getText();
       }
    	   
       if(textField_SSN.getText().isEmpty()) {
    	   JOptionPane.showMessageDialog(this, "Error! SSN cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
    	   warnings.append("SSN error");
       }else {
    	   ssn = textField_SSN.getText();
       }
       if(textField_Password.getText().isEmpty()) {
    	   JOptionPane.showMessageDialog(this, "Error! Password cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
    	   warnings.append("Password error");
       }else {
    	  password  = textField_Password.getText();
       }
       if(textField_IntialDeposit.getText().isEmpty()) {
    	   JOptionPane.showMessageDialog(this, "Error! Initial Deposit cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
    	   warnings.append("InitialDeposit error");
       }else {
    	   try {
    		   amount = Double.parseDouble(textField_IntialDeposit.getText());
    		   
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
        	if (AppBackup.userExists("Customer",ssn)==true) {
         	   JOptionPane.showMessageDialog(this, "Error! The user with this SSN already exists!","Input Error",JOptionPane.WARNING_MESSAGE);
        	}else {
           //create a customer
    	   AppBackup.createCustomer(ssn,password,name);
    	   JOptionPane.showMessageDialog(this,"Your account has been sucessfully created!");
    	   amount -=100.0;
    	   //add account
           if (comboBox.getSelectedItem().toString()=="Checking") {
        	    account = new Checking(amount);
        	    acc_number = Account.getNextAccountNumber();
        	    AppBackup.addCheckingsAccount(ssn, Integer.toString(acc_number),amount,100.0);
        	    Double initial = Double.parseDouble(AppBackup.getUserAttribute("123-456-789", "manager", 3));
        	    // manager will earn the open account fee
        	    AppBackup.changeAttributeOfAll("manager",3,Double.toString((initial + 100.0)));
			
        	   
           }else if (comboBox.getSelectedItem().toString()=="Saving") {
        	   account = new Saving(amount);
       	       acc_number = Account.getNextAccountNumber();
       	       AppBackup.addSavingsAccount(ssn, Integer.toString(acc_number),amount,100.0,0.0);
       	       Double initial = Double.parseDouble(AppBackup.getUserAttribute("123-456-789", "manager", 3));
    	       // manager will earn the open account fee
    	       AppBackup.changeAttributeOfAll("manager",3,Double.toString((initial + 100.0)));
        	   
           }else{
        	   account = new SecurityAccount(amount);
       	       acc_number = Account.getNextAccountNumber();
       	       AppBackup.addSecurityAccount(ssn, Integer.toString(acc_number),amount,100.0);
       	       Double initial = Double.parseDouble(AppBackup.getUserAttribute("123-456-789", "manager", 3));
       	       // manager will earn the open account fee
       	       AppBackup.changeAttributeOfAll("manager",3,Double.toString((initial + 100.0)));
        	   
           }
       }
       
        
    }
	}
}
