
// Programmer Name : Nathalea Evans
// Student ID # : 2101707
// Date : Nov 6, 2023

package view.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CreateInvoice extends JFrame {

	// Private Attributes
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField invField;
	private JTextField equipIDField;
	private JTextField custIDField;
	private JTextField renCostField;
	private JTextField textField;

	private String url = "jdbc:mysql://localhost:3307/grizzlyentertainment";
	private String user = "root";
	private String pass = "usbw";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateInvoice frame = new CreateInvoice();
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
	public CreateInvoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 173, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel logoLabel = new JLabel("G");
		sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, logoLabel, -306, SpringLayout.EAST, contentPane);
		logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));
		contentPane.add(logoLabel);

		JLabel lblCreateInvoice = new JLabel("CREATE INVOICE");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCreateInvoice, 9, SpringLayout.NORTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCreateInvoice, 6, SpringLayout.EAST, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCreateInvoice, -118, SpringLayout.EAST, contentPane);
		lblCreateInvoice.setFont(new Font("Courier New", Font.BOLD, 22));
		contentPane.add(lblCreateInvoice);

		JLabel invoiceNum = new JLabel("Invoice Number : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, invoiceNum, 35, SpringLayout.SOUTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, invoiceNum, 24, SpringLayout.WEST, contentPane);
		invoiceNum.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(invoiceNum);

		invField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, invField, -3, SpringLayout.NORTH, invoiceNum);
		sl_contentPane.putConstraint(SpringLayout.WEST, invField, 28, SpringLayout.EAST, invoiceNum);
		sl_contentPane.putConstraint(SpringLayout.EAST, invField, 164, SpringLayout.EAST, invoiceNum);
		contentPane.add(invField);
		invField.setColumns(10);

		JLabel equipID = new JLabel("Equipment ID : ");
		equipID.setFont(new Font("Courier New", Font.PLAIN, 13));
		sl_contentPane.putConstraint(SpringLayout.NORTH, equipID, 33, SpringLayout.SOUTH, invoiceNum);
		sl_contentPane.putConstraint(SpringLayout.WEST, equipID, 0, SpringLayout.WEST, invoiceNum);
		contentPane.add(equipID);

		equipIDField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, equipIDField, -3, SpringLayout.NORTH, equipID);
		sl_contentPane.putConstraint(SpringLayout.WEST, equipIDField, 0, SpringLayout.WEST, invField);
		sl_contentPane.putConstraint(SpringLayout.EAST, equipIDField, 180, SpringLayout.EAST, equipID);
		contentPane.add(equipIDField);
		equipIDField.setColumns(10);

		JButton goBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.WEST, goBack, 118, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, goBack, -22, SpringLayout.SOUTH, contentPane);
		goBack.setFont(new Font("Courier New", Font.PLAIN, 11));
		goBack.setBackground(new Color(255, 255, 255));
		contentPane.add(goBack);

		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, save, 73, SpringLayout.EAST, goBack);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, save, 0, SpringLayout.SOUTH, goBack);
		save.setFont(new Font("Courier New", Font.PLAIN, 11));
		save.setBackground(Color.WHITE);
		contentPane.add(save);

		JLabel custID = new JLabel("Customer ID : ");
		custID.setFont(new Font("Courier New", Font.PLAIN, 13));
		sl_contentPane.putConstraint(SpringLayout.NORTH, custID, 26, SpringLayout.SOUTH, equipID);
		sl_contentPane.putConstraint(SpringLayout.WEST, custID, 0, SpringLayout.WEST, invoiceNum);
		contentPane.add(custID);

		custIDField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, custIDField, -3, SpringLayout.NORTH, custID);
		sl_contentPane.putConstraint(SpringLayout.WEST, custIDField, 0, SpringLayout.WEST, invField);
		sl_contentPane.putConstraint(SpringLayout.EAST, custIDField, 0, SpringLayout.EAST, invField);
		custIDField.setColumns(10);
		contentPane.add(custIDField);

		JLabel cost = new JLabel("Rental Cost :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cost, 25, SpringLayout.SOUTH, custID);
		sl_contentPane.putConstraint(SpringLayout.WEST, cost, 0, SpringLayout.WEST, invoiceNum);
		cost.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(cost);

		renCostField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, renCostField, -3, SpringLayout.NORTH, cost);
		sl_contentPane.putConstraint(SpringLayout.WEST, renCostField, 0, SpringLayout.WEST, invField);
		sl_contentPane.putConstraint(SpringLayout.EAST, renCostField, 196, SpringLayout.EAST, cost);
		renCostField.setColumns(10);
		contentPane.add(renCostField);

		JLabel lblDate = new JLabel("Date :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDate, 17, SpringLayout.SOUTH, cost);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDate, 0, SpringLayout.WEST, invoiceNum);
		lblDate.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(lblDate);

		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblDate);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, invField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 252, SpringLayout.EAST, lblDate);
		textField.setColumns(10);
		contentPane.add(textField);

		// Add Functionality
		goBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EmployeeCreate().setVisible(true);
			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String invNumString = invField.getText().trim();
				String equipIDString = equipIDField.getText().trim();
				String custIDString = custIDField.getText().trim();
				String renCostString = renCostField.getText().trim();
				String dateString = textField.getText().trim();

				// Exception Management

				String query = "INSERT INTO invoice VALUES ('" + invNumString + "', '" + equipIDString + "', '"
						+ custIDString + "', '" + renCostString + "', '" + dateString + "')";
				Statement stmt;

				// Connect to database
				Connection myConn;
				try {
					myConn = DriverManager.getConnection(url, user, pass);
					stmt = myConn.createStatement();
					stmt.executeUpdate(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Successfully Created Invoice", "Status",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
