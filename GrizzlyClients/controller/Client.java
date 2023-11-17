//
////Programmer Name : Alex-Ann Burrell
////Student ID # : 2100398
////Date : Nov 5, 2023
//
//package controller;
//
//import java.io.*;
//import java.net.Socket;
//import java.net.http.HttpClient;
//import java.util.Date;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import model.Employee;
//import model.Equipment;
//import model.Message;
//import model.Transaction;
//
//public class Client {
//    private String serverIP = "127.0.0.1";
//    private int serverPort = 3307;
//    private String action;
//
//    private Socket clientSocket;
//    private ObjectOutputStream outObj;
//    private ObjectInputStream inObj;
//	private HttpClient client;
//
//	private static final Logger logger = LogManager.getLogger(Client.class);
//	 
//    public Client() throws IOException {
//		try {
//	            clientSocket = new Socket(serverIP, serverPort);
//	            outObj = new ObjectOutputStream(clientSocket.getOutputStream());
//	            inObj = new ObjectInputStream(clientSocket.getInputStream());
//	            logger.info("Connected to the Server!");
//	            configureStreams();
//	        
//		} catch (IOException ex) {
//			logger.error("Client Configuration Error: " + ex.getMessage());    
//		}
//	}//ends constructor
// 
// private void configureStreams() throws IOException {
//     try {
//    	 
//         logger.info("Grizzly Client Streams Configured");
////         this.connected = true;
//         this.client = HttpClient.newHttpClient();     
//     } catch (Exception ex) {
//         logger.error("General Client Configuration Error: " + ex.getMessage());
//     }
// }//ends configure stream method
//
//
// public void closeConnections() throws IOException {
//     try {
//    	 
//    	 if (this.inObj != null) {
//    		    try {
//    		        this.inObj.close(); //closes the input stream
//    		    } catch (IOException ex) {
//    		        logger.error("Error closing input stream: " + ex.getMessage());
//    		    }
//    		} //ends if
//
//    		if (this.outObj != null) {
//    		    try {
//    		        this.outObj.close(); //closes the output stream
//    		    } catch (IOException ex) {
//    		        logger.error("Error closing output stream: " + ex.getMessage());
//    		    }
//    		} //ends if
//
//    		if (this.clientSocket != null) {
//    		    try {
//    		        this.clientSocket.close(); //closes the connection socket
//    		    } catch (IOException ex) {
//    		        logger.error("Error closing socket: " + ex.getMessage());
//    		    }
//    		} //ends if
//    		
//         logger.info("Grizzly Client Streams Closed");
//         
//     } catch (Exception ex) {
//         logger.error("General Client Closing Error: " + ex.getMessage());
//     }
// }//ends close connection method
//
// public void sendAction(String action) {
//     this.action = action;
//     try {
//         outObj.writeObject(action);
//         logger.info("Grizzly Client Sent Action: " + action);
//     } catch (IOException ex) {
//         logger.error("Action Error: " + ex.getMessage());
//     }
// } //ends send action method
//
// public void sendEmployee (Employee empObj) {
//     try {
//         outObj.writeObject(empObj);
//         logger.info("Grizzly Client Sent Employee: " + empObj.toString());
//     } catch (IOException ex) {
//         logger.error("Employee Error: " + ex.getMessage());
//     }
// } //ends send employee method
//
// public void sendEquipment (Equipment equipObj) {
//     try {
//         outObj.writeObject(equipObj);
//         logger.info("Grizzly Client Sent Equipment: " + equipObj.toString());
//     } catch (IOException ex) {
//         logger.error("Equipment Error: " + ex.getMessage());
//     }
// } //ends send equipment method
//
// public void sendMessage (Message messObj) {
//     try {
//         outObj.writeObject(messObj);
//         logger.info("Grizzly Client Sent Message: " + messObj.toString());
//     } catch (IOException ex) {
//         logger.error("Message Error: " + ex.getMessage());
//     }
// } //ends send message method
//
// public void sendTransaction (Transaction transObj) {
//     try {
//         outObj.writeObject(transObj);
//         logger.info("Grizzly Client Sent Transaction: " + transObj.toString());
//     } catch (IOException ex) {
//         logger.error("Transaction Error: " + ex.getMessage());
//     }
// } //ends send transaction method
// 
// public void sendEmployeeID(int empID) {
//     try {
//         outObj.writeObject(empID);
//         logger.info("Grizzly Client Sent Employee ID: " + empID);
//     } catch (IOException ex) {
//         logger.error("Employee ID Error: " + ex.getMessage());
//     }
// }//ends send employee id method
//
// public void sendEmployeePassword (String empPass) {
//     try {
//         outObj.writeObject(empPass);
//         logger.info("Grizzly Client Sent Employee Password: " + empPass);
//     } catch (IOException ex) {
//         logger.error("Employee Password Error: " + ex.getMessage());
//     }
// } //ends send employee password mthod
//
// public void sendEquipmentID(int eID) {
//     try {
//         outObj.writeObject(eID);
//         logger.info("Grizzly Client Sent Equipment ID: " + eID);
//     } catch (IOException ex) {
//         logger.error("Equipment ID Error: " + ex.getMessage());
//     }
// } //ends send eq id method
//
// public void sendMessageID(int messageID) {
//     try {
//         outObj.writeObject(messageID);
//         logger.info("Grizzly Client Sent Message ID: " + messageID);
//     } catch (IOException ex) {
//         logger.error("Employee ID Error: " + ex.getMessage());
//     }
// } //ends send message id method
//
// public void sendTransactionID(int tID) {
//     try {
//         outObj.writeObject(tID);
//         logger.info("Grizzly Client Sent Transaction ID: " + tID);
//     } catch (IOException ex) {
//         logger.error("Transaction ID Error: " + ex.getMessage());
//     }
// } //ends send tid method
//
// public void receiveResponse() {
//     try {
//         switch (action) {
//         case "Login Employee":
//             Employee empObj = (Employee) inObj.readObject();
//             logger.info("Grizzly Client Received Employee: " + empObj.getEmpID());
//             break;
//         case "Create Invoice":
//             Transaction transObj = (Transaction) inObj.readObject();
//             logger.info("Grizzly Client Received Information for Invoice: " + transObj.gettID());
//             break;
//         case "Schedule Equipment":
//             Equipment equipObj = (Equipment) inObj.readObject();
//             logger.info("Grizzly Client Received Equipment: " + equipObj.getEventScheduled());
//             break;
//         case "View All Equipment":
//             equipObj = (Equipment) inObj.readObject();
//             String eName = equipObj.getEName();
//             String eType = equipObj.getEType();
//             int eQuantity = equipObj.getEQuantity(); 
//             logger.info("Grizzly Client Received All Equipment: ");
//             break;
//         case "View All Requests":
//             equipObj = (Equipment) inObj.readObject();
//             int eID = equipObj.getEID();
//             eName = equipObj.getEName();
//             eType = equipObj.getEType();
//             eQuantity = equipObj.getEQuantity();
//             double ePrice = equipObj.getEPrice();
//             Date rentalDate = equipObj.getRentalDate();
//             logger.info("Grizzly Client Received All Requests: \nEquipment Request [ID = " + eID + 
//                         "Name = " + eName + " Type = " + eType + " Quantity = " + eQuantity + 
//                         " Price = " + ePrice + " Rental Date = " + rentalDate + "]");
//             break;
//         case "View Customer Messages":
//             Message messObj = (Message) inObj.readObject();
//             logger.info("Grizzly Client Received Customer Message: " + messObj.toString());
//             break;
//         }//ends switch case
//     } catch (ClassCastException ex) {
//         logger.error("Class Cast Error: " + ex.getMessage());
//     } catch (ClassNotFoundException ex) {
//         logger.error("Class Not Found Error: " + ex.getMessage());
//     } catch (IOException ex) {
//         logger.error("IO Error: " + ex.getMessage());
//     } catch (Exception ex) {
//         logger.error("General Error: " + ex.getMessage());
//     }
// } //ends receive response method
//
//
//
// public static void main(String[] args) {
//     try {
//		new Client();
//	} catch (IOException e) {
//		System.out.println("IO Error in Client: ");
//		e.printStackTrace();
//	}
// }
//}
//
