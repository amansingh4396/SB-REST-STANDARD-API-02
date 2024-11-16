package com.example.app.service;

import java.util.List;

import com.example.app.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProduct(int id);

	boolean deleteProduct(int id);

	Product updateProduct(int id, Product product);

	Product addProduct(Product product);

	Product editProduct(int id, Product product);

	List<Product> sortProductByPrice();

	List<Product> sortProductByPriceDesc();

	List<Product> searchProductBycategory(String productCategory);

	List<Product> searchProductBycategory(String productCategory, String productName);

	List<Product> getProducts(Integer page, Integer size);

	List<Product> getProducts(Double minPrice, Double maxPrice);

}
