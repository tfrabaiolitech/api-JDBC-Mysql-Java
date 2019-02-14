package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		
		SellerDao sellerDao =    DaoFactory.createSellerDao(); // Program just know interface
		
		System.out.println(" ==== Test 1: seller findById ====" );
		Seller seller = sellerDao.findById(2);
		
		System.out.println(seller);
		
		System.out.println("\n ==== Test 2: seller findByIdDepartment ====" );
		
		Department department = new Department(2, null);
		
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			
			System.out.println(obj);
			
		}
		
	
    }
	
}
