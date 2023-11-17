//Programmer Name : Nathalea Evans
//Student ID # : 2101707
//Date : Nov 5, 2023
package model;

//IMPORT SERIALIZABLE COMPONENT
import java.io.Serializable;

public class Employee implements Serializable{

 // ATTRIBUTES
 private int empID; // EMPLOYEE USERNAME
 private String empPass; // EMPLOYEE PASSWORD

 // CONSTRUCTORS
 public Employee() { 
     empID = 0;
     empPass = "";
 }
 
 public Employee(int empID, String empPass) {
     this.empID = empID;
     this.empPass = empPass;
 }

 // GETTERS
 public int getEmpID() {
     return empID;
 }

 public String getEmpPass() {
     return empPass;
 }

 // SETTERS
 public void setEmpID(int empID) {
     this.empID = empID;
 }

 public void setEmpPass(String empPass) {
     this.empPass = empPass;
 }

 // TOSTRING
 public String toString() {
     return "Employee [Employee ID = " + empID + "Employee Password = " + empPass + "]";
 }
} // END OF EMPLOYEE CLASS
