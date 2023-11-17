// Programmer Name : Alex-Ann Burrell
// Student ID # : 2100398
// Date : Nov 5, 2023
package controller;

import java.io.*;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Customer;
import model.Equipment;
import model.Message;
import model.Transaction;

public class CustomerClient {
    private Socket connectionSocket;
    private ObjectOutputStream outObj;
    private ObjectInputStream inObj;
    private String action;
    private boolean actionResult;

    private static final Logger logger = LogManager.getLogger(CustomerClient.class);

    public CustomerClient() {
         this.createConnection();
         this.configureStreams();
    }
    
    private void createConnection() {
        try {
            connectionSocket = new Socket("127.0.0.1", 3307);
            logger.info("Grizzly Client Streams Connected to Grizzly Server");
        } catch (IOException ex) {
            logger.error("Client Creation Error: " + ex.getMessage());
        } catch (Exception ex) {
            logger.error("General Client Creation Error: " + ex.getMessage());
        }
    }
    
    private void configureStreams() {
        try {
            outObj = new ObjectOutputStream(this.connectionSocket.getOutputStream());
            inObj = new ObjectInputStream(this.connectionSocket.getInputStream());
            logger.info("Grizzly Client Streams Configured");
        } catch (IOException ex) {
            logger.error("Client Configuration Error: " + ex.getMessage());
        } catch (Exception ex) {
            logger.error("General Client Configuration Error: " + ex.getMessage());
        }
    }

    public void closeConnections() {
        try {
            outObj.close();
            inObj.close();
            connectionSocket.close();
            logger.info("Grizzly Client Streams Closed");
        } catch (IOException ex) {
            logger.error("Client Closing Error: " + ex.getMessage());
        } catch (Exception ex) {
            logger.error("General Client Closing Error: " + ex.getMessage());
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

    public void sendCustomer (Customer cusObj) {
        try {
            outObj.writeObject(cusObj);
            logger.info("Grizzly Client Sent Customer: " + cusObj.toString());
        } catch (IOException ex) {
            logger.error("Customer Error: " + ex.getMessage());
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

    public void sendCustomerID(int cID) {
        try {
            outObj.writeObject(cID);
            logger.info("Grizzly Client Sent Customer ID: " + cID);
        } catch (IOException ex) {
            logger.error("Customer ID Error: " + ex.getMessage());
        }
    }

    public void sendCustomerPassword(String cPassword) {
        try {
            outObj.writeObject(cPassword);
            logger.info("Grizzly Client Sent Customer Password: " + cPassword);
        } catch (IOException ex) {
            logger.error("Customer Password Error: " + ex.getMessage());
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

    public void receiveResponse() throws IOException {
    	outObj = new ObjectOutputStream(this.connectionSocket.getOutputStream());
        inObj = new ObjectInputStream(this.connectionSocket.getInputStream());
        
        try {
            while (true) {
                action = (String) inObj.readObject(); // Read the action before processing

                switch (action) {
                    case "Sign Up Customer":
                        Boolean flag = (Boolean) inObj.readObject();
                        if (flag) {
                            logger.info("Grizzly Client Received Response: Customer Successfully Added");
                            setActionResult(true);
                        } else {
                            logger.info("Grizzly Client Received Response: Customer Not Added");
                            JOptionPane.showMessageDialog(null, "YOU ARE OUR NEW CUSTOMER!",
                                                             action, JOptionPane.ERROR_MESSAGE);
                            setActionResult(false);
                        }
                        break;
                    case "Login Customer":
                        flag = (Boolean) inObj.readObject();
                        if (flag) {
                            logger.info("Grizzly Client Received Response: Customer Successfully Logged In");
                            setActionResult(true);
                        } else {
                            logger.info("Grizzly Client Received Response: Customer Not Logged In");
                            JOptionPane.showMessageDialog(null, "PLEASE TRY AGAIN", 
                                                            action, JOptionPane.ERROR_MESSAGE);
                            setActionResult(false);
                        }
                        break;
                    case "Equipment Request":
                        flag = (Boolean) inObj.readObject();
                        if (flag) {
                            logger.info("Grizzly Client Received Response: Equipment Successfully Requested");
                            setActionResult(true);
                        } else {
                            logger.info("Grizzly Client Received Response: Equipment Not Requested");
                            JOptionPane.showMessageDialog(null, "PLEASE TRY AGAIN", 
                                                            action, JOptionPane.ERROR_MESSAGE);
                            setActionResult(false);
                        }
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

    public static void main(String[] args) {
        new CustomerClient();
    }
}