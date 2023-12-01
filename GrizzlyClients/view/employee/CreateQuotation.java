package view.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CreateQuotation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateQuotation frame = new CreateQuotation();
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
	public CreateQuotation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 173, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel logoLabel = new JLabel("G");
		sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 111, SpringLayout.WEST, contentPane);
		logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));
		contentPane.add(logoLabel);

		JLabel lblCreateQuotation = new JLabel("CREATE QUOTATION");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCreateQuotation, 6, SpringLayout.EAST, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblCreateQuotation, 0, SpringLayout.SOUTH, logoLabel);
		lblCreateQuotation.setFont(new Font("Courier New", Font.BOLD, 22));
		contentPane.add(lblCreateQuotation);

		JLabel custID = new JLabel("Customer ID : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, custID, 30, SpringLayout.SOUTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, custID, 0, SpringLayout.EAST, logoLabel);
		custID.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(custID);

		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, custID);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 39, SpringLayout.EAST, custID);
		textField.setColumns(10);
		contentPane.add(textField);

		JButton fetch = new JButton("Fetch");
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -49, SpringLayout.WEST, fetch);
		sl_contentPane.putConstraint(SpringLayout.NORTH, fetch, -3, SpringLayout.NORTH, custID);
		sl_contentPane.putConstraint(SpringLayout.EAST, fetch, -35, SpringLayout.EAST, contentPane);
		fetch.setFont(new Font("Courier New", Font.PLAIN, 11));
		fetch.setBackground(Color.WHITE);
		contentPane.add(fetch);

		JLabel lblWriteMessageHere = new JLabel("Write quotation message here :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblWriteMessageHere, 18, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWriteMessageHere, 0, SpringLayout.WEST, custID);
		lblWriteMessageHere.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(lblWriteMessageHere);

		JTextArea messageArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, messageArea, 6, SpringLayout.SOUTH, lblWriteMessageHere);
		sl_contentPane.putConstraint(SpringLayout.WEST, messageArea, 0, SpringLayout.WEST, custID);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, messageArea, 117, SpringLayout.SOUTH, lblWriteMessageHere);
		sl_contentPane.putConstraint(SpringLayout.EAST, messageArea, 240, SpringLayout.WEST, custID);
		contentPane.add(messageArea);

		JButton goBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.WEST, goBack, 0, SpringLayout.WEST, custID);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, goBack, -21, SpringLayout.SOUTH, contentPane);
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
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EmployeeCreate().setVisible(true);
			}

		});
		fetch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
			}

		});
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Successfully Created Quotation", "Status",
						JOptionPane.INFORMATION_MESSAGE);
			}

		});
	}

}
