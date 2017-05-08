package Algo.Test;

import java.sql.*;
import java.util.*;

/**
 * This class provides the methods to interact with My SQL database and and add data in database.
 * @author Rajesh Kumar
 *
 */
public class ProcessBatchAndAddInDatabase {
	
	/**
	 * This method takes the list of employee object and adds all of the employee data in the My SQL database.
	 * @param empList
	 */
	public synchronized void addEmployeeDetails(List<Employee> empList) {
		try{		
				
				Connection conn = DBUtil.getConnection(2); //Get My SQL database connection information
				//Create CallableStatement to call database stored procedure
				CallableStatement callableStatement = conn.prepareCall("call addEmployee(?,?,?,?)"); 
				
				//Create batch of Employee data by adding the parameter list in the CallableStatement.
				for(Employee emp : empList)	{			
					callableStatement.setString(1, emp.getFirstName());
					callableStatement.setString(2, emp.getLastName());
					callableStatement.setString(3, emp.getGender());
					callableStatement.setDouble(4, emp.getSalary());				
					callableStatement.addBatch();
				}
				
				//Execute the batch to add all of the batch data in the database.
				callableStatement.executeBatch();
			
//			int[] updateCounts = callableStatement.executeBatch();			
//			System.out.println("Total Records Inserted are : " + updateCounts.length  );
			
		//Catch exception and take appropriate to manage logging. 	
		}catch(SQLException ex){
			DBUtil.showErrorMessage(ex);
		}
		catch(ClassNotFoundException ex){
			DBUtil.showErrorMessage(ex);
		}
		catch(Exception ex){
			DBUtil.showErrorMessage(ex);
		}		
	}
}
