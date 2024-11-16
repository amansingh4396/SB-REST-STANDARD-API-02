package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByOrderByProductPriceAsc();

	List<Product> findAllByOrderByProductPriceDesc();

	List<Product> findAllByProductCategory(String productCategory);

	List<Product> findAllByProductCategoryAndProductName(String productCategory, String productName);

	List<Product> findAllByProductPriceBetween(Double minPrice, Double maxPrice);

}
