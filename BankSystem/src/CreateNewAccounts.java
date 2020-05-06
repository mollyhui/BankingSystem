import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackEnd.AppBackup;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import BackEnd.*;

public class CreateNewAccounts extends JFrame {

	private JPanel contentPane;
	private String SSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String ssn) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewAccounts frame = new CreateNewAccounts(ssn);
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
	public CreateNewAccounts(String ssn) {
		this.SSN=ssn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCreateNewAccounts = new JLabel("Create New Accounts");
		lblCreateNewAccounts.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewAccounts.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the type you want to create");
		lblPleaseSelectThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectThe.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton btnNewButton = new JButton("Checking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkingButtonActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(46, 139, 87));
		
		JButton btnSaving = new JButton("Saving");
		btnSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					savingButtonActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSaving.setForeground(new Color(46, 139, 87));
		btnSaving.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSecurity = new JButton("Security");
		btnSecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					securityButtonActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSecurity.setForeground(new Color(46, 139, 87));
		btnSecurity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterLogin_Customer afterlogin = new AfterLogin_Customer(SSN);
				setVisible(false);
				afterlogin.setVisible(true);
				
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(150)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPleaseSelectThe, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCreateNewAccounts, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(149, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(110)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSaving, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
							.addComponent(btnSecurity, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(42))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblCreateNewAccounts, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPleaseSelectThe, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaving, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSecurity, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	      //checking button performed
			private void checkingButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
				
				boolean account_exist = AppBackup.customerAccountExists(SSN,"checkings");
				if (account_exist) {
					JOptionPane.showMessageDialog(this, "You already have one checkings account!","Error",JOptionPane.WARNING_MESSAGE);
				}else {
					EnterInitialDeposit enterDeposit = new EnterInitialDeposit(SSN,"checkings");
					setVisible(false);
					enterDeposit.setVisible(true);
				}
			}
			
			
			//saving button performed
			private void savingButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
				
				boolean account_exist = AppBackup.customerAccountExists(SSN,"savings");
				if (account_exist) {
					JOptionPane.showMessageDialog(this, "You already have one savings account!","Error",JOptionPane.WARNING_MESSAGE);
				}else {
					EnterInitialDeposit enterDeposit = new EnterInitialDeposit(SSN,"savings");
					setVisible(false);
					enterDeposit.setVisible(true);
				}
			}
			//seurity button performed
			private void securityButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
				StringBuilder warnings = new StringBuilder();
				boolean account_exist = AppBackup.customerAccountExists(SSN,"security");
				if (account_exist) {
					JOptionPane.showMessageDialog(this, "You already have one security account!","Error",JOptionPane.WARNING_MESSAGE);
				}else {
					EnterInitialDeposit enterDeposit = new EnterInitialDeposit(SSN,"security");
					setVisible(false);
					enterDeposit.setVisible(true);
				}
				
				
			}
				
		       
		        

}
