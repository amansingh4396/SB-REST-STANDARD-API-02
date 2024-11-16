package com.example.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.app.model.Product;
import com.example.app.repository.ProductRepository;
import com.example.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(int id) {

		if (productRepository.existsById(id)) {
			return productRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public boolean deleteProduct(int id) {

		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Product updateProduct(int id, Product product) {

		if (productRepository.existsById(id)) {
			product.setProductId(id);
			return productRepository.save(product);
		}
		return null;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product editProduct(int id, Product product) {

		if (productRepository.existsById(id)) {

			Product existingProduct = productRepository.findById(id).get();

			if (product.getProductName() != null) {
				existingProduct.setProductName(product.getProductName());
			}

			if (product.getCompanyName() != null) {
				existingProduct.setCompanyName(product.getCompanyName());
			}

			if (product.getProductCategory() != null) {
				existingProduct.setProductCategory(product.getProductCategory());
			}

			if (product.getProductColor() != null) {
				existingProduct.setProductColor(product.getProductColor());
			}

			if (product.getProductPrice() != null) {
				existingProduct.setProductPrice(product.getProductPrice());
			}

			Product editproduct = productRepository.save(existingProduct);

			return editproduct;
		}

		return null;
	}

	@Override
	public List<Product> sortProductByPrice() {

		return productRepository.findAllByOrderByProductPriceAsc();
	}

	@Override
	public List<Product> sortProductByPriceDesc() {

		return productRepository.findAllByOrderByProductPriceDesc();
	}

	@Override
	public List<Product> searchProductBycategory(String productCategory) {

		return productRepository.findAllByProductCategory(productCategory);
	}

	@Override
	public List<Product> searchProductBycategory(String productCategory, String productName) {
		return productRepository.findAllByProductCategoryAndProductName(productCategory, productName);
	}

	@Override
	public List<Product> getProducts(Integer page, Integer size) {

		PageRequest pr = PageRequest.of(page, size);

		Page<Product> p = productRepository.findAll(pr);

		List<Product> products = p.getContent();

		System.out.println(products);

		return products;
	}

	@Override
	public List<Product> getProducts(Double minPrice, Double maxPrice) {
		return productRepository.findAllByProductPriceBetween(minPrice, maxPrice);
	}
}
