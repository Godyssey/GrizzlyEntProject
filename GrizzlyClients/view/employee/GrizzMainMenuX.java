// // Programmer Name : Britney Vassell
// // Student ID # : 2105012
// // Date : Nov 2, 2023
// package view.employee;

// // IMPORT JAVAX SWING COMPONENTS
// import javax.swing.*;

// import javax.swing.border.EmptyBorder;

// // IMPORT ACTION LISTENER COMPONENTS
// import java.awt.event.*;

// // IMPORT CUSTOMIZATION
// import java.awt.*;

// // IMPORT PROJECT CLASSES
// import view.customer.CustomerLogIn;
// import view.customer.CustomerSignUpForm;
// import view.employee.EmployeeForm;

// public class GrizzMainMenu extends JFrame {

// 	// CREATE FRAME FOR APPLICATION
// 	private JPanel contentPane;
// 	private SpringLayout sl_contentPane;

// 	// CREATES LABELS FOR PANEL DATA
// 	private JLabel logoLabel;
// 	private JLabel mMenuTitle;
// 	private JLabel roleTypeLabel1;
// 	private JLabel roleTypeLabel2;

// 	// CREATES INPUT TYPES FOR PANEL DATA
// 	// ---------------------------------------- COMBO BOX
// 	String roleType[] = {"Customer", "Employee"};
// 	JComboBox<String> roleTypeComboBox = new JComboBox<>(roleType);

// 	// ---------------------------------------- BUTTON
//  	private JRadioButton newRadioButton;
// 	private JRadioButton existingRadioButton;
// 	private ButtonGroup customerGroup;

// 	private JButton continueButton;

// 	public static void main(String[] args) {
// 		EventQueue.invokeLater(new Runnable() {
// 			public void run() {
// 				try {
// 					GrizzMainMenu frame = new GrizzMainMenu();
// 					frame.setVisible(true);
// 				} catch (Exception e) {
// 					e.printStackTrace();
// 				}
// 			}
// 		});
// 	}

// 	// DEFAULT CONSTRUCTOR
// 	public GrizzMainMenu() {
// 		//setIconImage(Toolkit.getDefaultToolkit().getImage(
// 		//		"C:\\Users\\britn\\OneDrive - The University of Technology,Jamaica\\Documents\\Britney Documents\\UTECH\\Classes\\YR3 SEM1\\Advanced Programming\\project icons\\9605277.png"));
// 		setTitle("Grizzly's Entertainment & Equipment Rentals | Main Menu");
		
// 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		setBounds(150, 150, 550, 350);
//         setLocationRelativeTo(null);
// 		contentPane = new JPanel();
// 		contentPane.setBackground(new Color(255,183,126));
// 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

// 		setContentPane(contentPane);
// 		sl_contentPane = new SpringLayout();
// 		contentPane.setLayout(sl_contentPane);

// 		// ---------------------------------------- PANEL LABELS AND HEADER
//         logoLabel = new JLabel("G");

//         mMenuTitle = new JLabel("MAIN MENU");

// 		roleTypeLabel1 = new JLabel("SELECT YOUR ROLE");

// 		roleTypeLabel2 = new JLabel("SELECT YOUR STATUS");

// 		// ---------------------------------------- PANEL LABEL PLACEMENTS
// 		sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
// 		sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 245, SpringLayout.WEST, contentPane);
		
// 		sl_contentPane.putConstraint(SpringLayout.NORTH, mMenuTitle, 6, SpringLayout.SOUTH, logoLabel);
// 		sl_contentPane.putConstraint(SpringLayout.WEST, mMenuTitle, 190, SpringLayout.WEST, contentPane);

// 		sl_contentPane.putConstraint(SpringLayout.NORTH, roleTypeLabel1, 34, SpringLayout.SOUTH, mMenuTitle);
// 		sl_contentPane.putConstraint(SpringLayout.WEST, roleTypeLabel1, 185, SpringLayout.WEST, contentPane);

// 		sl_contentPane.putConstraint(SpringLayout.NORTH, roleTypeLabel2, 84, SpringLayout.SOUTH, roleTypeLabel1);
// 		sl_contentPane.putConstraint(SpringLayout.WEST, roleTypeLabel2, 175, SpringLayout.WEST, contentPane);

// 		// ---------------------------------------- PANEL LABEL FONT
// 		logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

// 		mMenuTitle.setFont(new Font("Courier New", Font.PLAIN, 24));

// 		roleTypeLabel1.setFont(new Font("Courier New", Font.PLAIN, 16));

// 		roleTypeLabel2.setFont(new Font("Courier New", Font.PLAIN, 16));

// 		// ---------------------------------------- PANEL BUTTONS
// 		continueButton = new JButton("Continue");

//  		newRadioButton = new JRadioButton("New Customer");
// 		existingRadioButton = new JRadioButton("Existing Customer");

