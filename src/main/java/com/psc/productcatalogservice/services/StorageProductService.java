package com.psc.productcatalogservice.services;

import com.psc.productcatalogservice.models.Product;
import com.psc.productcatalogservice.repos.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService {

    private final ProductRepo productRepo;

    public StorageProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Product> productOptional = productRepo.findById(product.getId());
        if(productOptional.isPresent()) {
            throw new RuntimeException("Product with id: " + product.getId() + " already exists");
        }
        return productRepo.save(product);
    }

    @Override
    public Product replaceProduct(Product product, Long id) {
        return null;
    }
}