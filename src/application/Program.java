package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: Seller FindById ===");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: Seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		for(Seller obj: sellers) {
			System.out.println(obj);			
		}
		
		System.out.println("\n=== TEST 3: Seller FindAll ===");
		sellers = sellerDao.findAll();
		for(Seller obj: sellers) {
			System.out.println(obj);			
		}
		
		System.out.println("\n=== TEST 4: Seller Insert ===");
		Seller newSeller = new Seller();
		newSeller.setName("Joãozinho");
		newSeller.setEmail("joazinho@gmail.com");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = new Date();
		try {
			birthDate = dateFormat.parse("25/12/2000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		newSeller.setBirthDate(birthDate);
		newSeller.setBaseSalary(4500.0);
		newSeller.setDepartment(department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}

}
