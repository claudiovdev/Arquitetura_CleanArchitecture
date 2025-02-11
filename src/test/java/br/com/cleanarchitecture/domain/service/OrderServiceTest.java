package br.com.cleanarchitecture.domain.service;


import br.com.cleanarchitecture.domain.entity.Customer;
import br.com.cleanarchitecture.domain.entity.Order;
import br.com.cleanarchitecture.domain.entity.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setup(){
        orderService = new OrderService();
    }


    @Test
    void deveRetornarOTotalDeOrders(){
        var orderItem1 = new OrderItem("i1", "123","Item 1", 100.00, 1 );
        var orderItem2 = new OrderItem("i2", "123","Item 1", 200.00, 2 );

        var order = new Order("1", "1", Arrays.asList(orderItem1));
        var order2 = new Order("2", "1", Arrays.asList(orderItem2));

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order2);

        Double total = orderService.getTotalDoPedido(orders);

        assertEquals(500.00, total);
    }

    @Test
    void deveCriarUmaOrdem(){

        var custumer = new Customer("c1", "Claudio");
        var orderItems = new ArrayList<OrderItem>();

        var orderItem = new OrderItem("i1", "p1", "Item 1", 1000.00, 10);
        orderItems.add(orderItem);

        var order = orderService.placeOrder(custumer, orderItems);

        assertEquals(5000.00, custumer.getRewards());
        assertEquals(10000.00, order.total());
    }


}