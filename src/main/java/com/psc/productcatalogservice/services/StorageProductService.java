package com.psc.productcatalogservice.services;

import com.psc.productcatalogservice.models.Product;
import com.psc.productcatalogservice.models.State;
import com.psc.productcatalogservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("sps")
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
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
        if (productOptional.isPresent()) {
            throw new RuntimeException("Product with id "+product.getId()+" already exist");
        }

        return productRepo.save(product);
    }

    //ToDo : For students
    @Override
    public Product replaceProduct(Product product, Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product with id "+id+" not available");
        }

        Product product = productOptional.get();
        if (product.getState().equals(State.ACTIVE)) {
            //Soft Delete
            System.out.println("Soft Deleting product with id"+id);
            product.setState(State.INACTIVE);
            product.setLastUpdatedAt(new Date());
            productRepo.save(product);
        } else {
            //Hard delete
            System.out.println("Hard Deleting product with id"+id);
            productRepo.deleteById(id);
        }
    }
}