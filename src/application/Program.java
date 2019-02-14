package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department dep = new Department(1, "Books");
		
		Seller seller  = new Seller (21, "Bob", "bob@gmail.com", new Date(), 3000.00, dep);
		
		System.out.println(dep.toString());
		
		
		
		SellerDao sellerDao =    DaoFactory.createSellerDao(); // Program just know interface
		
	
    }
	
}
