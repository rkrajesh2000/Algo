package Algo.Test;

import java.sql.*;

/**
 * This is Database utility class, which provides that database connection releated information.
 * @author Rajesh Kumar
 *
 */
public class DBUtil {
	
	//Database connection string related private local member
	private static final String oraUser="hr";
	private static final String oraPwd ="hr";
	private static final String mySqlUser = "root";
	private static final String mySqlPwd = "root";
	private static final String oraCS = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String mySQLCS = "jdbc:mysql://localhost:3306/world?autoReconnect=true&useSSL=false";

	/**
	 * This method provides the database connection object to connect to the database.
	 * @param dbType
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection(int dbType) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); //Load the My SQL database JDBC driver
		
		//Based on the value passed to this method it would return the respective connection object
		switch (dbType) {
		case 1: //ORADB
			return DriverManager.getConnection(oraCS, oraUser, oraPwd);
		case 2: //MYSQLDB
			return DriverManager.getConnection(mySQLCS, mySqlUser, mySqlPwd);
		default:
			return null;
		}
	}

	/**
	 * Method to display and print the error messages.
	 * @param e
	 */
	public static void showErrorMessage(SQLException e){
		System.err.println("Error :" + e.getMessage());
		System.err.println("Error Code :" + e.getErrorCode());
	}
	
	/**
	 * Another overloaded method to display and print the error messages.
	 * @param e
	 */
	public static void showErrorMessage(ClassNotFoundException e){
		System.err.println("Error :" + e.getMessage());
		System.err.println("Error Code :" + e.hashCode());
	}
	
	/**
	 * Another overloaded method to display and print the error messages.
	 * @param e
	 */
	public static void showErrorMessage(Exception e){
		System.err.println("Error :" + e.getMessage());
		System.err.println("Error Code :" + e.hashCode());
	}	
}
