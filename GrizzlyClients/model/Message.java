// Programmer Name : Alex-Ann Burrell
// Student ID # : 2100398
// Date : Nov 10, 2023
package model;

public class Message {
    private int messageID;
    private Customer customer;
    private String messageContent;

    public Message() {
        this.messageID = 0;
        this.messageContent = "";
    }

    public Message(int messageID, String messageContent) {
        this.messageID = messageID;
        this.messageContent = messageContent;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getCustomerID() {
        return customer.getCID();
    }

    public String messageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    // TOSTRING METHOD
    public String toString() {
        return "Message [Message ID = " + messageID + ", Sender ID = " 
                + customer.getCID() + ", Message Content = " + messageContent + "]";
    }
}
