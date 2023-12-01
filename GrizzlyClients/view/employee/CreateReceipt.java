package view.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateReceipt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField recNumField;
	private JTextField custIDField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateReceipt frame = new CreateReceipt();
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
	public CreateReceipt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 173, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel logoLabel = new JLabel("G");
		sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 98, SpringLayout.WEST, contentPane);
		logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));
		contentPane.add(logoLabel);

		JLabel lblCreateReceipt = new JLabel("CREATE RECEIPT");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCreateReceipt, 21, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCreateReceipt, 6, SpringLayout.EAST, logoLabel);
		lblCreateReceipt.setFont(new Font("Courier New", Font.BOLD, 22));
		contentPane.add(lblCreateReceipt);

		JLabel lblReceiptNumber = new JLabel("Receipt Number : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblReceiptNumber, 29, SpringLayout.SOUTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblReceiptNumber, 24, SpringLayout.WEST, contentPane);
		lblReceiptNumber.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(lblReceiptNumber);

		recNumField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, recNumField, -3, SpringLayout.NORTH, lblReceiptNumber);
		sl_contentPane.putConstraint(SpringLayout.WEST, recNumField, 56, SpringLayout.EAST, lblReceiptNumber);
		sl_contentPane.putConstraint(SpringLayout.EAST, recNumField, 192, SpringLayout.EAST, lblReceiptNumber);
		recNumField.setColumns(10);
		contentPane.add(recNumField);

		JLabel custID = new JLabel("Customer ID : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, custID, 17, SpringLayout.SOUTH, lblReceiptNumber);
		sl_contentPane.putConstraint(SpringLayout.WEST, custID, 24, SpringLayout.WEST, contentPane);
		custID.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(custID);

		JLabel equipID = new JLabel("Equipment ID : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, equipID, 21, SpringLayout.SOUTH, custID);
		sl_contentPane.putConstraint(SpringLayout.WEST, equipID, 0, SpringLayout.WEST, lblReceiptNumber);
		equipID.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(equipID);

		custIDField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, custIDField, -136, SpringLayout.EAST, recNumField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, custIDField, 0, SpringLayout.SOUTH, custID);
		sl_contentPane.putConstraint(SpringLayout.EAST, custIDField, 0, SpringLayout.EAST, recNumField);
		custIDField.setColumns(10);
		contentPane.add(custIDField);

		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, -136, SpringLayout.EAST, recNumField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, equipID);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, recNumField);
		textField.setColumns(10);
		contentPane.add(textField);

		JLabel cost = new JLabel("Rental Cost :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cost, 24, SpringLayout.SOUTH, equipID);
		sl_contentPane.putConstraint(SpringLayout.WEST, cost, 0, SpringLayout.WEST, lblReceiptNumber);
		cost.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(cost);

		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, -136, SpringLayout.EAST, recNumField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_1, 0, SpringLayout.SOUTH, cost);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, recNumField);
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		JLabel lblDate = new JLabel("Date :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDate, 18, SpringLayout.SOUTH, cost);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDate, 0, SpringLayout.WEST, lblReceiptNumber);
		lblDate.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(lblDate);

		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, -136, SpringLayout.EAST, recNumField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_2, 0, SpringLayout.SOUTH, lblDate);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, recNumField);
		textField_2.setColumns(10);
		contentPane.add(textField_2);

		JButton goBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.NORTH, goBack, 42, SpringLayout.SOUTH, lblDate);
		sl_contentPane.putConstraint(SpringLayout.WEST, goBack, 0, SpringLayout.WEST, lblReceiptNumber);
		goBack.setFont(new Font("Courier New", Font.PLAIN, 11));
		goBack.setBackground(Color.WHITE);
		contentPane.add(goBack);

		JButton save = new JButton("Save");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, save, 0, SpringLayout.SOUTH, goBack);
		sl_contentPane.putConstraint(SpringLayout.EAST, save, -22, SpringLayout.EAST, contentPane);
		save.setFont(new Font("Courier New", Font.PLAIN, 11));
		save.setBackground(Color.WHITE);
		contentPane.add(save);

		// Add Button Functionality
		goBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dispose();
				new EmployeeCreate().setVisible(true);
			}

		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Successfully Created Receipt", "Status",
						JOptionPane.INFORMATION_MESSAGE);
			}

		});
	}

}
