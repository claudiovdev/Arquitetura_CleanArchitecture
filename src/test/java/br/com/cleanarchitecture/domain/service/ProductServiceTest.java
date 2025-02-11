package br.com.cleanarchitecture.domain.service;

import br.com.cleanarchitecture.domain.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setup(){
        productService = new ProductService();
    }

    @Test
    void deveAlterarOPrecoDeTodosOsProdutos(){
        var product1 = new Product("1", "Product1", 10.00);
        var product2 = new Product("12", "Product2", 20.00);
        var produtos = Arrays.asList(product1, product2);

        productService.increasePrice(produtos,100);

        assertAll(
                ()-> assertEquals(20, product1.getPrice()),
                ()-> assertEquals(40, product2.getPrice())
        );
    }

}