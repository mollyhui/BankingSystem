import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackEnd.AppBackup;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loans extends JFrame {

	private JPanel contentPane;
	private String SSN;
	private JLabel Label_LoanInfo;
	private double curr_loan;
	private double interest;
	private JButton btnStartANew;
	private JButton btnRepay;
	private boolean hasLoan;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String ssn) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loans frame = new Loans(ssn);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Loans(String ssn) throws Exception {
		this.SSN = ssn;
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 422);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Customer");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		//check whether there is active loan for customer
		hasLoan = AppBackup.customerLoanExists(SSN);
		String prinInfo;
		if (hasLoan == false) {
			prinInfo =  "You don't have any active loan for now.";
			} else {
				curr_loan = Double.parseDouble(AppBackup.getUserAttribute(SSN,"customer",13));
				interest= Double.parseDouble(AppBackup.getUserAttribute(SSN,"customer",15));
				Double total = curr_loan+interest;
				prinInfo =  "You have a loan that needs to be paid. The amount of repayment for the loan is: " + total;
	    }
		
		
		Label_LoanInfo = new JLabel(prinInfo);
		Label_LoanInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label_LoanInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnStartANew = new JButton("Request your loan here!");
		btnStartANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					requestloanButtonActionPerformed(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnStartANew.setForeground(new Color(30, 144, 255));
		btnStartANew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnRepay = new JButton("Repay your loan here!");
		btnRepay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					returnloanButtonActionPerformed(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRepay.setForeground(new Color(0, 128, 128));
		btnRepay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnNewButton_1 = new JButton("MainMenu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mainMenu = new MainMenu();
		        setVisible(false);
		        mainMenu.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterLogin_Customer afterlogin = new AfterLogin_Customer(SSN);
				setVisible(false);
				afterlogin.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.exitButtonActionPerformed(e);
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(180)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(172)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
					.addGap(98))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addComponent(Label_LoanInfo, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
					.addGap(130))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(260, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRepay, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStartANew, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
					.addGap(256))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addComponent(Label_LoanInfo)
					.addGap(29)
					.addComponent(btnStartANew, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnRepay, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	//requestLoan button performed
		private void requestloanButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
		   if (hasLoan == true) {
			   JOptionPane.showMessageDialog(this, "You must return your debt before you can request a new loan!","Failed",JOptionPane.WARNING_MESSAGE);
		   }else {
			   JOptionPane.showMessageDialog(this, "You are eligible to make a new loan!");
			   RequestLoan loanPage = new RequestLoan(SSN);
			   setVisible(false);
			   loanPage.setVisible(true);
			   
		   }
		}
		   
		 //returnloan button performed
			private void returnloanButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
			   if (hasLoan == true) {
				   ReturnLoan loanPage = new ReturnLoan(SSN);
				   setVisible(false);
				   loanPage.setVisible(true);
			   }else {
				   JOptionPane.showMessageDialog(this, "You don't have a loan to be returned for now!","Failed",JOptionPane.WARNING_MESSAGE);
				   
			   }

		  
	    	   
	      
	       
	      
	       
	      
		}
}
