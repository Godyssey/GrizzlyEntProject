// Programmer Name : Alex-Ann Burrell
// Student ID # : 2100398
// Date : Nov 5, 2023
package controller;

import java.io.*;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Employee;
import model.Equipment;
import model.Message;
import model.Transaction;

public class EmployeeClient {
    private Socket connectionSocket;
    private ObjectOutputStream outObj;
    private ObjectInputStream inObj;
    private String action;
    private boolean actionResult;

    private static final Logger logger = LogManager.getLogger(EmployeeClient.class);

    public EmployeeClient() throws IOException {
    	 createConnection();
		 configureStreams();
		 new Thread(this::receiveResponse).start(); // Start a separate thread for receiving responses
    }
    
    private void createConnection() throws IOException {
        connectionSocket = new Socket("127.0.0.1", 3307);
        logger.info("Grizzly Client Streams Connected to Grizzly Server");
    }
    
    private void configureStreams() throws IOException {
        outObj = new ObjectOutputStream(connectionSocket.getOutputStream());
        inObj = new ObjectInputStream(connectionSocket.getInputStream());
        logger.info("Grizzly Client Streams Configured");
    }

    public void closeConnections() {
        try {
            outObj.close();
            inObj.close();
            connectionSocket.close();
            logger.info("Grizzly Client Streams Closed");
        } catch (IOException e) {
            logger.error("Error closing connections: " + e.getMessage());
        }
    }

    public void sendAction(String action) {
        this.action = action;
        try {
            outObj.writeObject(action);
            logger.info("Grizzly Client Sent Action: " + action);
        } catch (IOException ex) {
            logger.error("Action Error: " + ex.getMessage());
        }
    }

    public void sendEmployee (Employee empObj) {
        try {
            outObj.writeObject(empObj);
            logger.info("Grizzly Client Sent Employee: " + empObj.toString());
        } catch (IOException ex) {
            logger.error("Employee Error: " + ex.getMessage());
        }
    }

    public void sendEquipment (Equipment equipObj) {
        try {
            outObj.writeObject(equipObj);
            logger.info("Grizzly Client Sent Equipment: " + equipObj.toString());
        } catch (IOException ex) {
            logger.error("Equipment Error: " + ex.getMessage());
        }
    }

    public void sendMessage (Message messObj) {
        try {
            outObj.writeObject(messObj);
            logger.info("Grizzly Client Sent Message: " + messObj.toString());
        } catch (IOException ex) {
            logger.error("Message Error: " + ex.getMessage());
        }
    }

    public void sendTransaction (Transaction transObj) {
        try {
            outObj.writeObject(transObj);
            logger.info("Grizzly Client Sent Transaction: " + transObj.toString());
        } catch (IOException ex) {
            logger.error("Transaction Error: " + ex.getMessage());
        }
    }
    public void sendEmployeeID(int empID) {
        try {
            outObj.writeObject(empID);
            logger.info("Grizzly Client Sent Employee ID: " + empID);
        } catch (IOException ex) {
            logger.error("Employee ID Error: " + ex.getMessage());
        }
    }

    public void sendEmployeePassword (String empPass) {
        try {
            outObj.writeObject(empPass);
            logger.info("Grizzly Client Sent Employee Password: " + empPass);
        } catch (IOException ex) {
            logger.error("Employee Password Error: " + ex.getMessage());
        }
    }

    public void sendEquipmentID(int eID) {
        try {
            outObj.writeObject(eID);
            logger.info("Grizzly Client Sent Equipment ID: " + eID);
        } catch (IOException ex) {
            logger.error("Equipment ID Error: " + ex.getMessage());
        }
    }

    public void sendMessageID(int messageID) {
        try {
            outObj.writeObject(messageID);
            logger.info("Grizzly Client Sent Message ID: " + messageID);
        } catch (IOException ex) {
            logger.error("Employee ID Error: " + ex.getMessage());
        }
    }

    public void sendTransactionID(int tID) {
        try {
            outObj.writeObject(tID);
            logger.info("Grizzly Client Sent Transaction ID: " + tID);
        } catch (IOException ex) {
            logger.error("Transaction ID Error: " + ex.getMessage());
        }
    }

    public void receiveResponse() {
        try {
            while (true) {
                action = (String) inObj.readObject(); // Read the action before processing

                switch (action) {
                    case "Login Employee":
                        Boolean flag = (Boolean) inObj.readObject();
                        if (flag) {
                            logger.info("Grizzly Client Received Response: Employee Successfully Logged In");
                            setActionResult(true);
                        } else {
                            logger.info("Grizzly Client Received Response: Employee Not Logged In");
                            JOptionPane.showMessageDialog(null, "PLEASE TRY AGAIN", action, JOptionPane.ERROR_MESSAGE);
                            setActionResult(false);
                        }
                        break;
                    case "Create Invoice":
                        Transaction transObj = (Transaction) inObj.readObject();
                        logger.info("Grizzly Client Received Information for Invoice: " + transObj.gettID());
                        break;
                    case "Schedule Equipment":
                        Equipment equipObj = (Equipment) inObj.readObject();
                        // Handle Schedule Equipment response
                        break;
                    case "View All Equipment":
                        equipObj = (Equipment) inObj.readObject();
                        // Handle View All Equipment response
                        break;
                    case "View All Requests":
                        equipObj = (Equipment) inObj.readObject();
                        // Handle View All Requests response
                        break;
                    case "View Customer Messages":
                        Message messObj = (Message) inObj.readObject();
                        // Handle View Customer Messages response
                        break;
                    default:
                        logger.warn("Unrecognized action: " + action);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            logger.error("Error receiving response: " + ex.getMessage());
        }
    }

    public boolean getActionResult() {
        return actionResult;
    }

    private void setActionResult(boolean actionResult) {
        this.actionResult = actionResult;
    }

    public static void main(String[] args) throws IOException {
        new EmployeeClient();
    }
}
