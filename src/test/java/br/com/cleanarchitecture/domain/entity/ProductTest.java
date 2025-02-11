package br.com.cleanarchitecture.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {

    @Test
    void deveLancarErroQuandoIdEstiverVazio(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()-> {
           Product product = new Product("","",100.00);
        });

        assertEquals("Id is required", exception.getMessage());
    }

    @Test
    void deveLancarErroQuandoNomeEstiverVazio(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()-> {
            Product product = new Product("p1","",100.00);
        });

        assertEquals("Nome is required", exception.getMessage());
    }
    @Test
    void deveLancarErroQuandoPriceMenorQueZero(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()-> {
            Product product = new Product("p1","product 1",-1.0);
        });

        assertEquals("Price must be greater than zero", exception.getMessage());
    }

    @Test
    void deveAlterarNome(){
        Product product = new Product("p1","product 1",100.0);
        product.changeName("Product 2");
        assertEquals("Product 2", product.getName());
    }

    @Test
    void deveAlteraPrice(){
        Product product = new Product("p1","product 1",100.0);
        product.changePrice(99.00);
        assertEquals(99.00, product.getPrice());
    }

}