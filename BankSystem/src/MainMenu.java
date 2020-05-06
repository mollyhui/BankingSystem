
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

/**
 * functionss to have:
 *  DONE Create Customer User
 *  DONE Create Manager User
 *  DONE Customer Login
 *  DONE Manager Login
 *  Done Afterlogin page for customer:
 *  Done Afterlogin page for manager
 *  DONE create new account
 *  DONE Deposit
 *  DONE Withdrawl
 *  DONE Account Info(Customer Info)
 *  DONE aCCOUNT Info (Manager Info)
 *  DONE transfer done
 *  
 *  Stock
 *  loan
 *  Manager daily report
 *  Check Customer status
 * 
 *
 */
public class MainMenu extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 486);
		//set content panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Welcome label
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// new user label
		JLabel lblNewLabel_1 = new JLabel("New User? Create an Account you need here! ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		//login here label
		JLabel lblNewLabel_1_1 = new JLabel("Or login here!");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		//button for customer create account
		JButton btnSaving = new JButton("Customer");
		btnSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUser_Customer create_account = new CreateUser_Customer();
				setVisible(false);
				create_account.setVisible(true);
			}
		});
		btnSaving.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		//button for manager create account
		JButton btnManger = new JButton("Manager");
		btnManger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUser_Manager create_account = new CreateUser_Manager();
				setVisible(false);
				create_account.setVisible(true);
			}
		});
		btnManger.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		//customer login button
		JButton CustomerLoginButton = new JButton("Customer login");
		CustomerLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLogin account = new CustomerLogin();
				setVisible(false);
		        account.setVisible(true);
			}
		});
		CustomerLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		//manager login button
		JButton ManagerLoginButton = new JButton("Manager login");
		ManagerLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerLogin account = new ManagerLogin();
				setVisible(false);
		        account.setVisible(true);
				
			}
		});
		ManagerLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		//Exit button
		JButton ExitButton = new JButton("Exit");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitButtonActionPerformed(e);
				
			}
		});
		ExitButton.setBackground(Color.LIGHT_GRAY);
		ExitButton.setForeground(Color.RED);
		ExitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		
	
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(175, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addGap(145))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(168, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addGap(152))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSaving, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(CustomerLoginButton, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 255, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addGap(12)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(ManagerLoginButton, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addComponent(ExitButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnManger, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ExitButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSaving, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnManger, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ManagerLoginButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(CustomerLoginButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	//exit button action
	public static void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        JOptionPane.showMessageDialog(null,"Entire Programe Will be Closed !!","Close Alert",JOptionPane.WARNING_MESSAGE);
        System.exit(0);

    }
	

}
