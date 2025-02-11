package br.com.cleanarchitecture.domain.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {

    @Test
    void deveLancarErroQuandoIdEstiverVazio(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()-> {
            Order order = new Order("","123", new ArrayList<>());
        });

        assertEquals("Id is required", exception.getMessage());
    }
    @Test
    void deveLancarErroQuandoCustumerIdEstiverVazio(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()-> {
            Order order = new Order("1","", new ArrayList<>());
        });

        assertEquals("CustomerId is required", exception.getMessage());
    }

    @Test
    void deveLancarErroQuandoItensEstiverVazio(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
           Order order = new Order("1", "123", new ArrayList<>());
        });
        assertEquals("Items are required", exception.getMessage());
    }

    @Test
    void deveCalcularTotal(){
        OrderItem item1 = new OrderItem("1","123", "Item 1", 100.00,2);
        OrderItem item2 = new OrderItem("1","123", "Item 1", 200.00,2);
        Order order = new Order("01","123", Arrays.asList(item1,item2));

        var total = order.total();

        assertEquals(600.00, total);
    }

    @Test
    void deveLancarErroQuandoCustmerIdEstiverVario(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->{
            Order order = new Order("123", "", new ArrayList<>());
        });

        assertEquals("CustomerId is required", exception.getMessage());
    }

    @Test
    void deveLancarErroQuandoItemsForIgualOuMenorQueZero(){
        RuntimeException exception = assertThrows(RuntimeException.class, ()->{
            Order order = new Order("123", "123", new ArrayList<>());
        });

        assertEquals("Items are required", exception.getMessage());
    }

    @Test
    void deveLancarErroQuantoQuantidadeDeItemForMenorOuIgualZero(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            OrderItem item1 = new OrderItem("1","123", "Item 1", 100.00,2);
            OrderItem item2 = new OrderItem("1","123", "Item 1", 200.00,0);
            Order order = new Order("01","123", Arrays.asList(item1,item2));
        });
        assertEquals("Quantity must be greater than 0", exception.getMessage());
    }



}