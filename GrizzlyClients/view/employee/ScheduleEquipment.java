// Programmer Name : Nathalea Evans
// Student ID # : 2101707
// Date : Nov 6, 2023

package view.employee;

// Imports
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleEquipment extends JFrame {

    // Attributes
    private JPanel contentPanel;
    private SpringLayout sl_contentPanel;

    private JLabel logoLabel;
    private JLabel formTitleLabel;
    private JLabel equipID;
    private JLabel custID;
    private JLabel date;
    private JLabel error;

    private JButton check;
    private JButton cancel;
    private JButton save;
    private JTextField equipIDField;
    private JTextField custIDField;
    private JTextField textField;

    // Constructor
    public ScheduleEquipment() { // Default Constructor

        // Attribute Initializations

        // JPanel and JFrame
        contentPanel = new JPanel();
        sl_contentPanel = new SpringLayout();

        setTitle("Grizzly's Entertainment & Equipment Rental | Schedule Equipment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 634, 422);
        setLocationRelativeTo(null);

        contentPanel.setBackground(new Color(198, 173, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(sl_contentPanel);
        setContentPane(contentPanel);

        sl_contentPanel.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, logoLabel, 200, SpringLayout.WEST, contentPanel);

        // JLabels
        logoLabel = new JLabel("G");
        logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

        formTitleLabel = new JLabel("SCHEDULE EQUIPMENTS");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, formTitleLabel, 19, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, formTitleLabel, 177, SpringLayout.WEST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, formTitleLabel, -125, SpringLayout.EAST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, logoLabel, -9, SpringLayout.NORTH, formTitleLabel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, logoLabel, -2, SpringLayout.WEST, formTitleLabel);
        formTitleLabel.setFont(new Font("Courier New", Font.BOLD, 22));

        equipID = new JLabel("Equipment ID:");
        equipID.setForeground(Color.BLACK);
        equipID.setFont(new Font("Courier New", Font.PLAIN, 13));

        custID = new JLabel("Customer ID:");
        sl_contentPanel.putConstraint(SpringLayout.WEST, custID, 32, SpringLayout.WEST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, equipID, 0, SpringLayout.WEST, custID);
        custID.setForeground(Color.BLACK);
        custID.setFont(new Font("Courier New", Font.PLAIN, 12));

        date = new JLabel("Date:");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, date, 36, SpringLayout.SOUTH, custID);
        sl_contentPanel.putConstraint(SpringLayout.WEST, date, 32, SpringLayout.WEST, contentPanel);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Courier New", Font.PLAIN, 12));

        error = new JLabel("There is currently no stock of this equipment.");
        sl_contentPanel.putConstraint(SpringLayout.WEST, error, 0, SpringLayout.WEST, equipID);
        error.setForeground(new Color(255, 0, 128));
        error.setFont(new Font("Courier New", Font.PLAIN, 11));
        error.setVisible(false);

        // JButtons

        // Check Button
        check = new JButton("Check");
        sl_contentPanel.putConstraint(SpringLayout.NORTH, check, -3, SpringLayout.NORTH, equipID);
        check.setBackground(new Color(255, 255, 255));
        check.setFont(new Font("Courier New", Font.PLAIN, 12));

        cancel = new JButton("Cancel");
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, date, -60, SpringLayout.NORTH, cancel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, custID, -110, SpringLayout.NORTH, cancel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, error, -148, SpringLayout.NORTH, cancel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, check, -172, SpringLayout.NORTH, cancel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, equipID, -177, SpringLayout.NORTH, cancel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, cancel, 60, SpringLayout.WEST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, cancel, -42, SpringLayout.SOUTH, contentPanel);
        cancel.setBackground(new Color(255, 255, 255));
        cancel.setFont(new Font("Courier New", Font.PLAIN, 12));

        save = new JButton("Save");
        sl_contentPanel.putConstraint(SpringLayout.WEST, save, 470, SpringLayout.WEST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, save, -42, SpringLayout.SOUTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, save, -77, SpringLayout.EAST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, cancel, -327, SpringLayout.WEST, save);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, save, 0, SpringLayout.NORTH, cancel);
        save.setBackground(new Color(255, 255, 255));
        save.setFont(new Font("Courier New", Font.PLAIN, 12));

        equipIDField = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, equipIDField, 66, SpringLayout.SOUTH, logoLabel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, equipIDField, 42, SpringLayout.EAST, equipID);
        sl_contentPanel.putConstraint(SpringLayout.EAST, equipIDField, -238, SpringLayout.EAST, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, check, 25, SpringLayout.EAST, equipIDField);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, equipIDField, -9, SpringLayout.NORTH, error);
        contentPanel.add(equipIDField);
        equipIDField.setColumns(10);

        custIDField = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.NORTH, custIDField, 25, SpringLayout.SOUTH, error);
        sl_contentPanel.putConstraint(SpringLayout.WEST, custIDField, 67, SpringLayout.EAST, custID);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, custIDField, -103, SpringLayout.NORTH, cancel);
        sl_contentPanel.putConstraint(SpringLayout.EAST, custIDField, -233, SpringLayout.EAST, contentPanel);
        contentPanel.add(custIDField);
        custIDField.setColumns(10);

        // Add Components to JPanel
        contentPanel.add(logoLabel);
        contentPanel.add(formTitleLabel);
        contentPanel.add(equipID);
        contentPanel.add(custID);
        contentPanel.add(date);
        contentPanel.add(error);
        contentPanel.add(check);
        contentPanel.add(cancel);
        contentPanel.add(save);

        textField = new JTextField();
        sl_contentPanel.putConstraint(SpringLayout.WEST, textField, -192, SpringLayout.EAST, custIDField);
        sl_contentPanel.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, date);
        sl_contentPanel.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, custIDField);
        textField.setColumns(10);
        contentPanel.add(textField);

        // Add Button Functionality
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EmployeeCreate().setVisible(true);
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Successfully Scheduled Equipment", "Status",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

    } // ends Default Constructor

    // Main Function
    public static void main(String[] args) {

        // Create and Show Form
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScheduleEquipment frame = new ScheduleEquipment();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    } // ends Main Function
}
