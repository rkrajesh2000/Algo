package Algo.Test;

import java.sql.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class FetchDataFromDB {

	public static void main(String[] args) {

		 try{  
				 //Dictionary Check
				 Dictionary<Integer,Integer> dic = new Hashtable<Integer,Integer>();
				 dic.put(1,1);
				 int i = dic.get(1);
				 dic.remove(1);
			 
			 //JDBC
			   String database="MyTestDB.mdb";//Here database exists in the current directory  
			  
			   String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}; DBQ=" + database + ";DriverID=22;READONLY=true";  
			  
			   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
			   Connection con = DriverManager.getConnection(url);  
			   Statement st = con.createStatement(); 
			   ResultSet rs = st.executeQuery("select * from login");  
			   
			   //The following excerpt from the method runStoredProcedures, calls the 
			   //stored procedure RAISE_PRICE:
/*			   String coffeeNameArg = "PetesCofee";
			   float maximumPercentageArg = 10.15f; 
			   float newPriceArg = 50.99f;
			   CallableStatement cs  = con.prepareCall("{call RAISE_PRICE(?,?,?)}");
			   cs.setString(1, coffeeNameArg);
			   cs.setFloat(2, maximumPercentageArg);
			   cs.registerOutParameter(3, Types.NUMERIC);
			   cs.setFloat(3, newPriceArg);
			   cs.registerOutParameter(4, Types.VARCHAR);
			   cs.execute();
			   int supplierId = cs.getInt(3);
			   String supplierName = cs.getString(4);*/
			   
			   
			   while(rs.next()){  
			    System.out.println(rs.getString(1));  
			   }
			   
			   if(rs.isClosed())
				   rs.close();
			   
			   if(st.isClosed())
				   st.close();
			   
			   if(con.isClosed())
				   con.close();
			   
			}catch(Exception exp){System.out.println(exp);} 
	}
}
