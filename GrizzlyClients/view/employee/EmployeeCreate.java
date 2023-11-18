// Programmer Name : Nathalea Evans
// Student ID # : 2101707
// Date : Nov 6, 2023

package com.view.employee;

// Imports
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.view.menu.EmployeeMainMenu;

public class EmployeeCreate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeCreate frame = new EmployeeCreate();
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
	public EmployeeCreate() {

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 173, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("Choose What You Want To Create");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -176, SpringLayout.SOUTH, contentPane);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 13));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("G");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 230, SpringLayout.WEST, contentPane);
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.BOLD, 32));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CREATE MENU");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 5, SpringLayout.EAST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, -188, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD, 22));
		contentPane.add(lblNewLabel_2);

		JButton createInvoice = new JButton("Invoice\r\n");
		sl_contentPane.putConstraint(SpringLayout.WEST, createInvoice, 176, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, createInvoice, -176, SpringLayout.EAST, contentPane);
		createInvoice.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, createInvoice, 22, SpringLayout.SOUTH, lblNewLabel);
		createInvoice.setFont(new Font("Courier New", Font.PLAIN, 11));

		contentPane.add(createInvoice);

		JButton createReceipt = new JButton("Receipt");
		sl_contentPane.putConstraint(SpringLayout.WEST, createReceipt, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, createReceipt, -176, SpringLayout.EAST, contentPane);
		createReceipt.setBackground(new Color(255, 255, 255));
		createReceipt.setFont(new Font("Courier New", Font.PLAIN, 11));
		contentPane.add(createReceipt);

		JButton createQuotation = new JButton("Quotation");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, createReceipt, -12, SpringLayout.NORTH, createQuotation);
		sl_contentPane.putConstraint(SpringLayout.NORTH, createQuotation, 207, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, createQuotation, -54, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, createQuotation, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, createQuotation, 0, SpringLayout.EAST, createInvoice);
		createQuotation.setFont(new Font("Courier New", Font.PLAIN, 11));
		createQuotation.setBackground(new Color(255, 255, 255));
		contentPane.add(createQuotation);

		JButton goBack = new JButton("Back");
		goBack.setBackground(new Color(255, 255, 255));
		goBack.setFont(new Font("Courier New", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, goBack, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, goBack, -10, SpringLayout.EAST, contentPane);
		contentPane.add(goBack);

		// Add Button Functionality
		createInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateInvoice createInvoice = new CreateInvoice();
				createInvoice.setVisible(true);
				dispose();
			}
		});

		createReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateReceipt createReceipt = new CreateReceipt();
				createReceipt.setVisible(true);
				dispose();
			}
		});

		createQuotation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateQuotation createQuotation = new CreateQuotation();
				createQuotation.setVisible(true);
				dispose();
			}
		});

		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeMainMenu employeeMenu = new EmployeeMainMenu();
				employeeMenu.setVisible(true);
				dispose();
			}
		});
	}
}
