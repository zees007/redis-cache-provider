package com.zees.redis.cache.controllers;

import com.zees.redis.cache.models.Product;
import com.zees.redis.cache.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        try{
            return ResponseEntity.ok(productService.updateProduct(product));
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id){
        try{
            return ResponseEntity.ok(productService.getProductById(id));
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        try{
            return ResponseEntity.ok(productService.getAllProducts());
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
