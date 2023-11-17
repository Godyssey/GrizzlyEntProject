// Programmer Name : Britney Vassell
// Student ID # : 2105012
// Date : Nov 2, 2023

package model;

// IMPORT
import java.util.Date;

// IMPORT SERIALIZABLE COMPONENT
import java.io.Serializable;

public class Equipment implements Serializable{
    private int eID; // EQUIPMENT ID
	private String eName; // EQUIPMENT NAME
	private String eType; // STAGING, LIGHTING, POWER OR SOUND
	private double ePrice; // EQUIPMENT PRICE
	private int eQuantity; // EQUIPMENT QUANTITY
	private Date rentalDate; // EQUIPMENT REQUESTED DATE
    private String eventScheduled; // SCHEDULED EVENT FOR EQUIPMENT

	public Equipment(int eID, String eName, String eType, double ePrice, int eQuantity, Date rentalDate,
			String eventScheduled) {
		super();
		this.eID = eID;
		this.eName = eName;
		this.eType = eType;
		this.ePrice = ePrice;
		this.eQuantity = eQuantity;
		this.rentalDate = rentalDate;
		this.eventScheduled = eventScheduled;
	}

	public int getEID() {
        return eID;
    }

    public void setEID(int eID) {
        this.eID = eID;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public double getEPrice() {
        return ePrice;
    }

    public void setEPrice(double ePrice) {
        this.ePrice = ePrice;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }
    
    public String getEType() {
    	return eType;
    }

    public void setEType(String eType) {
    	this.eType = eType;
    }

    public int getEQuantity() {
    	return eQuantity;
    }

    public void setEQuantity(int eQuantity) {
    	this.eQuantity = eQuantity;
    }

    public String getEventScheduled() {
        return eventScheduled;
    }

    public void setEventScheduled(String eventScheduled) {
        this.eventScheduled = eventScheduled;
    }

    public String toString() {
        return "Equipment [Equipment ID = " + eID + " Name = " + eName + 
        " Type = " + eType + " Price = " + ePrice + " Quantity = " +
        eQuantity + " Event Scheduled = " + eventScheduled + 
        "Rental Time = " + rentalDate + "]";
    }
}
