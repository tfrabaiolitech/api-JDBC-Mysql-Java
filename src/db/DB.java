package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	// class to get and close a connection with DB
	
	
	private static Connection conn = null; // Object type Connection for connection with JDBC
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
			Properties props = loadProperties(); // get Properties
			String url = props.getProperty("dburl"); // path DB
			conn = DriverManager.getConnection(url, props); // instance object Connection
		}
		
		catch (SQLException e) {
			throw new  DbException(e.getMessage());
		   }
		}
		
		return conn;
	}
	
	
	private static Properties loadProperties() {
		
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
			
		}
		catch(IOException e) {
			
			throw new DbException(e.getMessage());
			
		}
	}
		
		public static void closeConnection() {
			if(conn != null) {
				try {
				conn.close();
			}
				catch(SQLException e) {
					throw new DbException(e.getMessage());
					}
				}
		}
		
		


		public static void closeStatement(Statement st) {
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					 throw new DbException(e.getMessage());
					
				}
			}
			
		}
		public static void closeResultSet(ResultSet rs) {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					 throw new DbException(e.getMessage());
					
				}
			}
			
		}

	
	

   } 


