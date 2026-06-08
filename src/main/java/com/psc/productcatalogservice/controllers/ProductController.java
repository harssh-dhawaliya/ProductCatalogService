package com.psc.productcatalogservice.controllers;

import com.psc.productcatalogservice.dtos.ProductDto;
import com.psc.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    //APIS

    //bean == singleton object
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
     return null;
    }

    @GetMapping("/products/{ID}")
    public ProductDto getProductById(@PathVariable("ID") Long productId) {
       return null;
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto input) {
        return input;
    }



    //@GetMapping("/products/{catId}/{prodId}")
    //public Product getProduct(@PathVariable("catId") Long categoryId,
    //                           @PathVariable("prodId") Long productId) {
    //    Product product = new Product();
    //    Category category = new Category();
    //    category.setId(categoryId);
    //    product.setCategory(category);
    //      product.setId(productId);
    //    return product;
    //}
}
