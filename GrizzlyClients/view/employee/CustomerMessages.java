package view.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CustomerMessages extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField custIDField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMessages frame = new CustomerMessages();
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
	public CustomerMessages() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 173, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel logoLabel = new JLabel("G");
		sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 91, SpringLayout.WEST, contentPane);
		logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));
		contentPane.add(logoLabel);

		JLabel lblCustomerMessages = new JLabel("CUSTOMER MESSAGES");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCustomerMessages, 6, SpringLayout.EAST, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblCustomerMessages, 0, SpringLayout.SOUTH, logoLabel);
		lblCustomerMessages.setFont(new Font("Courier New", Font.BOLD, 22));
		contentPane.add(lblCustomerMessages);

		JLabel custID = new JLabel("Customer ID : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, custID, 41, SpringLayout.SOUTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, custID, 26, SpringLayout.WEST, contentPane);
		custID.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(custID);

		custIDField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, custIDField, -3, SpringLayout.NORTH, custID);
		sl_contentPane.putConstraint(SpringLayout.WEST, custIDField, 25, SpringLayout.EAST, custID);
		sl_contentPane.putConstraint(SpringLayout.EAST, custIDField, 162, SpringLayout.EAST, custID);
		custIDField.setColumns(10);
		contentPane.add(custIDField);

		JButton fetch = new JButton("Fetch");
		sl_contentPane.putConstraint(SpringLayout.NORTH, fetch, -3, SpringLayout.NORTH, custID);
		sl_contentPane.putConstraint(SpringLayout.WEST, fetch, 39, SpringLayout.EAST, custIDField);
		fetch.setFont(new Font("Courier New", Font.PLAIN, 11));
		fetch.setBackground(Color.WHITE);
		contentPane.add(fetch);

		JLabel message = new JLabel("Write your message here:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, message, 36, SpringLayout.SOUTH, custID);
		sl_contentPane.putConstraint(SpringLayout.WEST, message, 0, SpringLayout.WEST, custID);
		message.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(message);

		JTextArea messageArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, messageArea, 19, SpringLayout.SOUTH, message);
		sl_contentPane.putConstraint(SpringLayout.WEST, messageArea, 0, SpringLayout.WEST, custID);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, messageArea, 138, SpringLayout.SOUTH, message);
		sl_contentPane.putConstraint(SpringLayout.EAST, messageArea, 283, SpringLayout.WEST, contentPane);
		contentPane.add(messageArea);

		JButton goBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.WEST, goBack, 0, SpringLayout.WEST, custID);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, goBack, -10, SpringLayout.SOUTH, contentPane);
		goBack.setFont(new Font("Courier New", Font.PLAIN, 11));
		goBack.setBackground(Color.WHITE);
		contentPane.add(goBack);

		JButton send = new JButton("Send");
		sl_contentPane.putConstraint(SpringLayout.NORTH, send, 0, SpringLayout.NORTH, goBack);
		sl_contentPane.putConstraint(SpringLayout.EAST, send, 0, SpringLayout.EAST, fetch);
		send.setFont(new Font("Courier New", Font.PLAIN, 11));
		send.setBackground(Color.WHITE);
		contentPane.add(send);

		// Add Button Functionality
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dispose();
				new EmployeeCreate().setVisible(true);
			}
		});
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Successfully Scheduled Equipment", "Status",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

}
