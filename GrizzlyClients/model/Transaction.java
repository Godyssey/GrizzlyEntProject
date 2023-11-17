// Programmer Name : Alex-Ann Burrell
// Student ID # : 2100398
// Date : Nov 10, 2023
package model;

// IMPORT DATE COMPONENTS
import java.util.Date;

public class Transaction {
    private int tID;
    private int equipmentID;
    private Date rentalDate;
    private String amountDue;

    public Transaction() {
        this.tID = 0;
        this.rentalDate = new Date();
        this.amountDue = "";
    }
    
    // G E T T E R S   A N D   S E T T E R S
	public int gettID() {
		return tID;
	}

	public void settID(int tID) {
		this.tID = tID;
	}

	public int getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(int equipmentID) {
		this.equipmentID = equipmentID;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(String amountDue) {
		this.amountDue = amountDue;
	}
	
	// ----------------- OLD ONES
	
//    public Transaction(int tID, Date rentalDate, String amountDue) {
//        this.tID = tID;
//        this.rentalDate = rentalDate;
//        this.amountDue = amountDue;
//    }
//
//    public int getTID() {
//        return tID;
//    }
//
//    public void setTID(int tID) {
//        this.tID = tID;
//    }
//
//    public Equipment getEquipment() {
//        return equipment;
//    }
//
//    public int getEquipmentID() {
//        return equipment.getEID();
//    }
//
//    public Date getRentalDate() {
//        return rentalDate;
//    }
//
//    public void setRentalDate(Date rentalDate) {
//        this.rentalDate = new Date();
//    }
//
//    public String getAmountDue() {
//        return amountDue;
//    }
//
//    public void setAmountDue(String amountDue) {
//        this.amountDue = "";
//    }

    // TOSTRING METHOD
    public String toString() {
        return "Transaction [Transaction ID = " + tID + ", Equipment ID = " + equipmentID + 
                ", Rental Date = " + rentalDate + ", Amount Due = " + amountDue + "]";
    }



}
