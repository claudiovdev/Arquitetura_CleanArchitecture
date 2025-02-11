package br.com.cleanarchitecture.domain.repository;

import br.com.cleanarchitecture.domain.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository{
    void save(Product product);
    Product findById(String id);

    List<Product> findAll();

}
