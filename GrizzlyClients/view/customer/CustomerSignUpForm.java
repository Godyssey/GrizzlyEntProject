// Programmer Name : Britney Vassell
// Student ID # : 2105012
// Date : Nov 2, 2023
package view.customer;

// IMPORT JAVAX SWING COMPONENTS
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

// IMPORT ACTION LISTENER
import java.awt.event.*;
import java.io.IOException;
// IMPORT CUSTOMIZATION
import java.awt.*;

// IMPORT
import java.text.ParseException;
import java.util.Random;

import view.customer.CustomerMainMenu;
import view.customer.GrizzMainMenu;
import controller.CustomerClient;
import model.Customer;

public class CustomerSignUpForm extends JFrame {

	// CREATE FRAME FOR APPLICATION
	private JPanel contentPane;
	private SpringLayout sl_contentPane;

	// CREATES LABELS FOR PANEL DATA
	private JLabel logoLabel;
	private JLabel cFormTitle1; 
	private JLabel cFormTitle2; 
	private JLabel firstNameLabel; 
	private JLabel lastNameLabel; 
	private JLabel emailLabel; 
	private JLabel genderLabel; 
	private JLabel phoneNumberLabel; 

	private JLabel username;
	private JLabel password;

	// CREATES INPUT TYPES FOR PANEL DATA
	// ---------------------------------------- TEXT FIELD
	private MaskFormatter formatted;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JFormattedTextField phoneNumberTextField;

	private JTextField usernameField;
	private JPasswordField passwordField;

	// ---------------------------------------- BUTTON
	private JRadioButton maleRadioButton; 
	private JRadioButton femaleRadioButton; 
	private ButtonGroup genderGroup;	   
	
