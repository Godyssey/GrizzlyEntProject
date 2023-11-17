// Programmer Name : Britney Vassell
// Student ID # : 2105012
// Date : Nov 2, 2023
package view.equipment;

// IMPORT JAVA SWING COMPONENTS
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

// IMPORT ACTION LISTENER COMPONENTS
import java.awt.event.*;
import java.io.IOException;
// IMPORT CUSTOMIZATION
import java.awt.*;

// IMPORTS
import java.text.ParseException;

// IMPORT DATE COMPONENTS
import java.util.Date;
import java.util.Random;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;
import controller.CustomerClient;
import model.Customer;
import model.Equipment;
import view.customer.CustomerMainMenu;
import view.customer.GrizzMainMenu;

public class EquipmentRequestForm extends JFrame{

    // CREATE FRAME FOR APPLICATION
    private JFrame frame;
    private JPanel contentPane;
    private SpringLayout sl_contentPane;
    
    // CREATE LABELS FOR PANEL DATA
    private JLabel logoLabel;
    private JLabel formTitle1;
    private JLabel formTitle2;
    private JLabel formTitle3;
    private JLabel eNameLabel;
    private JLabel eTypeLabel;
    private JLabel eQuantityLabel;
    private JLabel rentalDateLabel;
    private JLabel rentalTimeLabel;
    private JLabel amountDueLabel;
    private JLabel paymentMethodLabel;
    private JLabel cardNumberLabel;

    // CREATE INPUT TYPES FOR PANEL DATA
    // ---------------------------------------- TEXT FIELD
    private MaskFormatter formatted;
    private JFormattedTextField rentalTimeField;
    private JTextField amountDueTextField;
    private JFormattedTextField cardNumberTextField;

    // ---------------------------------------- COMBO BOX
    String equipmentType[] = {"Staging","Lighting","Power","Sound"};
    JComboBox<String> eTypeComboBox = new JComboBox<>(equipmentType);

    String equipmentName[] = {"Wall Components", "Decks", "Handrails", 
                                "LED Lights", "Disco Lights", "Dimmers",
                                "Cables", "Light Switches",
                                "Microphone", "Speakers", "Amplifier"};
    JComboBox<String> eNameComboBox = new JComboBox<>(equipmentName);
    
