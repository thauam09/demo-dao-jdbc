package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
//		testSeller();
		testDepartment();
	}
	
	public static void testSeller() {
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("\n=== TEST 5: Seller Update ===");
		Seller sellerToUpdate = sellerDao.findById(2);
		sellerToUpdate.setBaseSalary(5756.0);
		sellerDao.update(sellerToUpdate);
		System.out.println("Updated! Seller " + sellerToUpdate.getId());
		
		System.out.println("\n=== TEST 6: Seller DeleteById ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sc.close();
		sellerDao.deleteById(id);
		System.out.println("Deleted! Seller " + id);
	}
	
	public static void testDepartment() {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department FindById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: Department FindAll ===");
		List<Department> departments = departmentDao.findAll();
		for(Department obj: departments) {
			System.out.println(obj);			
		}
		
		System.out.println("\n=== TEST 3: Department Insert ===");
		Department newDepartment = new Department();
		newDepartment.setName("Cama, Mesa e Banho");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department Update ===");
		Department departmentToUpdate = departmentDao.findById(2);
		departmentToUpdate.setName("Vestuário");
		departmentDao.update(departmentToUpdate);
		System.out.println("Updated! Department " + departmentToUpdate.getId());
		
		System.out.println("\n=== TEST 6: Department DeleteById ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sc.close();
		departmentDao.deleteById(id);
		System.out.println("Deleted! Department " + id);
	}

}
