// Programmer Name : Nathalea Evans
// Student ID # : 2101707
// Date : Nov 6, 2023

package view.employee;

// Imports
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

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

    // Constructor
    public ScheduleEquipment() { // Default Constructor

        // Attribute Initializations

        // JPanel and JFrame
        contentPanel = new JPanel();
        sl_contentPanel = new SpringLayout();

        setTitle("Grizzly's Entertainment & Equipment Rental | View All Equipment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 650);
        setLocationRelativeTo(null);

        contentPanel.setBackground(new Color(198, 173, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(sl_contentPanel);

        sl_contentPanel.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.WEST, logoLabel, 200, SpringLayout.WEST, contentPanel);

        // JLabels
        logoLabel = new JLabel("G");
        logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));

        formTitleLabel = new JLabel("SCHEDULE EQUIPMENTS");
        formTitleLabel.setFont(new Font("Courier New", Font.BOLD, 22));

        equipID = new JLabel("Equipment ID:");
        equipID.setForeground(Color.BLACK);
        equipID.setFont(new Font("Courier New", Font.PLAIN, 12));

        custID = new JLabel("Customer ID:");
        custID.setForeground(Color.BLACK);
        custID.setFont(new Font("Courier New", Font.PLAIN, 12));

        date = new JLabel("Date:");
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Courier New", Font.PLAIN, 12));

        error = new JLabel("There is currently no stock of this equipment.");
        error.setForeground(Color.RED);
        error.setFont(new Font("Courier New", Font.PLAIN, 10));

        // JButtons

        // Check Button
        check = new JButton("Check");
        check.setBackground(new Color(255, 255, 255));
        check.setFont(new Font("Courier New", Font.PLAIN, 12));

        cancel = new JButton("Cancel");
        cancel.setBackground(new Color(255, 255, 255));
        cancel.setFont(new Font("Courier New", Font.PLAIN, 12));

        save = new JButton("Save");
        save.setBackground(new Color(255, 255, 255));
        save.setFont(new Font("Courier New", Font.PLAIN, 12));

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

        // Add

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
