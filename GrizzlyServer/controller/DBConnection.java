// Programmer Name : Alex-Ann Burrell
// Student ID # : 2100398
// Date : Nov 5, 2023
package controller;

// IMPORT SQL COMPONENTS
import java.sql.*;

// IMPORT LOGGING COMPONENTS
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	private static java.sql.Connection myConn = null;
	private static final Logger logger = LogManager.getLogger(DBConnection.class);

	public static java.sql.Connection getDatabaseConnection() {
		String url = "jdbc:mysql://localhost:3306/geer";
		if (myConn == null) {
			try {
				myConn = DriverManager.getConnection(url, "root", "usbw");
				logger.info("Database Connection Established");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Database Connection Not Established");
			}
		}
		return myConn;
	}
}
