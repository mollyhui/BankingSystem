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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StockMarket extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Purchase;
	private JTextField textField_Sell;
	private String SSN;
	private JComboBox ShareBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String ssn) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockMarket frame = new StockMarket(ssn);
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
	public StockMarket(String ssn) {
		this.SSN = ssn;
		JFileChooser fc = new JFileChooser();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 516);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Stock Market");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 22));
		
		JButton btnNewButton = new JButton("Show Stocks(Market)");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    String textLine;
				    FileReader fr = new FileReader("StockMarket.txt");
				    BufferedReader reader = new BufferedReader(fr);
				   
				     textArea.read(reader, "textArea");
				    }
	            catch (IOException ioe) {
				    System.err.println(ioe);
				    System.exit(1);
				}
				
			}
				
			});
		
		JLabel lblNewLabel_1_1 = new JLabel("(Stock name,price)");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Purchase:");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_Purchase = new JTextField();
		textField_Purchase.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(" input the stock name and select number of shares");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JButton btnNewButton_1 = new JButton("Purchase");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					purchaseButtonActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(30, 144, 255));
		
		JLabel lblSell = new JLabel("Sell:");
		lblSell.setHorizontalAlignment(SwingConstants.CENTER);
		lblSell.setForeground(new Color(255, 0, 0));
		lblSell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Or");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_Sell = new JTextField();
		textField_Sell.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("Sell");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sellButtonActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 0, 0));
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterLogin_Customer afterlogin = new AfterLogin_Customer(SSN);
		        setVisible(false);
		        afterlogin.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		ShareBox = new JComboBox();
		ShareBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ShareBox.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20"}));
		
		JLabel lblNumberOfShares = new JLabel("Number of shares:");
		lblNumberOfShares.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfShares.setForeground(new Color(0, 0, 0));
		lblNumberOfShares.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(46)
											.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(36)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblSell, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_contentPane.createSequentialGroup()
																	.addComponent(lblNumberOfShares, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
																	.addPreferredGap(ComponentPlacement.RELATED)))
															.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPane.createSequentialGroup()
																	.addGap(4)
																	.addComponent(textField_Purchase, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_contentPane.createSequentialGroup()
																	.addPreferredGap(ComponentPlacement.RELATED)
																	.addComponent(textField_Sell, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_contentPane.createSequentialGroup()
																	.addGap(17)
																	.addComponent(ShareBox, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))))
													.addGap(12))
												.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
													.addGap(63)))
											.addGap(75))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
											.addComponent(btnNewButton_1)
											.addGap(134))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
									.addGap(119)))
							.addGap(46))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(217)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
							.addGap(145))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(36)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNumberOfShares, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(ShareBox, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_Purchase, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(33)))
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1_1)
								.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(214)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSell, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Sell, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addGap(57))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//purchase button performed
		private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
		   StringBuilder warnings = new StringBuilder();
		   int share = Integer.parseInt(ShareBox.getSelectedItem().toString());
		   
		   
		   String name;
		   double amount;
		   
		   
		   double security_balance = Double.parseDouble(AppBackup.getUserAttribute(SSN,"customer", 11));
		   if(textField_Purchase.getText().isEmpty()) {
	    	   JOptionPane.showMessageDialog(this, "Error! Name cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
	    	   warnings.append("error");
	       }else {
	    	   name = textField_Purchase.getText();
	    	   if (AppBackup.stockExists(name)==false) {
				   JOptionPane.showMessageDialog(this, "not a valid stock!","Input Error",JOptionPane.WARNING_MESSAGE);
		    	   warnings.append("error");
			   }else {
				      boolean hold = AppBackup.stockExistsCustomer(SSN,name);
				      amount = Double.parseDouble(AppBackup.getStockAttribute(name, 1));
				      amount = amount*share;
				      if (amount > security_balance) {
				    	  JOptionPane.showMessageDialog(this, "Error! Your balance in security account is not enough to purchase!","Input Error",JOptionPane.WARNING_MESSAGE);
				    	   warnings.append("error");
				      }else {
				    	  if (hold == false) {
				    	  //create customer stock
				          AppBackup.createCustomerStock(SSN, name, share);
				          
				          }else {
				        	  int initial_share= Integer.parseInt(AppBackup.getCustomerShare(SSN,name));
				        	  AppBackup.updateCustomerStockAttribute(SSN, name, 2, Integer.toString(initial_share+share));
				          }
				    	  //update balance of security
				    	  AppBackup.updateUserAttribute(SSN, "customer", 11, Double.toString(security_balance-amount));
				    	  JOptionPane.showMessageDialog(this,"Your have purchase the stock!");
				    	  AppBackup.createTransactionRecord(SSN, "StockPurchased", amount, 6, 5, 2020);
				      }
			   }
	       }
		}
	
		   
	    	   
	    
		//sell button performed
				private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_okButtonActionPerformed
				   StringBuilder warnings = new StringBuilder();
				   int share = Integer.parseInt(ShareBox.getSelectedItem().toString());
				   
				   String name;
				   double amount;
				   
				   double security_balance = Double.parseDouble(AppBackup.getUserAttribute(SSN,"customer", 11));
				   if(textField_Sell.getText().isEmpty()) {
			    	   JOptionPane.showMessageDialog(this, "Error! Name cannot be empty!","Input Error",JOptionPane.WARNING_MESSAGE);
			    	   warnings.append("error");
			       }else {
			    	   name = textField_Sell.getText();
			    	   if (AppBackup.stockExistsCustomer(SSN,name)==false) {
						   JOptionPane.showMessageDialog(this, "You don't have this stock!","Input Error",JOptionPane.WARNING_MESSAGE);
				    	   warnings.append("error");
					   }else {
						   int initial_share= Integer.parseInt(AppBackup.getCustomerShare(SSN,name));
						   
						   if (share > initial_share) {
							   JOptionPane.showMessageDialog(this, "You don't have that much shares!","Input Error",JOptionPane.WARNING_MESSAGE);
					    	   warnings.append("error");
						   }else {
							  AppBackup.updateCustomerStockAttribute(SSN, name, 2, Integer.toString(initial_share-share));
						      amount = Double.parseDouble(AppBackup.getStockAttribute(name, 1));
						      amount = amount * share;
						      
						    AppBackup.updateUserAttribute(SSN, "customer", 11, Double.toString(security_balance+amount));
						    JOptionPane.showMessageDialog(this,"Your have sold the stock!");
						    AppBackup.createTransactionRecord(SSN, "Stock Sold", amount, 6, 5, 2020);
						    }
						    	  
						 }
					}
			   }
			
				   
}		    	   
			  
