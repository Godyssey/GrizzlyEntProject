// Programmer Name : Nathalea Evans
// Student ID # : 2101707
// Date : Nov 6, 2023

package view.employee;

// IMPORT JAVAX SWING COMPONENTS
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

// IMPORT ACTION LISTENER
import java.awt.event.*;

// IMPORT CUSTOMIZATION
import java.awt.*;

// IMPORT SQL
import java.sql.*;

// IMPORT PROJECT CLASSES
import view.employee.EmployeeMainMenu;

public class ViewAllRequests extends JFrame {

    // Attributes
    private JPanel contentPane;
    private SpringLayout sl_contentPane;

    private JLabel formTitleLabel;
    private JLabel logoLabel;

    private JButton goBack;

    private static Connection myConn = null;
    private ResultSet resultSet;
    private Statement statement;

    private String url = "jdbc:mysql://localhost:3307/grizzlyentertainment";
    private String user = "root";
    private String pass = "usbw";

    private JTable table;
    private DefaultTableModel model;
    private JScrollPane tableScrollPane;

    private String query;
    private String[] columnNames = { "name", "type", "quantity", "availability" };

    private int flag = 0;

    // Constructor
    public ViewAllRequests() { // Default Constructor

        // Frame Customization
        setTitle("Grizzly's Entertainment & Equipment Rental | View All Requests");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 650);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(198, 173, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);

        // ---------------------------------------- PANEL LABELS AND HEADER
        logoLabel = new JLabel("G");
        formTitleLabel = new JLabel("VIEW ALL REQUESTS");

        // ---------------------------------------- DISPLAY TABLE
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        // Initialize Table
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        try {
            // Connect to database
            myConn = DriverManager.getConnection(url, user, pass);
            // Create statement object
            statement = myConn.createStatement();

            // Create SQL Query
            query = "SELECT * FROM equipment";

            // Execute query and store result
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                // ! Change Variable Names to Rental Requests DB
                String equipmentName = resultSet.getString("name");
                String equipmentType = resultSet.getString("type");
                String equipmentQuantity = resultSet.getString("quantity");
                String equipmentAvailability = resultSet.getString("availability");

                String[] row = { equipmentName, equipmentType, equipmentQuantity,
                        equipmentAvailability };

                model.addRow(row);

                // Increment flag
                flag++;
            } // end while

            if (flag >= 1) {
                System.out.println(flag + " Records Found");
            } else {
                System.out.println(flag + " Records Found");
            } // end if-else

        } catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // ---------------------------------------- BUTTONS
        goBack = new JButton("Go Back");
        goBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EmployeeMainMenu().setVisible(true);
            }
        });

        // ---------------------------------------- SPRING LAYOUT

        // Logo
        logoLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 32));
        sl_contentPane.putConstraint(SpringLayout.NORTH, logoLabel, 10, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, logoLabel, 150, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, logoLabel, 150, SpringLayout.EAST, contentPane);

        formTitleLabel.setFont(new Font("Courier New", Font.BOLD, 22));
        sl_contentPane.putConstraint(SpringLayout.NORTH, formTitleLabel, 12, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, formTitleLabel, 50, SpringLayout.WEST, logoLabel);
        sl_contentPane.putConstraint(SpringLayout.EAST, formTitleLabel, 50, SpringLayout.EAST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, table, 30, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, table, -10, SpringLayout.EAST, contentPane);

        sl_contentPane.putConstraint(SpringLayout.NORTH, scroll, 50, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, scroll, 10, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, scroll, 500, SpringLayout.NORTH, contentPane);

        goBack.setBackground(new Color(255, 255, 255));
        goBack.setFont(new Font("Courier New", Font.PLAIN, 12));
        sl_contentPane.putConstraint(SpringLayout.SOUTH, goBack, -34, SpringLayout.SOUTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, goBack, 150, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, goBack, -150, SpringLayout.EAST, contentPane);

        // ---------------------------------------- ADD ELEMENTS TO PANEL
        contentPane.add(logoLabel);
        contentPane.add(formTitleLabel);
        contentPane.add(scroll);
        // contentPane.add(table);
        contentPane.add(goBack);

        // ---------------------------------------- ADD PANEL TO JFRAME
        // add(contentPane);
        setVisible(true);

    } // ends Default Constructor

    // Main Function
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewAllEquipment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    } // ends Main Function

}