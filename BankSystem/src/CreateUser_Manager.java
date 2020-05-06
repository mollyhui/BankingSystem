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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import BackEnd.AppBackup;

public class CreateUser_Manager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_SSN;
	private JTextField textField_Name;
	private JTextField textField_Password;
	private JTextField textField_InitialBalance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser_Manager frame = new CreateUser_Manager();
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
	public CreateUser_Manager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Create User_Manager");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		
		textField = new JTextField();
		textField.setText("Please fill out the following information!");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.RED);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(173, 216, 230));
		
		JLabel lblNewLabel_1_2 = new JLabel("Name:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1_1_3 = new JLabel("SSN:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Password:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_SSN = new JTextField();
		textField_SSN.setColumns(10);
		
		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		
		JButton btnOk_1 = new JButton("Ok");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					okButtonActionPerformed(e);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnOk_1.setForeground(new Color(34, 139, 34));
		btnOk_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_SSN.setText("");
				textField_Name.setText("");
				textField_Password.setText("");
				textField_InitialBalance.setText("");
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Add Deposit:");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_InitialBalance = new JTextField();
		textField_InitialBalance.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(76)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
							.addComponent(btnOk_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(104)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_2)
								.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_2_1_1))
							.addGap(187)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_InitialBalance, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
								.addComponent(textField_SSN, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
								.addComponent(textField_Name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
								.addComponent(textField_Password, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))
					.addGap(77))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(textField_Password, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_2_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_InitialBalance, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(57)
							.addComponent(btnOk_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 671, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 438, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(82))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(237, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
					.addGap(228))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//Ok button performed
		private void okButtonActionPerformed(java.awt.event.ActionEvent evt) throws NumberFormatException, Exception {//GEN-FIRST:event_okButtonActionPerformed
			StringBuilder warnings = new StringBuilder();
			String name = "",password = "",ssn="";
			Double start_balance = 0.0;
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
	       if(textField_InitialBalance.getText().isEmpty()) {
	    	   JOptionPane.showMessageDialog(this, "Error! Deposit you want to add cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
	    	   warnings.append("InitialDeposit error");
	       }else {
	    	   try {
	    		   start_balance = Double.parseDouble(textField_InitialBalance.getText());
	    	   }
	    		   catch (NumberFormatException ex) {
	    			   JOptionPane.showMessageDialog(this, "Error! Deposit you want to add must be a number!","Input Error",JOptionPane.WARNING_MESSAGE);
	    			   warnings.append("InitialDeposit error");
	    		   }
	       }
	       
	       
	       if (AppBackup.userExists("manager",ssn)==true) {
	    	   JOptionPane.showMessageDialog(this, "Error! The user with this SSN already exists!","Input Error",JOptionPane.WARNING_MESSAGE);
	       
	    	   
	       }else if (warnings.length()==0) {
	    	   //create manager
	    	   try {
				AppBackup.createManager(ssn,password,name,0.0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   JOptionPane.showMessageDialog(this,"Your account has been sucessfully created!");
	    	   Double initial_balance = Double.parseDouble(AppBackup.getUserAttribute("123-456-789", "manager", 3));
	      	   // manager will earn the open account fee
	      	   AppBackup.changeAttributeOfAll("manager",3,Double.toString((initial_balance + start_balance)));
	           
	       }
	       
	        
	    }
}
