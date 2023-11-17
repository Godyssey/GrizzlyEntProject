// Programmer Name : Britney Vassell
// Student ID # : 2105012
// Date : Nov 2, 2023
package view.customer;

// IMPORT JAVAX SWING COMPONENTS
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

// IMPORT ACTION LISTENERS
import java.awt.event.*;

// IMPORT CUSTOMIZATION
import java.awt.*;

// IMPORT SQL COMPONENTS
import java.sql.*;

// IMPORT
import java.text.ParseException;

//import com.controller.DBConnection;
// IMPORT PROJECT CLASSES
import view.equipment.EquipmentRequestForm;
import view.customer.CustomerMainMenu;

public class RentalRequestForm extends JFrame {

	// CREATE FRAME FOR APPLICATION
	private JFrame frame;
	private JPanel contentPane;
	private SpringLayout sl_contentPane;

	// CREATES LABELS FOR PANEL DATA
	private JLabel logoLabel;
	private JLabel uFormTitle1; 
	private JLabel firstNameLabel; 
	private JLabel lastNameLabel; 
	private JLabel emailLabel; 
	private JLabel genderLabel; 
	private JLabel phoneNumberLabel; 

	// CREATES INPUT TYPES FOR PANEL DATA
	// ---------------------------------------- TEXT FIELD
	private MaskFormatter formatted;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JFormattedTextField phoneNumberTextField;

	// ---------------------------------------- BUTTON
	private JRadioButton maleRadioButton; 
	private JRadioButton femaleRadioButton; 
	private ButtonGroup genderGroup;	   
	
	private JButton nextButton;
	private JButton backButton;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentalRequestForm frame = new RentalRequestForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	// DEFAULT CONSTRUCTOR
	public RentalRequestForm() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\britn\\OneDrive - The University of Technology,Jamaica\\Documents\\Britney Documents\\UTECH\\Classes\\YR3 SEM1\\Advanced Programming\\project icons\\9605277.png"));
		
		// FRAME CUSTOMIZATION
		setTitle("Grizzly's Entertainment & Equipment Rental | Rental Request Form");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198,173,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		// ---------------------------------------- PANEL LABELS AND HEADER
		logoLabel = new JLabel("G");
		
		uFormTitle1 = new JLabel("SIGN UP TO REQUEST EQUIPMENT");
		
		firstNameLabel = new JLabel("First Name: ");
		lastNameLabel = new JLabel("Last Name: ");
		emailLabel = new JLabel("Email Address: ");
		genderLabel = new JLabel("Gender: ");
		phoneNumberLabel = new JLabel("Phone Number: ");
		
		// ---------------------------------------- PANEL LABEL PLACEMENTS
		sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 185, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, uFormTitle1, 6, SpringLayout.SOUTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, uFormTitle1, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, firstNameLabel, 34, SpringLayout.NORTH, uFormTitle1);
		sl_contentPane.putConstraint(SpringLayout.WEST, firstNameLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, lastNameLabel, 54, SpringLayout.NORTH, firstNameLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lastNameLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, emailLabel, 54, SpringLayout.NORTH, lastNameLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, emailLabel, 10, SpringLayout.WEST, contentPane);

		sl_contentPane.putConstraint(SpringLayout.NORTH, genderLabel, 54, SpringLayout.NORTH, emailLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, genderLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, phoneNumberLabel, 54, SpringLayout.NORTH, genderLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, phoneNumberLabel, 10, SpringLayout.WEST, contentPane);

		// ------------------------------------- PANEL LABEL FONT
		logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

		uFormTitle1.setFont(new Font("Courier New", Font.PLAIN, 24));

		firstNameLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		lastNameLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		emailLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		genderLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		phoneNumberLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
	
		// ---------------------------------------- PANEL INPUT
		firstNameTextField = new JTextField();
		lastNameTextField = new JTextField();
		emailTextField = new JTextField();
		try {
			formatted = new MaskFormatter("(###) ###-####");
			phoneNumberTextField = new JFormattedTextField(formatted);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// ------------------------------------- PANEL BUTTONS
		maleRadioButton = new JRadioButton("Male");
		femaleRadioButton = new JRadioButton("Female");

		nextButton = new JButton("Next");
		backButton = new JButton("Back");
		
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

		backButton.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 54, SpringLayout.SOUTH, phoneNumberTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -250, SpringLayout.EAST, contentPane);

		nextButton.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, nextButton, 54, SpringLayout.SOUTH, phoneNumberTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, nextButton,     250, SpringLayout.WEST, backButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, nextButton, -10, SpringLayout.EAST, contentPane);

		// ------------------------------------- PANEL INPUT FONTS
		firstNameTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		lastNameTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		emailTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
		maleRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		femaleRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		phoneNumberTextField.setFont(new Font("Courier New", Font.PLAIN, 12));

		nextButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		backButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		
		// ---------------------------------------- ADD PANEL LABELS
		contentPane.add(logoLabel);
		contentPane.add(uFormTitle1);

		contentPane.add(firstNameLabel);
		contentPane.add(lastNameLabel);
		contentPane.add(emailLabel);
		contentPane.add(genderLabel);
		contentPane.add(phoneNumberLabel);
		
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

		contentPane.add(nextButton);
		contentPane.add(backButton);
		
		// ACTION LISTENERS
		// ---------------------------------------- NEXT BUTTON
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	try {
					// CONNECTION TO DATABASE
					Connection myConn = DBConnection.getDatabaseConnection();

					// CREATE A STATEMENT
					String firstName = firstNameTextField.getText().trim();
					String lastName = lastNameTextField.getText().trim();
					String email = emailTextField.getText().trim();
					String phone = phoneNumberTextField.getText();
					String gender = "";
					if (maleRadioButton.isSelected()) {
						gender = "Male";
					} else if (femaleRadioButton.isSelected()) {
						gender = "Female";
					}

					// ---------------------------------------- DATA VALIDATION
					if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty() || !maleRadioButton.isSelected() && !femaleRadioButton.isSelected()) {
						JOptionPane.showMessageDialog(frame, "Please Enter All Required Information", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						// BRINGS UP EQUIPMENT FORM
						EquipmentForm eForm = new EquipmentForm();
						eForm.setVisible(true);
						setVisible(false);

						// CREATES INSTANCE OF USER & OPENS USER FRAME
						//User user = new User();

						// QUERY FOR DATABASE TO BE EXECUTED
						String query = "INSERT INTO rentalrequest (firstName, lastName, gender, email, phone) VALUES ('" + firstName
						+ "', '" + lastName + "', " + gender + ", '" + email + "," + phone + "','" + /*id + "')";*/

				/*		Statement statement = myConn.createStatement();
						int x = statement.executeUpdate(query);

						if (x == 0) {
							JOptionPane.showMessageDialog(nextButton, "It never work.");
						}
						else {
							JOptionPane.showMessageDialog(frame, "It worked.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} 
				} catch (SQLException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}*/
			} 
		}); // END OF ACT. LIS. 
		
		// ---------------------------------------- BACK BUTTON
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CustomerMainMenu().setVisible(true);
				dispose();
			}
		}); // END OF ACT.LIS.

		// SETS SELECTED VALUE OF COMPONENTS
		formatted.setPlaceholderCharacter('_');
		formatted.setAllowsInvalid(false);
		phoneNumberTextField.setColumns(10);
	}
}
