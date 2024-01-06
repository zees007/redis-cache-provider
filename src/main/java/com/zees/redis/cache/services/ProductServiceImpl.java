package com.zees.redis.cache.services;

import com.zees.redis.cache.models.Product;
import com.zees.redis.cache.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if(!Objects.isNull(product) && product.getId() != null){
            Product oldProduct = productRepository.findFirstById(product.getId());
            oldProduct.setId(product.getId());
            oldProduct.setName(product.getName());
            oldProduct.setCategory(product.getCategory());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setQuantity(product.getQuantity());
            productRepository.save(oldProduct);
        }
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findFirstById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products;
    }

    @Override
    public void deleteProduct(Long productId) {
         productRepository.deleteById(productId);
    }
}
