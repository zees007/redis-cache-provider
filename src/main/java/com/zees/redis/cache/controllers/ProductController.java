package com.zees.redis.cache.controllers;

import com.zees.redis.cache.models.Product;
import com.zees.redis.cache.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/products/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        try{
            return ResponseEntity.ok(productService.createProduct(product));
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/products/update")
    @CachePut(cacheNames = "product", key = "#product.id")
    public Product updateProduct(@RequestBody Product product){
        try{
            return productService.updateProduct(product);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/products/{id}")
    @Cacheable(value = "product", key = "#id")
    public Product getProductById(@PathVariable Long id){
        try{
            return productService.getProductById(id);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/products")
    @Cacheable(value = "product")
    public List<Product> getAllProducts(){
        try{
            return productService.getAllProducts();
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/products/{id}")
    @CacheEvict(cacheNames = "product", key = "#id", beforeInvocation = true)
    public void deleteProduct(@PathVariable Long id){
        try{
            productService.deleteProduct(id);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
