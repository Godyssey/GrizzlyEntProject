// Programmer Name : Nathalea Evans
// Student ID # : 2101707
// Date : Nov 5, 2023

package view.employee;

// IMPORT JAVAX SWING COMPONENTS
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// IMPORT ACTION LISTENER COMPONENTS
import java.awt.event.*;
import java.io.IOException;
// IMPORT CUSTOMIZATION
import java.awt.*;

import controller.EmployeeClient;
import model.Employee;
import view.employee.EmployeeMainMenu;
import view.customer.GrizzMainMenu;

public class EmployeeLogIn extends JFrame {

    // CREATE FRAME FOR APPLICATION
    private JPanel contentPane;
    private SpringLayout sl_contentPane;

    // CREATES LABELS FOR PANEL DATA
    private JLabel eFormTitleLabel;
    private JLabel logoLabel;
    private JLabel ID;
    private JLabel password;

    // CREATES INPUT TYPES FOR PANEL DATA
    // ---------------------------------------- TEXT FIELD
    private JTextField IDField;
    private JPasswordField passwordField;

    // ---------------------------------------- BUTTON
    private JButton backButton;
    private JButton loginButton;

    /*
     * public static void main(String[] args) {
     * EventQueue.invokeLater(new Runnable() {
     * public void run() {
     * try {
     * EmployeeForm frame = new EmployeeForm();
     * frame.setVisible(true);
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * });
     * }
     */

    // DEFAULT CONSTRUCTOR
    public EmployeeLogIn() {

        // FRAME CUSTOMIZATION
        setTitle("Grizzly's Entertainment & Equipment Rental | Employee Form");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(177, 218, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);

        // ---------------------------------------- PANEL LABELS AND HEADER
        logoLabel = new JLabel("G");

        eFormTitleLabel = new JLabel("EMPLOYEE LOGIN");

        ID = new JLabel("ID: ");
        password = new JLabel("Password: ");

        // ---------------------------------------- PANEL LABEL PLACEMENTS
        sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 230, SpringLayout.WEST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, eFormTitleLabel, 6, SpringLayout.SOUTH, logoLabel);
        sl_contentPane.putConstraint(SpringLayout.WEST, eFormTitleLabel, 130, SpringLayout.WEST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, ID, 54, SpringLayout.NORTH, eFormTitleLabel);
        sl_contentPane.putConstraint(SpringLayout.WEST, ID, 10, SpringLayout.WEST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, password, 54, SpringLayout.NORTH, ID);
        sl_contentPane.putConstraint(SpringLayout.WEST, password, 10, SpringLayout.WEST, contentPane);

        // ------------------------------------- PANEL LABEL FONT
        logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

        eFormTitleLabel.setFont(new Font("Courier New", Font.PLAIN, 24));

        ID.setFont(new Font("Courier New", Font.PLAIN, 12));
        password.setFont(new Font("Courier New", Font.PLAIN, 12));

        // ---------------------------------------- PANEL INPUT
        IDField = new JTextField();
        passwordField = new JPasswordField();

        // ------------------------------------- PANEL BUTTONS
        loginButton = new JButton("Log In");
        backButton = new JButton("Main Menu");

        // ---------------------------------------- PANEL INPUT PLACEMENTS
        sl_contentPane.putConstraint(SpringLayout.NORTH, IDField, 6, SpringLayout.SOUTH, ID);
        sl_contentPane.putConstraint(SpringLayout.WEST, IDField, 10, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, IDField, -10, SpringLayout.EAST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, password);
        sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 10, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, -10, SpringLayout.EAST, contentPane);

        backButton.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 54, SpringLayout.SOUTH, passwordField);
        sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -350, SpringLayout.EAST, contentPane);

        loginButton.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, loginButton, 54, SpringLayout.SOUTH, passwordField);
        sl_contentPane.putConstraint(SpringLayout.WEST, loginButton, 350, SpringLayout.WEST, backButton);
        sl_contentPane.putConstraint(SpringLayout.EAST, loginButton, -10, SpringLayout.EAST, contentPane);

        // ------------------------------------- PANEL INPUT FONTS
        IDField.setFont(new Font("Courier New", Font.PLAIN, 12));
        passwordField.setFont(new Font("Courier New", Font.PLAIN, 12));

        loginButton.setFont(new Font("Courier New", Font.PLAIN, 12));
        backButton.setFont(new Font("Courier New", Font.PLAIN, 12));

        // ---------------------------------------- ADD PANEL LABELS
        contentPane.add(logoLabel);

        contentPane.add(eFormTitleLabel);

        contentPane.add(ID);
        contentPane.add(password);

        // ---------------------------------------- ADD PANEL INPUTS
        contentPane.add(IDField);
        contentPane.add(passwordField);

        contentPane.add(backButton);
        contentPane.add(loginButton);

        // ACTION LISTENERS
        // ---------------------------------------- LOGIN BUTTON
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ID = Integer.parseInt(IDField.getText());
                String password = String.valueOf(passwordField.getPassword());

                // SENDS ID & PASSWORD TO CLIENT FOR VERIFICATION
                Employee employee = new Employee(ID, password);
                EmployeeClient client;
				try {
					client = new EmployeeClient();	
					client.sendEmployee(employee);
	                client.sendAction("Login Employee");
	                client.receiveResponse();

	                // IF EMPLOYEE IS FOUND, OPEN EMPLOYEE MENU
	                if (client.getActionResult() == true) {
	                    new EmployeeMainMenu().setVisible(true);
	                    dispose();
	                } // END OF IF STATEMENT
	                
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        }); // END OF ACT. LIS.

        // --------------------------------------- BACK BUTTON
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GrizzMainMenu().setVisible(true); // Open Main Menu
                dispose(); // Close Current Window
            }
        }); // END OF ACT. LIS.
    } // END OF DEFAULT CONSTRUCTOR
} // END OF EMPLOYEEFORM CLASS