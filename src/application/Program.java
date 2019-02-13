package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;


public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("mm/MM/yyyy");
		
		Connection conn = null;
		
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"insert into seller "
					+"(Name,Email, BirthDate,BaseSalary,DepartmentId) "
					+"values "
					+"(?, ?, ?, ?, ?)");
					
			st.setString(1, "Thiago Rabaioli");
			st.setString(2, "tfrabaioli@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/09/1985").getTime()));
			st.setDouble(4, 1500.00);
			st.setInt(5, 4);
			
			int rowsAffected  = st.executeUpdate();
			
			System.out.println("Done " + rowsAffected);
					
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
	

    }
	
}