    String quantity[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    JComboBox<String> eQuantityComboBox = new JComboBox<>(quantity);
    
    // ---------------------------------------- BUTTON
    private JRadioButton cashRadioButton;
    private JRadioButton cardRadioButton;
    private ButtonGroup payMethodGroup;
    
    private JButton nextButton;
    private JButton backButton;
    private JButton submitButton;

    // ---------------------------------------- DATE PICKER
    private JDateChooser rentalDateChooser;

    // VARIABLE FOR TOTAL COST
    private String amountDue;

    // DEFAULT CONSTRUCTOR
    public EquipmentRequestForm() {

        // FRAME CUSTOMIZATION
        setTitle("Grizzly's Entertainment & Equipment Rental | Equipment Form");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(206,255,171));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

        // ------------------------------------- PANEL LABELS
		logoLabel = new JLabel("G");
        
        formTitle1 = new JLabel("NEW RENTAL");

        formTitle2 = new JLabel("SELECT EQUIPMENT TO RENT");
        
        eTypeLabel = new JLabel("Equipment Type: ");
        eNameLabel = new JLabel("Equipment Name: ");
        eQuantityLabel = new JLabel("Quantity: ");
        rentalTimeLabel = new JLabel("Rental Time (24h): ");
        rentalDateLabel = new JLabel("Rental Date: ");
        amountDueLabel = new JLabel("Total Cost: $");

        formTitle3 = new JLabel("PAYMENT INFORMATION");

        paymentMethodLabel = new JLabel("Payment Method: ");
        cardNumberLabel = new JLabel("Card Number: ");

        // ------------------------------------- PANEL LABEL PLACEMENTS
        sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 185, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, formTitle1, 6, SpringLayout.SOUTH, logoLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, formTitle1, 130, SpringLayout.WEST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, formTitle2, 16, SpringLayout.SOUTH, formTitle1);
        sl_contentPane.putConstraint(SpringLayout.WEST, formTitle2, 90, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, eTypeLabel, 34, SpringLayout.NORTH, formTitle2);
		sl_contentPane.putConstraint(SpringLayout.WEST, eTypeLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, eNameLabel, 54, SpringLayout.NORTH, eTypeLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, eNameLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, eQuantityLabel, 54, SpringLayout.NORTH, eNameLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, eQuantityLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, rentalTimeLabel, 54, SpringLayout.NORTH, eQuantityLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, rentalTimeLabel, 10, SpringLayout.WEST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, rentalDateLabel, 54, SpringLayout.NORTH, eQuantityLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, rentalDateLabel, 70, SpringLayout.EAST, rentalTimeLabel);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, amountDueLabel, 64, SpringLayout.NORTH, rentalTimeLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, amountDueLabel, 10, SpringLayout.WEST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, formTitle3, 64, SpringLayout.NORTH, amountDueLabel);
        sl_contentPane.putConstraint(SpringLayout.WEST, formTitle3, 130, SpringLayout.WEST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, paymentMethodLabel, 34, SpringLayout.NORTH, formTitle3);
        sl_contentPane.putConstraint(SpringLayout.WEST, paymentMethodLabel, 10, SpringLayout.WEST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, cardNumberLabel, 54, SpringLayout.NORTH, paymentMethodLabel);
        sl_contentPane.putConstraint(SpringLayout.WEST, cardNumberLabel, 10, SpringLayout.WEST, contentPane);

        // ------------------------------------- PANEL LABEL FONT
		logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

        formTitle1.setFont(new Font("Courier New", Font.PLAIN, 24));
        formTitle2.setFont(new Font("Courier New", Font.PLAIN, 16));

        eTypeLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
        eNameLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
        eQuantityLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
        rentalTimeLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
        rentalDateLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
        amountDueLabel.setFont(new Font("Courier New", Font.PLAIN, 12));

        formTitle3.setFont(new Font("Courier New", Font.PLAIN, 15));
        paymentMethodLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
        cardNumberLabel.setFont(new Font("Courier New", Font.PLAIN, 12));

        // ------------------------------------- PANEL INPUTS
        try {
			formatted = new MaskFormatter("##:##");
            rentalTimeField = new JFormattedTextField(formatted);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        rentalDateChooser = new JDateChooser();
        try {
            formatted = new MaskFormatter("#### #### #### ####");
            cardNumberTextField = new JFormattedTextField(formatted);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        amountDueTextField = new JTextField();

        // ------------------------------------- PANEL BUTTONS
        cashRadioButton = new JRadioButton("Cash");
        cardRadioButton = new JRadioButton("Card");

        nextButton = new JButton("Next");
        backButton = new JButton("Main Menu");
        submitButton = new JButton("Submit");

        // ------------------------------------- PANEL INPUT PLACEMENTS
        eTypeComboBox.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, eTypeComboBox, 6, SpringLayout.SOUTH, eTypeLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, eTypeComboBox, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, eTypeComboBox, -10, SpringLayout.EAST, contentPane);
		
		eNameComboBox.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, eNameComboBox, 6, SpringLayout.SOUTH, eNameLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, eNameComboBox, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, eNameComboBox, -10, SpringLayout.EAST, contentPane);
		
		eQuantityComboBox.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, eQuantityComboBox, 6, SpringLayout.SOUTH, eQuantityLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, eQuantityComboBox, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, eQuantityComboBox, -10, SpringLayout.EAST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, rentalTimeField, 6, SpringLayout.SOUTH, rentalTimeLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, rentalTimeField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, rentalTimeField, -220, SpringLayout.EAST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, rentalDateChooser, 6, SpringLayout.SOUTH, rentalDateLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, rentalDateChooser, 220, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, rentalDateChooser, -10, SpringLayout.EAST, contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, amountDueTextField, 46, SpringLayout.SOUTH, rentalTimeField);
		sl_contentPane.putConstraint(SpringLayout.WEST, amountDueTextField, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, amountDueTextField, -10, SpringLayout.EAST, contentPane);

        cashRadioButton.setBackground(new Color(206,255,171));
        sl_contentPane.putConstraint(SpringLayout.NORTH, cashRadioButton, 6, SpringLayout.SOUTH, paymentMethodLabel);
        sl_contentPane.putConstraint(SpringLayout.WEST, cashRadioButton, 10, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, cashRadioButton, -250, SpringLayout.EAST, contentPane);

        cardRadioButton.setBackground(new Color(206,255,171));
        sl_contentPane.putConstraint(SpringLayout.NORTH, cardRadioButton, 6, SpringLayout.SOUTH, paymentMethodLabel);
        sl_contentPane.putConstraint(SpringLayout.WEST, cardRadioButton, 250, SpringLayout.WEST, cashRadioButton);
        sl_contentPane.putConstraint(SpringLayout.EAST, cardRadioButton, -10, SpringLayout.EAST, contentPane);
		
        sl_contentPane.putConstraint(SpringLayout.NORTH, cardNumberTextField, 6, SpringLayout.SOUTH, cardNumberLabel);
        sl_contentPane.putConstraint(SpringLayout.WEST, cardNumberTextField, 10, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, cardNumberTextField, -10, SpringLayout.EAST, contentPane);

		backButton.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 54, SpringLayout.SOUTH, amountDueTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -250, SpringLayout.EAST, contentPane);

        nextButton.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, nextButton, 54, SpringLayout.SOUTH, amountDueTextField);
        sl_contentPane.putConstraint(SpringLayout.WEST, nextButton,     250, SpringLayout.WEST, backButton);
        sl_contentPane.putConstraint(SpringLayout.EAST, nextButton, -10, SpringLayout.EAST, contentPane);
                
        submitButton.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, submitButton, 24, SpringLayout.SOUTH, cashRadioButton);
        sl_contentPane.putConstraint(SpringLayout.WEST, submitButton, 250, SpringLayout.WEST, backButton);
        sl_contentPane.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, contentPane);
        
        // ------------------------------------- PANEL INPUT FONTS
        eTypeComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		eNameComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		eQuantityComboBox.setFont(new Font("Courier New", Font.PLAIN, 12));
		rentalTimeField.setFont(new Font("Courier New", Font.PLAIN, 12));
		rentalDateChooser.setFont(new Font("Courier New", Font.PLAIN, 12));
		amountDueTextField.setFont(new Font("Courier New", Font.PLAIN, 12));

        cashRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
        cardRadioButton.setFont(new Font("Courier New", Font.PLAIN, 12));
        cardNumberTextField.setFont(new Font("Courier New", Font.PLAIN, 12));
        
        nextButton.setFont(new Font("Courier New", Font.PLAIN, 12));
		backButton.setFont(new Font("Courier New", Font.PLAIN, 12));
        submitButton.setFont(new Font("Courier New", Font.PLAIN, 12));
        
        // ------------------------------------- ADDS PANEL LABELS
        contentPane.add(logoLabel);

        contentPane.add(formTitle1);
        contentPane.add(formTitle2);

        contentPane.add(eTypeLabel);
        contentPane.add(eNameLabel);
        contentPane.add(eQuantityLabel);
        contentPane.add(rentalTimeLabel);
        contentPane.add(rentalDateLabel);
        contentPane.add(amountDueLabel);

        contentPane.add(formTitle3);
        contentPane.add(paymentMethodLabel);
        contentPane.add(cardNumberLabel);

        // ---------------------------------------- ADD PANEL INPUTS
        contentPane.add(eTypeComboBox);
        contentPane.add(eNameComboBox);
        contentPane.add(eQuantityComboBox);
        contentPane.add(rentalTimeField);
        contentPane.add(rentalDateChooser);
        contentPane.add(amountDueTextField);
        
        contentPane.add(cashRadioButton);
        contentPane.add(cardRadioButton);
            payMethodGroup = new ButtonGroup();
            payMethodGroup.add(cashRadioButton);
            payMethodGroup.add(cardRadioButton);
        contentPane.add(cardNumberTextField);

        contentPane.add(nextButton);
        contentPane.add(submitButton);
        contentPane.add(backButton);

        // VISIBILITY
        // ------------------------------------- UNTIL NEXT BUTTON CLICKED
        formTitle3.setVisible(false);
        paymentMethodLabel.setVisible(false);
        cashRadioButton.setVisible(false);
        cardRadioButton.setVisible(false);
        cardNumberLabel.setVisible(false);
        cardNumberTextField.setVisible(false);

        // ------------------------------------- UNTIL PAYMENT INFO COLLECTED
        submitButton.setVisible(false);

        // ACTION LISTENERS
        // ------------------------------------- NAME IS ADJUSTED BASED ON EQUIPMENT TYPE
        eTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // GETS THE SELETED OPTION FROM THE COMBO BOX AND CHANGES IT TO A STRING
                String selectedOption = (String) eTypeComboBox.getSelectedItem();

                // SWITCH CASE TO DISPLAY AMOUNT DUE BASED ON TYPE
                if (selectedOption.equals("Staging")) {
                    eNameComboBox.removeAllItems();
                    eNameComboBox.addItem("Wall Components");
                    eNameComboBox.addItem("Decks");
                    eNameComboBox.addItem("Handrails");
                } else if ((selectedOption.equals("Lighting"))) {
                    eNameComboBox.removeAllItems();
                    eNameComboBox.addItem("LED Lights");
                    eNameComboBox.addItem("Disco Lights");
                    eNameComboBox.addItem("Dimmers");
                } else if ((selectedOption.equals("Power"))) {
                    eNameComboBox.removeAllItems();
                    eNameComboBox.addItem("Cables");
                    eNameComboBox.addItem("Light Switches");
                } else if (selectedOption.equals("Sound")) {
                    eNameComboBox.removeAllItems();
                    eNameComboBox.addItem("Microphone");
                    eNameComboBox.addItem("Speakers");
                    eNameComboBox.addItem("Amplifier");
                }
            }
        }); // END OF ACT.LIS.

        // ------------------------------------- AMOUNT DUE IS ADJUSTED BASED ON EQUIPMENT TYPE
        eTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // GETS THE SELETED OPTION FROM THE COMBO BOX AND CHANGES IT TO A STRING
                String selectedOption = (String) eTypeComboBox.getSelectedItem();
                String quantity = (String) eQuantityComboBox.getSelectedItem();
                int quantityOption = Integer.valueOf(quantity);

                // VARIABLE FOR PRICE
                int calc;

                // switch case to display amount due based on type selected
                if (selectedOption.equals("Staging")) {
                    calc = quantityOption * 1100; // calculates quantity * base price
                    amountDue = Integer.toString(calc); // to string to put back in form
                    amountDueTextField.setText(amountDue); // puts back in form
                } else if ((selectedOption.equals("Lighting") || 
                            (selectedOption.equals("Power")))) {
                    calc = quantityOption * 2000; // calculates
                    amountDue = Integer.toString(calc); // to string to put back in form
                    amountDueTextField.setText(amountDue); // puts back in form
                } else if (selectedOption.equals("Sound")) {
                    calc = quantityOption * 3000; // calculates
                    amountDue = Integer.toString(calc); // to string to put back in form
                    amountDueTextField.setText(amountDue); // puts back in form
                }
            }
        }); // END OF ACT.LIS.

        // ------------------------------------- VALIDATION FOR HALF OF FORM
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // VARIABLE FOR TIME FIELD
                String time = rentalTimeField.getText();
                int hours = Integer.parseInt(time.substring(0, 2));
                int minutes = Integer.parseInt(time.substring(3, 5));

                // VARIABLE FOR DATE FIELD
                Date date = rentalDateChooser.getDate();

                // VALIDATION OF DATE & TIME
                if (date != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int year = calendar.get(Calendar.YEAR);

                    if (year < 2023) {
                        JOptionPane.showMessageDialog(frame,"Invalid Date. \nPlease Try Again.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else if (hours > 24 || minutes > 59) {
                        JOptionPane.showMessageDialog(frame,"Invalid Time. \nPlease Try Again.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        setBounds(100, 100, 450, 650);
                        setLocationRelativeTo(null);
                        
                        formTitle3.setVisible(true);
                        paymentMethodLabel.setVisible(true);
                        cardRadioButton.setVisible(true);
                        cashRadioButton.setVisible(true);

                        nextButton.setVisible(false);

                        backButton.setBackground(new Color(255, 255, 255));
                        sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 24, SpringLayout.SOUTH, cashRadioButton);
                        sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, contentPane);
                        sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -250, SpringLayout.EAST, contentPane);
                    }
                }
            }
        }); // END OF ACT.LIS.

        // ------------------------------------- PAYMENT BY CARD
        cardRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		        
                setLocationRelativeTo(null);

                cardNumberLabel.setVisible(true);
                cardNumberTextField.setVisible(true);
                submitButton.setVisible(true);
                
                backButton.setBackground(new Color(255, 255, 255));
                sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 24, SpringLayout.SOUTH, cardNumberTextField);
                sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, contentPane);
                sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -250, SpringLayout.EAST, contentPane);
                
                submitButton.setBackground(new Color(255, 255, 255));
                sl_contentPane.putConstraint(SpringLayout.NORTH, submitButton, 24, SpringLayout.SOUTH, cardNumberTextField);
                sl_contentPane.putConstraint(SpringLayout.WEST, submitButton, 250, SpringLayout.WEST, backButton);
                sl_contentPane.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, contentPane);
            }
        }); // END OF ACT.LIS.

        // ------------------------------------- PAYMENT BY CASH
        cashRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardNumberLabel.setVisible(false);
                cardNumberTextField.setVisible(false);
                submitButton.setVisible(true);

                if (cashRadioButton.isSelected()) {
                    setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(frame,
                            "Cash Payments must be made two days prior to the rental date requested."
                            + "\nFailure to do so will result in a cancellation of your rental request.");
                } // ENDS IF STATEMENT
                
                backButton.setBackground(new Color(255, 255, 255));
                sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 6, SpringLayout.SOUTH, cashRadioButton);
                sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, contentPane);
                sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -250, SpringLayout.EAST, contentPane);
                
                submitButton.setBackground(new Color(255, 255, 255));
                sl_contentPane.putConstraint(SpringLayout.NORTH, submitButton, 6, SpringLayout.SOUTH, cashRadioButton);
                sl_contentPane.putConstraint(SpringLayout.WEST, submitButton, 250, SpringLayout.WEST, backButton);
                sl_contentPane.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, contentPane);
            }
        }); // END OF ACT.LIS.

        // ------------------------------------- BACK BUTTON
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GrizzMainMenu().setVisible(true);
                dispose();
            }
        }); // END OF ACT.LIS.

        // ------------------------------------- SUBMIT BUTTON
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int eID = generatedID();
                Customer customer = new Customer();
                int c_ID = customer.getCID();
                String name = (String) eNameComboBox.getSelectedItem();
                String type = (String) eTypeComboBox.getSelectedItem();
                int quantity = Integer.parseInt((String) eQuantityComboBox.getSelectedItem());
                Date date = rentalDateChooser.getDate();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH);
                    int year = calendar.get(Calendar.YEAR);
                    // CREATE A DATE OBJECT USING CALENDAR
                    calendar.set(year, day, month);
                Date chosenDate = calendar.getTime();
                java.sql.Date sqlDate = new java.sql.Date(chosenDate.getTime());
                double amountDue = Double.parseDouble(amountDueTextField.getText());
                String eventScheduled = "Party";
                
                Equipment equipment = new Equipment(eID, name, type, amountDue, quantity, sqlDate, eventScheduled);
                CustomerClient client = new CustomerClient();
                client.sendEquipment(equipment);
                client.sendCustomerID(c_ID);
                client.sendAction("Equipment Request");
                try {
					client.receiveResponse();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                // IF REQUEST WAS SUCCESSFUL, OPEN CUSTOMER MENU
                if (client.getActionResult() == true) {
                    new CustomerMainMenu().setVisible(true);
                    dispose();
                }
            }
        }); // END OF ACT.LIS.

        // SETS SELECTED VALUE OF COMPONENTS
        eTypeComboBox.setSelectedIndex(1);
        eNameComboBox.setSelectedIndex(2);
        eQuantityComboBox.setSelectedIndex(0);
		formatted.setPlaceholderCharacter('_');
		formatted.setAllowsInvalid(false);
        rentalTimeField.setColumns(10);
        rentalDateChooser.setDate(new Date());
        amountDueTextField.setColumns(10);
        amountDueTextField.setEditable(false);
        cardNumberTextField.setColumns(10);
    } // END OF DEFAULT CONSTRUCTOR

	// RANDOMLY GENERATED ID NUMBER
	public static int generatedID() {
        Random random = new Random();
        int id = 9999;

        for (int i = 1000; i < id; i++) {
            id = random.nextInt(id) + 1000;
        }
        return id;
    }
} // END OF EQUIPMENTFORM CLASS