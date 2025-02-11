package br.com.cleanarchitecture.domain.service;


import br.com.cleanarchitecture.domain.entity.Product;

import java.util.List;

public class ProductService {
    public void increasePrice(List<Product> produtos, int percentage) {
        produtos.forEach( product -> {
            product.changePrice((product.getPrice() * percentage)/ 100 + product.getPrice());
        });
    }
}
