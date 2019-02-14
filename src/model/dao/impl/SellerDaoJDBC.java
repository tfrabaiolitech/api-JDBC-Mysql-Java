package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn; //Dependency to Connection
	
	public  SellerDaoJDBC(Connection conn) { //Constructor force Connection with DB
	this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null; //Position 0 in table
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "  
					+"FROM seller INNER JOIN department "  
					+"ON seller.DepartmentId = department.Id "  
					+"WHERE DepartmentId = ? "); 
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) { //Test if have any result...
				//Instance of Department
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep); // Object 
				
				return obj;
				
			}
			return null; // Dont exists seller with this id parameter 
					
		}
		catch(SQLException e) { throw new DbException(e.getMessage()); }
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
