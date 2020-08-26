package com.revature.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.bytebuddy.jar.asm.Type;

/**
 * 
 * @author Revature
 *
 *         This is a paceholder class to hold the configurations of your db
 *         connection. You should change the url, username, and password. DO NOT
 *         CHANGE THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are used to
 *         test your db schema.
 */
public class ConnectionUtil {
	//for singleton instance
	private static ConnectionUtil cu;
	
	// add your jdbc url
	public static final String URL = "jdbc:postgresql://javafs200803.ch6hwzkmseno.us-east-2.rds.amazonaws.com:5432/tier3";
	// add your jdbc username
	public static final String USERNAME = "postgres";
	// add your jdbc password
	public static final String PASSWORD = "eunice0426";
	// name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME = "";
	// name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME = "mysequence";

	// implement this method to connect to the db and return the connection object
	public static Connection connect() throws SQLException{
		//For compatibility with other technologies/frameworks will need to register our Driver
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				String url = "jdbc:postgresql://javafs200803.ch6hwzkmseno.us-east-2.rds.amazonaws.com:5432/tier3";
				String username = "postgres";
				String password = "eunice0426"; 
				
				return DriverManager.getConnection(url, username, password);
	}


	//implement this method with a callable statement that calls the absolute value sql function
	public long callAbsoluteValueFunction(long value){
		
		Connection connect;
		try {
			connect = connect();
			CallableStatement absFunction = connect.prepareCall("{ ? = call abs(?) }");
			absFunction.registerOutParameter(1, Type.VOID);
			absFunction.setLong(2, value);
			absFunction.execute();
			long result = absFunction.getLong(1);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

	//make the class into a singleton
	private ConnectionUtil(){
		super();
	}

	public static ConnectionUtil getInstance(){
		if(cu == null){
			cu = new ConnectionUtil();
		}
		return cu;
	}
}
