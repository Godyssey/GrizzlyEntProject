//Programmer Name : Britney Vassell
//Student ID # : 2105012
//Date : Nov 2, 2023

package model;

//IMPORT SERIALIZABLE COMPONENT
import java.io.Serializable;

public class Customer implements Serializable{
 private int cID; // CUSTOMER ID
	private String cFirstName; // CUSTOMER FIRST NAME
	private String cLastName; // CUSTOMER LAST NAME
	private String cGender; // CUSTOMER GENDER
	private String cEmail; // CUSTOMER EMAIL
	private String cPhoneNumber; // CUSTOMER PHONE NUMBER

 private String cUsername; // CUSTOMER USERNAME
 private String cPassword; // CUSTOMER PASSWORD

 public Customer() {
     this.cID = 0;
     this.cFirstName = "";
     this.cLastName = "";
     this.cGender = "";
     this.cEmail = "";
     this.cPhoneNumber = "";
     this.cUsername = "";
     this.cPassword = "";
 }

 public Customer(int cID, String cFirstName, String cLastName, String cGender,
                 String cEmail, String cPhoneNumber, String cUsername, String cPassword) {
     this.cID = cID;
     this.cFirstName = cFirstName;
     this.cLastName = cLastName;
     this.cGender = cGender;
     this.cEmail = cEmail;
     this.cPhoneNumber = cPhoneNumber;
     this.cUsername = cUsername;
     this.cPassword = cPassword;
 }

 public int getCID() {
     return cID;
 }

 public void setCID(int cID) {
     this.cID = cID;
 }

 public String getCFirstName() {
     return cFirstName;
 }

 public void setCFirstName(String cFirstName) {
     this.cFirstName = cFirstName;
 }

 public String getCLastName() {
     return cLastName;
 }

 public void setCLastName(String cLastName) {
     this.cLastName = cLastName;
 }

 public String getCGender() {
     return cGender;
 }

 public void setCGender(String cGender) {
     this.cGender = cGender;
 }

 public String getCEmail() {
     return cEmail;
 }

 public void setCEmail(String cEmail) {
     this.cEmail = cEmail;
 }

 public String getCPhoneNumber() {
     return cPhoneNumber;
 }

 public void setCPhoneNumber(String cPhoneNumber) {
     this.cPhoneNumber = cPhoneNumber;
 }


 public String getCUsername() {
     return cUsername;
 }

 public void setCUsername(String cUsername) {
     this.cUsername = cUsername;
 }

 public String getCPassword() {
     return cPassword;
 }

 public void setCPassword(String cPassword) {
     this.cPassword = cPassword;
 }

 public String toString() {
		return "CUSTOMER [ID = " + cID + ", Name = " + cFirstName + " " + cLastName + 
                     ", Gender = " + cGender + ", Email = " + cEmail + ", PhoneNumber = " 
                     + cPhoneNumber + ", Username = " + cUsername + ", Password = " + cPassword + "]";
	}
}
