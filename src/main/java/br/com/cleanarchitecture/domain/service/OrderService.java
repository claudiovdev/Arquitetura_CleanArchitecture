package br.com.cleanarchitecture.domain.service;



import br.com.cleanarchitecture.domain.entity.Customer;
import br.com.cleanarchitecture.domain.entity.Order;
import br.com.cleanarchitecture.domain.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    public Double getTotalDoPedido(List<Order> orders) {
        return orders.stream().map(Order::total).reduce(0.0, Double::sum);
    }

    public Order placeOrder(Customer custumer, ArrayList<OrderItem> orderItems) {
        if(orderItems.isEmpty()){
            throw new RuntimeException("Order must have at least one item");
        }

        Order order = new Order(UUID.randomUUID().toString(),custumer.getId(),orderItems);

        custumer.addRewards(order.total() / 2);

        return order;
    }
}
