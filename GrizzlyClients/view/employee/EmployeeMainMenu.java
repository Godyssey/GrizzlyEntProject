// Programmer Name : Nathalea Evans
// Student ID # : 2101707
// Date : Nov 5, 2023

package view.employee;

// IMPORT JAVAX SWING COMPONENTS
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// IMPORT ACTION LISTENER COMPONENTS
import java.awt.event.*;

// IMPORT CUSTOMIZATION
import java.awt.*;

// IMPORT PROJECT CLASSES
import view.employee.*;
import view.customer.GrizzMainMenu;

public class EmployeeMainMenu extends JFrame {

    // CREATE FRAME FOR APPLICATION
    private JPanel contentPane;
    private SpringLayout sl_contentPane;

    // CREATES LABEL FOR PANEL DATA
    private JLabel logoLabel;
    private JLabel eMenuTitle;

    // CREATES INPUT TYPES FOR PANEL DATA
    // ---------------------------------------- BUTTON
    private JButton viewAllRequests;
    private JButton viewAllEquipment;
    private JButton viewCustomerMessages;
    private JButton scheduleEquipment;
    private JButton createInvoice;
    private JButton backButton;

    /*
     * public static void main(String[] args) {
     * EventQueue.invokeLater(new Runnable() {
     * public void run() {
     * try {
     * EmployeeMenu frame = new EmployeeMenu();
     * frame.setVisible(true);
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * });
     * }
     */

    // DEFAULT CONSTRUCTOR
    public EmployeeMainMenu() {

        // FRAME CUSTOMIZATION
        setTitle("Grizzly's Entertainment & Equipment Rental | Employee Menu");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 550, 550);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(177, 218, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);

        // ---------------------------------------- PANEL LABELS AND HEADER
        logoLabel = new JLabel("G");

        eMenuTitle = new JLabel("EMPLOYEE MENU");

        // ---------------------------------------- PANEL LABEL PLACEMENTS
        sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 245, SpringLayout.WEST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, eMenuTitle, 6, SpringLayout.SOUTH, logoLabel);
        sl_contentPane.putConstraint(SpringLayout.WEST, eMenuTitle, 155, SpringLayout.WEST, contentPane);

        // ---------------------------------------- PANEL LABEL FONT
        logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

        eMenuTitle.setFont(new Font("Courier New", Font.PLAIN, 24));

        // ---------------------------------------- PANEL BUTTONS
        viewAllRequests = new JButton("View All Requests");
        viewAllEquipment = new JButton("View All Equipment");
        viewCustomerMessages = new JButton("View Customer Messages");
        scheduleEquipment = new JButton("Schedule Equipment");
        createInvoice = new JButton("Create Invoice");

        backButton = new JButton("Main Menu");

        // ---------------------------------------- PANEL INPUT PLACEMENTS
        viewAllRequests.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, viewAllRequests, 34, SpringLayout.SOUTH, eMenuTitle);
        sl_contentPane.putConstraint(SpringLayout.WEST, viewAllRequests, 150, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, viewAllRequests, -150, SpringLayout.EAST, contentPane);

        viewAllEquipment.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, viewAllEquipment, 34, SpringLayout.SOUTH, viewAllRequests);
        sl_contentPane.putConstraint(SpringLayout.WEST, viewAllEquipment, 150, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, viewAllEquipment, -150, SpringLayout.EAST, contentPane);

        viewCustomerMessages.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, viewCustomerMessages, 34, SpringLayout.SOUTH,
                viewAllEquipment);
        sl_contentPane.putConstraint(SpringLayout.WEST, viewCustomerMessages, 150, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, viewCustomerMessages, -150, SpringLayout.EAST, contentPane);

        scheduleEquipment.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, scheduleEquipment, 34, SpringLayout.SOUTH,
                viewCustomerMessages);
        sl_contentPane.putConstraint(SpringLayout.WEST, scheduleEquipment, 150, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, scheduleEquipment, -150, SpringLayout.EAST, contentPane);

        createInvoice.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, createInvoice, 34, SpringLayout.SOUTH, scheduleEquipment);
        sl_contentPane.putConstraint(SpringLayout.WEST, createInvoice, 150, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, createInvoice, -150, SpringLayout.EAST, contentPane);

        backButton.setBackground(new Color(255, 255, 255));
        sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 34, SpringLayout.SOUTH, createInvoice);
        sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 150, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, backButton, -150, SpringLayout.EAST, contentPane);

        // ------------------------------------- PANEL INPUT FONTS
        viewAllRequests.setFont(new Font("Courier New", Font.PLAIN, 12));
        viewAllEquipment.setFont(new Font("Courier New", Font.PLAIN, 12));
        viewCustomerMessages.setFont(new Font("Courier New", Font.PLAIN, 12));
        scheduleEquipment.setFont(new Font("Courier New", Font.PLAIN, 12));
        createInvoice.setFont(new Font("Courier New", Font.PLAIN, 12));

        backButton.setFont(new Font("Courier New", Font.PLAIN, 12));

        // ---------------------------------------- ADD PANEL LABELS
        contentPane.add(logoLabel);
        contentPane.add(eMenuTitle);

        // ---------------------------------------- ADD PANEL INPUTS
        contentPane.add(viewAllRequests);
        contentPane.add(viewAllEquipment);
        contentPane.add(viewCustomerMessages);
        contentPane.add(scheduleEquipment);
        contentPane.add(createInvoice);

        contentPane.add(backButton);

        // ACTION LISTENERS
        // ---------------------------------------- VIEW ALL REQUESTS BUTTON
        viewAllRequests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAllRequests().setVisible(true);
                dispose();
            }
        }); // END OF ACT. LIS.

        // ---------------------------------------- VIEW ALL EQUIPMENT BUTTON
        viewAllEquipment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAllEquipment().setVisible(true);
                dispose();
            }
        }); // END OF ACT. LIS.

        // ---------------------------------------- VIEW CUSTOMER MESSAGES BUTTON
        viewCustomerMessages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerMessages().setVisible(true);
                dispose();
            }
        }); // END OF ACT. LIS.

        // ---------------------------------------- SCHEDULE EQUIPMENT BUTTON
        scheduleEquipment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScheduleEquipment().setVisible(true);
                dispose();
            }
        }); // END OF ACT. LIS.

        // ---------------------------------------- CREATE INVOICE BUTTON
        createInvoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateInvoice().setVisible(true);
                dispose();
            }
        }); // END OF ACT. LIS.

        // ---------------------------------------- BACK BUTTON
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GrizzMainMenu().setVisible(true);
                dispose();
            }
        }); // END OF ACT. LIS.
    } // END OF DEFAULT CONSTRUCTOR
} // END OF EMPLOYEEMENU CLASS
