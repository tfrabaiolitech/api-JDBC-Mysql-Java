package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.SQLError;

import db.DB;
import db.DbException;
import db.DbIntegrityException;


public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2600 WHERE departmentId =1");
			
		    int x =2;
		    if(x <3) {
		    	throw new SQLException("Fake error");
		    }
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 2600 WHERE departmentId =2");
			
			conn.commit();
		}
		
		
		  catch(SQLException e) {
			  try {
				  conn.rollback();
				  throw new DbException("Roll back not done " + e.getMessage());
			  }catch(SQLException e1) {
				  throw new DbException("Error trying to rollback! " + e.getMessage());
			  }
		  }
		
		

		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
    }
	
}
