// Programmer Name : Britney Vassell
// Student ID # : 2105012
// Date : Nov 2, 2023
package view.customer;

// IMPORT JAVAX SWING COMPONENTS
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// IMPORT ACTION LISTENER COMPONENTS
import java.awt.event.*;

// IMPORT CUSTOMIZATION
import java.awt.*;

// IMPORT SQL COMPONENTS
import java.sql.*;

// IMPORT PROJECT CLASSES
import view.customer.CustomerLogIn;

public class CustomerRetrievalForm extends JFrame {
	
    // CREATE FRAME FOR APPLICATION
	private JFrame frame;
	private JPanel contentPane;
	private SpringLayout sl_contentPane;

	// CREATES LABELS FOR PANEL DATA
	private JLabel logoLabel;
	private JLabel searchLabel; 
	private JLabel emailLabel;

    // CREATES INPUT TYPES FOR PANEL DATA
	// ---------------------------------------- TEXT FIELD
	private JTextField emailTextField;

	// ---------------------------------------- BUTTON
	private JButton searchButton;
	private JButton backButton;

/* 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRetrievalForm frame = new CustomerRetrievalForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	// DEFAULT CONSTRUCTOR
	public CustomerRetrievalForm() {
		
		// FRAME CUSTOMIZATION
		setTitle("Grizzly's Entertainment & Equipment Rental | Customer Retrieval Form");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198,173,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
        
		// ---------------------------------------- PANEL LABELS AND HEADER
		logoLabel = new JLabel("G");

        searchLabel = new JLabel("SEARCH FOR APPOINTMENT"); 
        
        emailLabel = new JLabel("Email Address: ");

        // ---------------------------------------- PANEL LABEL PLACEMENTS
		sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 250, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, searchLabel, 6, SpringLayout.SOUTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, searchLabel, 130, SpringLayout.WEST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, emailLabel, 54, SpringLayout.NORTH, searchLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, emailLabel, 10, SpringLayout.WEST, contentPane);

        // ------------------------------------- PANEL LABEL FONT
		logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

		searchLabel.setFont(new Font("Courier New", Font.PLAIN, 24));
		
        emailLabel.setFont(new Font("Courier New", Font.PLAIN, 12));

        // ---------------------------------------- PANEL INPUT
		emailTextField = new JTextField();
        
        // ------------------------------------- PANEL BUTTONS
        searchButton = new JButton("Search Database");
		backButton = new JButton("Back");
        
        // ---------------------------------------- PANEL INPUT PLACEMENTS
		sl_contentPane.putConstraint(SpringLayout.NORTH, emailTextField, 6, SpringLayout.SOUTH, emailLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, emailTextField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, emailTextField, -10, SpringLayout.EAST, contentPane);		
        
        backButton.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 54, SpringLayout.SOUTH, emailTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -350, SpringLayout.EAST, contentPane);

		searchButton.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, searchButton, 54, SpringLayout.SOUTH, emailTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, searchButton,     350, SpringLayout.WEST, backButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, searchButton, -10, SpringLayout.EAST, contentPane);
        
        // ------------------------------------- PANEL INPUT FONTS
        emailTextField.setFont(new Font("Courier New", Font.PLAIN, 12));

		searchButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		backButton.setFont(new Font("Courier New", Font.PLAIN, 12));

        // ---------------------------------------- ADD PANEL LABELS
        contentPane.add(logoLabel);

        contentPane.add(searchLabel);
        contentPane.add(emailLabel);

        // ---------------------------------------- ADD PANEL INPUTS
        contentPane.add(emailTextField);

        contentPane.add(searchButton);
        contentPane.add(backButton);
        
       	// ACTION LISTENERS
		// ---------------------------------------- SEARCH BUTTON
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//search database for email entered
            	
            }
        }); // END OF ACT. LIS.
        
        // ---------------------------------------- BACK BUTTON
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new CustomerMainMenu().setVisible(true);
            	dispose();
            }
        }); // END OF ACT. LIS.
	} // END OF DEFAULT CONSTRUCTOR
} // END OF CUSTOMERRETRIEVALFORM CLASS
