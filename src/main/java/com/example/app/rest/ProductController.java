package com.example.app.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Product;
import com.example.app.service.ProductService;

@RestController
@RequestMapping(value = "/api/v2")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping(value = "/products", produces = { "application/json" })
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping(value = "/products/{id}", produces = { "application/json" })
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		Product product = productService.getProduct(id);

		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
		boolean flag = productService.deleteProduct(id);

		if (flag) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/products/{id}", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {

		Product updateProduct = productService.updateProduct(id, product);

		if (updateProduct != null) {
			return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/products", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product product2 = productService.addProduct(product);

		return new ResponseEntity<Product>(product2, HttpStatus.CREATED);
	}

	@PatchMapping(value = "/products/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable int id, @RequestBody Product product) {

		Product editProduct = productService.editProduct(id, product);

		if (editProduct != null) {
			return new ResponseEntity<Product>(editProduct, HttpStatus.OK);
		}

		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}

	// Sorting

	@GetMapping(value = "/products/sort-by-price")
	public ResponseEntity<List<Product>> sortProduct() {
		List<Product> products = productService.sortProductByPrice();

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping(value = "/products/sort-by-price-desc")
	public ResponseEntity<List<Product>> sortProductDesc() {

		List<Product> products = productService.sortProductByPriceDesc();

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// searching
	@GetMapping(value = "/products/search-category")
	public ResponseEntity<List<Product>> searchProductByCategory(@RequestParam String productCategory) {
		List<Product> products = productService.searchProductBycategory(productCategory);

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// searching
	@GetMapping(value = "/products/search")
	public ResponseEntity<List<Product>> searchProductByCategory(@RequestParam String productCategory,
			@RequestParam String productName) {
		List<Product> products = productService.searchProductBycategory(productCategory, productName);

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// Pagination

	@GetMapping(value = "/products/page")
	public ResponseEntity<List<Product>> getProducts(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) {
		List<Product> products = productService.getProducts(page, size);

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// filteration

	@GetMapping(value = "/products/filter")
	public ResponseEntity<List<Product>> getProducts(@RequestParam(defaultValue = "0") Double minPrice,
			@RequestParam(defaultValue = "1000000") Double maxPrice) {
		List<Product> products = productService.getProducts(minPrice, maxPrice);

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}
