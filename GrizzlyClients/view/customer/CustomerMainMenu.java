// Programmer Name : Britney Vassell
// Student ID # : 2105012
// Date : Nov 2, 2023
package view.customer;

// IMPORT JAVAX SWING COMPONENTS
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// IMPORT ACTION LISTENER
import java.awt.event.*;

// IMPORT CUSTOMIZATION
import java.awt.*;

// IMPORT PROJECT CLASSES
import view.equipment.EquipmentRequestForm;
import view.customer.CustomerRetrievalForm;

public class CustomerMainMenu extends JFrame {

	// CREATE FRAME FOR APPLICATION
	private JPanel contentPane;
	private SpringLayout sl_contentPane;

	// CREATES LABEL FOR PANEL DATA
    private JLabel logoLabel;
    private JLabel cMenuTitle;

	// CREATES INPUT TYPES FOR PANEL DATA
    // ---------------------------------------- BUTTON
    private JButton requestRental;
	private JButton followUp;
	private JButton customerService;
	private JButton backButton;

	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenu frame = new CustomerMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	// DEFAULT CONSTRUCTOR
	public CustomerMainMenu() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(
		//		"C:\\Users\\britn\\OneDrive - The University of Technology,Jamaica\\Documents\\Britney Documents\\UTECH\\Classes\\YR3 SEM1\\Advanced Programming\\project icons\\9605277.png"));
		setTitle("Grizzly's Entertainment & Equipment Rental | Customer Menu");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 550, 400);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198,173,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		// ---------------------------------------- PANEL LABELS AND HEADER
        logoLabel = new JLabel("G");

        cMenuTitle = new JLabel("CUSTOMER MENU");

        // ---------------------------------------- PANEL LABEL PLACEMENTS
		sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 245, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, cMenuTitle, 6, SpringLayout.SOUTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, cMenuTitle, 165, SpringLayout.WEST, contentPane);

		// ---------------------------------------- PANEL LABEL FONT
        logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

        cMenuTitle.setFont(new Font("Courier New", Font.PLAIN, 24));

        // ---------------------------------------- PANEL BUTTONS
		requestRental = new JButton("Request Rental");
		followUp = new JButton("Follow Up on Rental");
		customerService = new JButton("Customer Service");
		backButton = new JButton("Main Menu");

        // ---------------------------------------- PANEL INPUT PLACEMENTS
        requestRental.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, requestRental, 34, SpringLayout.SOUTH, cMenuTitle);
		sl_contentPane.putConstraint(SpringLayout.WEST, requestRental, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, requestRental, -150, SpringLayout.EAST, contentPane);

        followUp.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, followUp, 34, SpringLayout.SOUTH, requestRental);
		sl_contentPane.putConstraint(SpringLayout.WEST, followUp, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, followUp, -150, SpringLayout.EAST, contentPane);
		
		customerService.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, customerService, 34, SpringLayout.SOUTH, followUp);
		sl_contentPane.putConstraint(SpringLayout.WEST, customerService, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, customerService, -150, SpringLayout.EAST, contentPane);

		backButton.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 34, SpringLayout.SOUTH, customerService);
		sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -150, SpringLayout.EAST, contentPane);

		// ------------------------------------- PANEL INPUT FONTS
        requestRental.setFont(new Font("Courier New", Font.PLAIN, 12));
		followUp.setFont(new Font("Courier New", Font.PLAIN, 12));
		customerService.setFont(new Font("Courier New", Font.PLAIN, 12));

		backButton.setFont(new Font("Courier New", Font.PLAIN, 12));

		// ---------------------------------------- ADD PANEL LABELS
        contentPane.add(logoLabel);
        contentPane.add(cMenuTitle);

		// ---------------------------------------- ADD PANEL INPUTS
		contentPane.add(requestRental);
		contentPane.add(followUp);
		contentPane.add(customerService);

		contentPane.add(backButton);

		// ACTION LISTENERS
		// ---------------------------------------- REQUEST RENTAL
		requestRental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EquipmentRequestForm().setVisible(true);
				dispose();
			}
		}); // END OF ACT. LIS.

		// ---------------------------------------- FOLLOW UP ON RENTAL
		followUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerRetrievalForm().setVisible(true);
				dispose();
			}
		}); // END OF ACT. LIS.

		// ---------------------------------------- CUSTOMER SERVICE
		customerService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Add Customer Service Button Functionality
			}
		}); // END OF ACT. LIS.

		// ---------------------------------------- BACK BUTTON
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GrizzMainMenu().setVisible(true);
				dispose();
			}
		}); // END OF ACT. LIS.
	} // END OF DEFAULT CONSTRUCTOR
} // END OF CUSTOMERMENU CLASS