// 		// ---------------------------------------- PANEL INPUT PLACEMENTS
// 		roleTypeComboBox.setBackground(new Color(255,255,255));
// 		sl_contentPane.putConstraint(SpringLayout.NORTH, roleTypeComboBox, 6, SpringLayout.SOUTH, roleTypeLabel1);
// 		sl_contentPane.putConstraint(SpringLayout.WEST, roleTypeComboBox, 175, SpringLayout.WEST, contentPane);
// 		sl_contentPane.putConstraint(SpringLayout.EAST, roleTypeComboBox, -175, SpringLayout.EAST, contentPane);

// 		continueButton.setBackground(new Color(255,255,255));
// 		sl_contentPane.putConstraint(SpringLayout.NORTH, continueButton, 34, SpringLayout.SOUTH, roleTypeComboBox);
// 		sl_contentPane.putConstraint(SpringLayout.WEST, continueButton, 175, SpringLayout.WEST, contentPane);
// 		sl_contentPane.putConstraint(SpringLayout.EAST, continueButton, -175, SpringLayout.EAST, contentPane);

//  		newRadioButton.setBackground(new Color(255,183,126));
// 		sl_contentPane.putConstraint(SpringLayout.NORTH, newRadioButton, 6, SpringLayout.SOUTH, roleTypeLabel2);
// 		sl_contentPane.putConstraint(SpringLayout.WEST, newRadioButton, 50, SpringLayout.WEST, contentPane);
// 		sl_contentPane.putConstraint(SpringLayout.EAST, newRadioButton, -250, SpringLayout.EAST, contentPane);

// 		existingRadioButton.setBackground(new Color(255,183,126));
// 		sl_contentPane.putConstraint(SpringLayout.NORTH, existingRadioButton, 6, SpringLayout.SOUTH, roleTypeLabel2);
// 		sl_contentPane.putConstraint(SpringLayout.WEST, existingRadioButton, 250, SpringLayout.WEST, newRadioButton);
// 		sl_contentPane.putConstraint(SpringLayout.EAST, existingRadioButton, -10, SpringLayout.EAST, contentPane);

// 		// ------------------------------------- PANEL INPUT FONTS
//         roleTypeComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));

// 		continueButton.setFont(new Font("Courier New", Font.PLAIN, 12));

//   		newRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
// 		existingRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));

// 		// ------------------------------------- ADDS PANEL LABELS
// 		contentPane.add(logoLabel);

// 		contentPane.add(mMenuTitle);
// 		contentPane.add(roleTypeLabel1);

// 		contentPane.add(roleTypeLabel2);

// 		// ---------------------------------------- ADD PANEL INPUTS
// 		contentPane.add(roleTypeComboBox);

//   		contentPane.add(newRadioButton);
// 		contentPane.add(existingRadioButton);
// 			customerGroup = new ButtonGroup();
// 			customerGroup.add(newRadioButton);
// 			customerGroup.add(existingRadioButton);

// 		contentPane.add(continueButton);

// 		// VISIBILITY
//         // ------------------------------------- UNTIL CONTINUE BUTTON CLICKED
//   		roleTypeLabel2.setVisible(false);
// 		newRadioButton.setVisible(false);
// 		existingRadioButton.setVisible(false);

// 		// ACTION LISTENER
// 		// ------------------------------------- CONTINUE BUTTON
// 		continueButton.addActionListener(new ActionListener() {
// 			@Override
// 			public void actionPerformed(ActionEvent e) {

// 				// GETS THE SELECTED OPTION FROM THE COMBO BOX AND CHANGES IT TO A STRING
// 				String selectedOption = (String) roleTypeComboBox.getSelectedItem();
				
// 				setLocationRelativeTo(null);

// 				if (selectedOption.equals("Customer")) {
// 					roleTypeLabel2.setVisible(true);
//  					newRadioButton.setVisible(true);
// 					existingRadioButton.setVisible(true);

// 					continueButton.setVisible(false);

// 				} else if (selectedOption.equals("Employee")) {
// 					// OPENS EMPLOYEE FORM
// 					new EmployeeForm().setVisible(true);
// 					setVisible(false);
// 				}
// 			}
// 		}); // END OF ACT. LIS.
		
// 		// -------------------------------------- NEW CUSTOMER
// 		newRadioButton.addActionListener(new ActionListener(){
// 			@Override
// 			public void actionPerformed(ActionEvent e) {

// 				if (newRadioButton.isSelected()) {
// 					new CustomerSignUpForm().setVisible(true);
// 					setVisible(false);
// 				} // ENDS IF STATEMENT
// 			}
// 		}); // END OF ACT. LIS.

// 		// ------------------------------------- EXISTING CUSTOMER
// 		existingRadioButton.addActionListener(new ActionListener(){
// 			@Override
// 			public void actionPerformed(ActionEvent e) {

// 				if (existingRadioButton.isSelected()) {
// 					new CustomerLogIn().setVisible(true);
// 					setVisible(false);
// 				} // ENDS IF STATEMENT
// 			}
// 		}); // END OF ACT. LIS.
// 	} // END OF DEFAULT CONSTRUCTOR
// } // END OF CUSTOMERSIGNFORM CLASS

