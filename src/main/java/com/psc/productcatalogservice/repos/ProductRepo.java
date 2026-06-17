package com.psc.productcatalogservice.repos;

import com.psc.productcatalogservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {
    Product save(Product product);

    @Override
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    @Override
    void deleteById(Long aLong);
}