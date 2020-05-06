

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AfterLogin_Manager extends JFrame {

	private JPanel contentPane;
	private String SSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String ssn) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterLogin_Manager frame = new AfterLogin_Manager(ssn);
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
	public AfterLogin_Manager(String ssn) {
		this.SSN = ssn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Manager");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		JLabel lblNewLabel = new JLabel("Please choose your action.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(106, 90, 205));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnChangePassword = new JButton("Account Info");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerInfo managerinfo;
				try {
					managerinfo = new ManagerInfo(SSN);
					setVisible(false);
					managerinfo.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnChangePassword.setForeground(new Color(165, 42, 42));
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnCustomerInfo = new JButton("Check Customers");
		btnCustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CheckCustomer checkcustomer = new CheckCustomer();
		        setVisible(false);
		        checkcustomer.setVisible(true);
			}
		});
		btnCustomerInfo.setForeground(new Color(165, 42, 42));
		btnCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnDailyReport = new JButton("Daily Report");
		btnDailyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DailyReport_Manager report = new DailyReport_Manager(SSN);
				setVisible(false);
				report.setVisible(true);
			}
		});
		btnDailyReport.setForeground(new Color(165, 42, 42));
		btnDailyReport.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnManageStock = new JButton("Add Stock");
		btnManageStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStock_Manager create = new AddStock_Manager(SSN);
				setVisible(false);
				create.setVisible(true);
			}
		});
		btnManageStock.setForeground(new Color(165, 42, 42));
		btnManageStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnDeletStock = new JButton("Delete Stock");
		btnDeletStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStock_Manager delete = new DeleteStock_Manager(SSN);
				setVisible(false);
				delete.setVisible(true);
				
			}
		});
		btnDeletStock.setForeground(new Color(165, 42, 42));
		btnDeletStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mainMenu = new MainMenu();
		        setVisible(false);
		        mainMenu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(255, 215, 0));
		
		JButton btnViewStock = new JButton("View Stock");
		btnViewStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMarketStock_Manager view = new ViewMarketStock_Manager(SSN);
				setVisible(false);
				view.setVisible(true);
				
			}
		});
		btnViewStock.setForeground(new Color(165, 42, 42));
		btnViewStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(85, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
							.addGap(170))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnViewStock, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnManageStock, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDailyReport))
							.addGap(68)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(67)
									.addComponent(btnDeletStock)
									.addGap(22))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnCustomerInfo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addGap(38))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCustomerInfo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDailyReport, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDeletStock, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnManageStock, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addGap(41))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnViewStock, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(40))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