	private JButton nextButton;
	private JButton backButton;

/* 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSignForm frame = new CustomerSignForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	// DEFAULT CONSTRUCTOR
	public CustomerSignUpForm() {

		// FRAME CUSTOMIZATION
		setTitle("Grizzly's Entertainment & Equipment Rental | Customer Sign Up Form");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198,173,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		// ---------------------------------------- PANEL LABELS AND HEADER
		logoLabel = new JLabel("G");
		
		cFormTitle1 = new JLabel("NEW CUSTOMER"); 
		cFormTitle2 = new JLabel("SIGN UP"); 
		
		firstNameLabel = new JLabel("First Name: ");
		lastNameLabel = new JLabel("Last Name: ");
		emailLabel = new JLabel("Email Address: ");
		genderLabel = new JLabel("Gender: ");
		phoneNumberLabel = new JLabel("Phone Number: ");

		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		
		// ---------------------------------------- PANEL LABEL PLACEMENTS
		sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 200, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, cFormTitle1, 6, SpringLayout.SOUTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, cFormTitle1, 130, SpringLayout.WEST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, cFormTitle2, 16, SpringLayout.SOUTH, cFormTitle1);
		sl_contentPane.putConstraint(SpringLayout.WEST, cFormTitle2, 180, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, firstNameLabel, 34, SpringLayout.NORTH, cFormTitle2);
		sl_contentPane.putConstraint(SpringLayout.WEST, firstNameLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, lastNameLabel, 54, SpringLayout.NORTH, firstNameLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lastNameLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, emailLabel, 54, SpringLayout.NORTH, lastNameLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, emailLabel, 10, SpringLayout.WEST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, genderLabel, 54, SpringLayout.NORTH, emailLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, genderLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, phoneNumberLabel, 54, SpringLayout.NORTH, genderLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, phoneNumberLabel, 10, SpringLayout.WEST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, username, 54, SpringLayout.NORTH, phoneNumberLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, username, 10, SpringLayout.WEST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, password, 54, SpringLayout.NORTH, phoneNumberLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, password, 220, SpringLayout.WEST, username);

		// ------------------------------------- PANEL LABEL FONT
		logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

		cFormTitle1.setFont(new Font("Courier New", Font.PLAIN, 24));
		cFormTitle2.setFont(new Font("Courier New", Font.PLAIN, 16));

		firstNameLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		lastNameLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		emailLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		genderLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		phoneNumberLabel.setFont(new Font("Courier New", Font.PLAIN, 12));

		username.setFont(new Font("Courier New", Font.PLAIN, 12));
		password.setFont(new Font("Courier New", Font.PLAIN, 12));
	
		// ---------------------------------------- PANEL INPUT
		try {
			formatted = new MaskFormatter("(###) ###-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		firstNameTextField = new JTextField();
		lastNameTextField = new JTextField();
		emailTextField = new JTextField();
		phoneNumberTextField = new JFormattedTextField(formatted);

		usernameField = new JTextField();
		passwordField = new JPasswordField();

		// ------------------------------------- PANEL BUTTONS
		maleRadioButton = new JRadioButton("Male");
		femaleRadioButton = new JRadioButton("Female");

		nextButton = new JButton("Next");
		backButton = new JButton("Main Menu");
		
		// ---------------------------------------- PANEL INPUT PLACEMENTS
		sl_contentPane.putConstraint(SpringLayout.NORTH, firstNameTextField, 6, SpringLayout.SOUTH, firstNameLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, firstNameTextField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, firstNameTextField, -10, SpringLayout.EAST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, lastNameTextField, 6, SpringLayout.SOUTH, lastNameLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lastNameTextField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lastNameTextField, -10, SpringLayout.EAST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, emailTextField, 6, SpringLayout.SOUTH, emailLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, emailTextField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, emailTextField, -10, SpringLayout.EAST, contentPane);

		maleRadioButton.setBackground(new Color(198,173,255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, maleRadioButton, 6, SpringLayout.SOUTH, genderLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, maleRadioButton, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, maleRadioButton, -250, SpringLayout.EAST, contentPane);
		
		femaleRadioButton.setBackground(new Color(198,173,255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, femaleRadioButton, 6, SpringLayout.SOUTH, genderLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, femaleRadioButton, 250, SpringLayout.WEST, maleRadioButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, femaleRadioButton, -10, SpringLayout.EAST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, phoneNumberTextField, 6, SpringLayout.SOUTH, phoneNumberLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, phoneNumberTextField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, phoneNumberTextField, -10, SpringLayout.EAST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, usernameField, 6, SpringLayout.SOUTH, username);
		sl_contentPane.putConstraint(SpringLayout.WEST, usernameField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, usernameField, -220, SpringLayout.EAST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, username);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 220, SpringLayout.WEST, usernameField);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, -10, SpringLayout.EAST, contentPane);

		backButton.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 54, SpringLayout.SOUTH, usernameField);
		sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -250, SpringLayout.EAST, contentPane);

		nextButton.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, nextButton, 54, SpringLayout.SOUTH, usernameField);
		sl_contentPane.putConstraint(SpringLayout.WEST, nextButton,     250, SpringLayout.WEST, backButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, nextButton, -10, SpringLayout.EAST, contentPane);

		// ---------------------------------------- PANEL INPUT FONTS
		firstNameTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		lastNameTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		emailTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		maleRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		femaleRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		phoneNumberTextField.setFont(new Font("Courier New", Font.PLAIN, 12));

		usernameField.setFont(new Font("Courier New", Font.PLAIN, 12));
		passwordField.setFont(new Font("Courier New", Font.PLAIN, 12));

		nextButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		backButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		
		// ---------------------------------------- ADD PANEL LABELS
		contentPane.add(logoLabel);
		contentPane.add(cFormTitle1);
		contentPane.add(cFormTitle2);

		contentPane.add(firstNameLabel);
		contentPane.add(lastNameLabel);
		contentPane.add(emailLabel);
		contentPane.add(genderLabel);
		contentPane.add(phoneNumberLabel);

		contentPane.add(username);
		contentPane.add(password);
		
		// ---------------------------------------- ADD PANEL INPUTS
		contentPane.add(firstNameTextField);
		contentPane.add(lastNameTextField);
		contentPane.add(emailTextField);
		contentPane.add(maleRadioButton);
		contentPane.add(femaleRadioButton);
			genderGroup = new ButtonGroup();
			genderGroup.add(maleRadioButton);
			genderGroup.add(femaleRadioButton);
		contentPane.add(phoneNumberTextField);

		contentPane.add(usernameField);
		contentPane.add(passwordField);

		contentPane.add(nextButton);
		contentPane.add(backButton);
		
		// ACTION LISTENERS
		// ---------------------------------------- NEXT BUTTON
        nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// RANDOM ID
				int id = generatedID();
				String firstName = firstNameTextField.getText().trim();
				String lastName = lastNameTextField.getText().trim();
				String email = emailTextField.getText().trim();
				String phone = phoneNumberTextField.getText();
				String gender = "";
				if (maleRadioButton.isSelected()) {
					gender = "Male";
				} else if (femaleRadioButton.isSelected()) {
					gender = "Female";
				} else {
					JOptionPane.showMessageDialog(null,"PLEASE SELECT A GENDER.",
													"Error", JOptionPane.ERROR_MESSAGE);
				}
				
				String username = String.valueOf(usernameField.getText());
				String password = String.valueOf(passwordField.getPassword());

				if (firstName.isEmpty() || lastName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "PLEASE FILL OUT NAME FIELDS.");
				} else if (phone.isEmpty() || email.isEmpty()) {
					JOptionPane.showMessageDialog(null, "PLEASE FILL OUT EMAIL AND/OR PHONE.");
				} else if (password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "PLEASE FILL OUT PASSWORD FIELD.");
				} else if (!firstName.matches("^[a-zA-Z]+$") || !lastName.matches("^[a-zA-Z]+$") || !email.contains("@")){
					JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID INFORMATION.");
				} else {
					Customer customer = new Customer(id, firstName, lastName, gender, email, phone, username, password);
					CustomerClient client = new CustomerClient();
					
					client.sendAction("Sign Up Customer");
					client.sendCustomer(customer);
					try {
						client.receiveResponse();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					// IF CUSTOMER IS FOUND, OPEN CUSTOMER MENU
					if (client.getActionResult() == true) {
						new CustomerMainMenu().setVisible(true);
						dispose();
					} // END OF IF STATEMENT
				} // END OF ELSE IF STATEMENT
			}
		}); // END OF ACT. LIS.
		
		// ---------------------------------------- BACK BUTTON
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GrizzMainMenu().setVisible(true);
				dispose();
			}
		}); // END OF ACT.LIS.

		// SETS SELECTED VALUE OF COMPONENTS
		formatted.setPlaceholderCharacter('_');
		formatted.setAllowsInvalid(false);
		phoneNumberTextField.setColumns(10);
	} // END OF DEFAULT CONSTRUCTOR
	
	// RANDOMLY GENERATED ID NUMBER
	public static int generatedID() {
        Random random = new Random();
        int id = 9999;

        for (int i = 1000; i < id; i++) {
            id = random.nextInt(9999);
        }
        return id;
    }
} // END OF CUSTOMERSIGNFORM CLASS