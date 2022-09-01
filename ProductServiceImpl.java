package com.itc.main.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itc.main.entity.Product;

import com.itc.main.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> op=this.productRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else
			return null;
	}
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}
	@Override
	public Product getProductByName(String pname) {
		// TODO Auto-generated method stub
		Product product=this.productRepository.getProductByPname(pname);
		if(product!=null) {
			return product;
		}
		else
			return null;
		
	}
	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Product existingProduct=productRepository.findById(product.getId()).orElse(null);
		existingProduct.setPname(product.getPname());
		existingProduct.setPrice(product.getPrice());
		return productRepository.save(existingProduct);

		
	}
	@Override
	public boolean deleteProductById(int id) {
		// TODO Auto-generated method stub
		this.productRepository.deleteById(id);
		return true;
	}
	@Override
	public boolean deleteProductByName(String pname) {
		// TODO Auto-generated method stub
		this.productRepository.deleteProductByName(pname);
		return true;
	}

}
