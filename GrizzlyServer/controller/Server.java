// Programmer Name : Alex-Ann Burrell
// Student ID # : 2100398
// Date : Nov 5, 2023
package controller;

// IMPORT JAVAX SWING COMPONENTS
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// IMPORT NETBEAN, SQL & IO COMPONENTS
import java.net.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

// IMPORT PROJECT CLASSES
import model.Customer;
import model.Employee;
import model.Equipment;
import model.Message;
import model.Transaction;

// IMPORT LOGGING COMPONENTS
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {
    private static ServerSocket serverSocket;
	private static Connection dBConn = null;
	private static PreparedStatement ps;
	private static ResultSet result = null;
    private static final Logger logger = LogManager.getLogger(Server.class);

    public Server() {
        try {
            serverSocket = new ServerSocket(3306);
            logger.info("Grizzly Server Is Listening On Port 3306");

            while (true) {
                Socket connectionSocket = serverSocket.accept();
                logger.info("New Connection Made on Grizzly Server");

                // Creating two threads for handling two types of clients (Customer and Employee)
                new ClientHandler(connectionSocket);
                
                Thread threadObj = new Thread(new ClientHandler(connectionSocket));
                threadObj.start();
            }
        } catch (IOException e) {
            logger.error("Server Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("General Server Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("ServerSocket Closing Error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("General ServerSocket Closing Error: " + e.getMessage());
            }
        }
    }
private class ClientHandler implements Runnable {
        Socket clientSocket;
        ObjectInputStream in;
        ObjectOutputStream out;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                // INSTANTIATION OF OUTPUT & INPUT STREAMS
                out = new ObjectOutputStream(clientSocket.getOutputStream());
                in = new ObjectInputStream(clientSocket.getInputStream());
                
                logger.info("Server initialized. Waiting for incoming requests...");
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("ClientHandler Closing Error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("General ClientHandler Closing Error: " + e.getMessage());
            }
        }

        @Override
        public void run() {
            String action = "";
            Server.dBConn = DBConnection.getDatabaseConnection();
            Customer custObj = null;
            Employee empObj = null;
            Equipment equipObj = null;
            Transaction transObj = null;
            Message msgObj = null;
            
            try {
                while (true) {
                	
                	Object receivedObject = in.readObject();
                	
                	if (receivedObject instanceof String) {
                		
                    action = (String) in.readObject();
	                    switch (action) {
	                        case "Login Employee":
	                            empObj = (Employee) in.readObject();
	                            int empID = empObj.getEmpID();
	                            String empPass = empObj.getEmpPass();
	                            loginEmployee(empID, empPass);
	                            out.writeObject(true);
	                            break;
	                        case "Create Invoice":
	                            transObj = (Transaction) in.readObject();
	                            // INSERT METHOD HERE
	                            out.writeObject(true);
	                            break;
	                        case "Schedule Equipment":
	                            equipObj = (Equipment) in.readObject();
	                            // INSERT METHOD HERE
	                            out.writeObject(true);
	                            break;
	                        case "View All Equipment":
	                            equipObj = (Equipment) in.readObject();
	                            String eName = equipObj.getEName();
	                            String eType = equipObj.getEType();
	                            // INSERT METHOD HERE
	                            out.writeObject(true);
	                            break;
	                        case "View All Requests":
	                            equipObj = (Equipment) in.readObject();
	                            int eID = equipObj.getEID();
	                            eName = equipObj.getEName();
	                            eType = equipObj.getEType();
	                            double ePrice = equipObj.getEPrice();
	                            // INSERT METHOD HERE
	                            out.writeObject(true);
	                            break;
	                        case "View Customer Messages":
	                            msgObj = (Message) in.readObject();
	                            int mID = msgObj.getMessageID();
	                            custObj.getCID();
	                            String mContent = msgObj.messageContent();
	                            // INSERT METHOD HERE
	                            out.writeObject(true);
	                            break;
	                        case "Login Customer":
	                            custObj = (Customer) in.readObject();
	                            int cID = custObj.getCID();
	                            String cPassword = custObj.getCPassword();
	                            loginCustomer(cID, cPassword);
	                            out.writeObject(true);
	                            break;
	                        case "Sign Up Customer":
	                            custObj = (Customer) in.readObject();
	                            signUpCustomer(custObj);
	                            out.writeObject(true);
	                            break;
	                        case "Equipment Requested":
	                            equipObj = (Equipment) in.readObject();
	                            cID = custObj.getCID();
	                            eID = equipObj.getEID();
	                            eName = equipObj.getEName();
	                            eType = equipObj.getEType();
	                            int eQuantity = equipObj.getEQuantity();
	                            Date dateOfRequest = (Date) equipObj.getRentalDate();
	                            double amountDue = equipObj.getEPrice();
	                            equipmentRequested(eID, eName, eType, eQuantity, dateOfRequest, amountDue, cID);
	                            out.writeObject(true);
	                            break;
	                        case "View All Transactions":
	                            cID = (int) in.readObject();
	                            List<Transaction> transactions = viewMultipleTransactions(cID);
	                            out.writeObject(transactions);
	                            break;
	                        case "View One Transaction":
	                            int tID = transObj.gettID();
	                            List<Transaction> transaction = viewOneTransaction(tID);
	                            out.writeObject(transaction);
	                            break;
	                        default:
	                            logger.warn("Unrecognized action: " + action);
	                    }//ends switch case
	                }
                	else {
                        logger.warn("Received unexpected object type: " + receivedObject.getClass().getName());
                    }//ends else if
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                logger.error("Class Not Found Error: " + e.getMessage());
            } catch (ClassCastException e) {
                e.printStackTrace();
                logger.error("Class Cast Error: " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("ClientHandler Error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("General ClientHandler Error: " + e.getMessage());
            } finally {
                try {
                    in.close();
                    out.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("ClientHandler Closing Error: " + e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("General ClientHandler Closing Error: " + e.getMessage());
                }
            }
        }
    }

    // LOGIN FOR EMPLOYEES
    public static boolean loginEmployee(int empID, String empPass) {
        String query = "SELECT * FROM employeelogin WHERE empID = ? AND empPass = ?";
        try {
            ps = dBConn.prepareStatement(query);
            ps.setInt(1, empID);
            ps.setString(2, empPass);
            result = ps.executeQuery();
            if (result.next()) {
                logger.info("Employee Login Successful");
            } else {
                logger.info("Employee Login Unsuccessful");
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Employee Login Error: " + e.getMessage());
            return false;
        }
    }

    // SCHEDULE EQUIPMENT

    // CREATE INVOICE

    // VIEW ALL EQUIPMENT

    // VIEW ALL REQUESTS

    // VIEW CUSTOMER MESSAGES

    // SIGN UP FOR CUSTOMERS
    public static boolean signUpCustomer(Customer cus) {
        String query = "INSERT INTO customer (cID, cFirstName, cLastName, cGender, cEmail, cPhoneNumber, cPassword) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = dBConn.prepareStatement(query);
            ps.setInt(1, cus.getCID());
            ps.setString(2, cus.getCFirstName());
            ps.setString(3, cus.getCLastName());
            ps.setString(4, cus.getCGender());
            ps.setString(5, cus.getCEmail());
            ps.setString(6, cus.getCPhoneNumber());
            ps.setString(7, cus.getCPassword());
            ps.executeUpdate();
            
            if (ps.executeUpdate(query) == 1) {
                logger.info("Customer Sign Up Successful");
                JOptionPane.showMessageDialog(null, "SUCCESS!\n" +
                                            "Your new customer ID is: " + cus.getCID());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Customer Sign Up Error: " + e.getMessage());
        }
        return false;
    }

    // LOGIN FOR CUSTOMERS
    public static boolean loginCustomer(int cID, String cPassword) {
        String query = "SELECT * FROM customer WHERE cID = ? AND cPassword = ?";
        try {
            ps = dBConn.prepareStatement(query);
            ps.setInt(1, cID);
            ps.setString(2, cPassword);
            result = ps.executeQuery();
            if (result.next()) {
                logger.info("Customer Login Successful");
            } else {
                logger.info("Customer Login Unsuccessful");
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Customer Login Error: " + e.getMessage());
            return false;
        }
    }   
    // EQUIPMENT REQUESTED
    public void equipmentRequested(int eID, String eName, String eType, int eQuantity, Date dateOfRequest, double amountDue, int cusID) {
        String query = "INSERT INTO rentalrequest (eID, cusID, eName, eType, eQuantity, rentalDate, amountDue) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = dBConn.prepareStatement(query);
            ps.setInt(1, eID);
            ps.setInt(2, cusID);
            ps.setString(3, eName);
            ps.setString(4, eType);
            ps.setInt(5, eQuantity);
            ps.setDate(6, dateOfRequest);
            ps.setDouble(7, amountDue);
            ps.executeUpdate();
            if (ps.executeUpdate(query) == 1) {
                logger.info("Equipment To Be Requested Successful");
            } else {
                logger.info("Equipment To Be Requested Unsuccessful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Equipment Requesting Error: " + e.getMessage());
        }
    }

    // CHECK RENTAL REQUEST
    public boolean checkRequest() {
        return false;
    }

    // VIEW MULTIPLE TRANSACTIONS
    public static List <Transaction> viewMultipleTransactions(int cID) {
        List<Transaction> transactionsList = new ArrayList<>();
        String query = "SELECT * FROM transaction WHERE cID = ?";
        try {
            ps = dBConn.prepareStatement(query);
            ps.setInt(1, cID);
            result = ps.executeQuery();

            DefaultTableModel transactionTable = new DefaultTableModel();

            int columns = 5;
            String[] columnName = new String [columns];
            for (int i = 0;  i < columns; i++) {
                columnName[i] = result.getMetaData().getColumnName(i + 1);
                transactionTable.addColumn(columnName[i]);
            }

            while (result.next()) {
                Transaction transObj = new Transaction();
                transObj.settID(result.getInt("tID"));
                transObj.setEquipmentID(result.getInt("eID"));
                transObj.setRentalDate(result.getDate("rentalDate"));
                transObj.setAmountDue(result.getString("amountDue"));
                transactionsList.add(transObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Retrieve Multiple Transactions Error: " + e.getMessage());
        }
        return transactionsList;
    }

    // VIEW ONE TRANSACTION
    public static List<Transaction> viewOneTransaction(int tID) {
        List<Transaction> transactionsList = new ArrayList<>();
        String query = "SELECT * FROM transaction WHERE tID = ?";
        try {
            ps = dBConn.prepareStatement(query);
            ps.setInt(1, tID);
            result = ps.executeQuery();

            while (result.next()) {
                Transaction transObj = new Transaction();
                //Equipment eqObj = new Equipment();
                transObj.settID(result.getInt("tID"));
                transObj.setEquipmentID(result.getInt("eID"));
                transObj.setRentalDate(result.getDate("rentalDate"));
                transObj.setAmountDue(result.getString("amountDue"));
                transactionsList.add(transObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Retrieve One Transaction Error: " + e.getMessage());
        }
        return transactionsList;
    }
    
    public static void main(String[] args) {
        new Server();
    }
}