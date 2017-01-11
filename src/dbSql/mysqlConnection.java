package dbSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.sql.*;

import ocsf.server.ConnectionToClient;

public class mysqlConnection {
	
	static public Connection conn;	//connection to the database

	public static void Set() 
	{
		//the function defines the connection to the database
		try 
		{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {/* handle the error*/}
        
        try 
        {
        	//set connection to 'projectprototype'database (where the table 'Worker' is found)
        	//System.out.println("enter ip");
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/ibookdb","root","Braude");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed");	//print success message

            
            
     	} catch (SQLException ex) 
     	    {/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
   	}
	
	public static Object QueryHandler( Object obj)
	{
		//the function gets a query from client and executes it
		//	gets Object obj and turns it to String
		
		Statement stmt;	//SQL query
		String result = "Result: \n";	//answer to the query
		
		try 
		{
			String msg = new String(obj.toString());
			stmt = conn.createStatement();
			ResultSet rs = null;
			if(msg.contains("select"))
			{
				rs = stmt.executeQuery(msg);
				
			}
			
			else
			{
				stmt.executeUpdate(msg);
			}
			return rs;
			
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}	//handle exceptions
			//returned answer
		return result;
	}

	/*public static void addToDB(String str1, String str2) throws SQLException{
		
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("INSERT INTO worker VALUES " + "(str1,str2)");
		System.out.println("Values added, check DB for further references");
	}*/
	
	
	
	
	
}


