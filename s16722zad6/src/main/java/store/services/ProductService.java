package store.services;

import java.util.ArrayList;
import java.util.List;

import store.domain.Product;

public class ProductService {
	
	private static List<Product> db = new ArrayList<Product>();
	
	public List<Product> getAll() {
		return db;
	}
	
	public Product get (int id) {
		for(Product product : db) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}
	
	public void add (Product product) {
		db.add(product);
		product.setId(db.indexOf(product));
	}
	
	public void update (Product productUpdated) {
		for (Product productCurrent : db) {
			if(productCurrent.getId()== productUpdated.getId()) {
				productCurrent.setName(productUpdated.getName());
				productCurrent.setPrice(productUpdated.getPrice());
				productCurrent.setCategory(productUpdated.getCategory());
			}
		}
	}
	
	public void delete (Product product) {
		db.remove(product);
	}

}
