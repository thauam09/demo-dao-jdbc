package model.dao;

import model.entities.Seller;

public interface SellerDao {
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	void findById(Integer id);
	Seller findAll();
}
