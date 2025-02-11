package br.com.cleanarchitecture.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private List<OrderItem> items = new ArrayList<>();
    private Double total;

    public Order(String id, String customerId, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        this.total = total();
        this.validate();
    }


    private void validate() {
        if (this.id == null || this.id.isBlank()) {
            throw new RuntimeException("Id is required");
        }
        if (this.customerId == null || this.customerId.isBlank()) {
            throw new RuntimeException("CustomerId is required");
        }

        if (this.items == null || this.items.size() <= 0) {
            throw new RuntimeException("Items are required");
        }

        this.items.forEach(item ->{
            if (item.getQuantity() <= 0){
                throw new RuntimeException("Quantity must be greater than 0");
            }
        });
    }
    public Double total() {
        return this.items.stream().map(OrderItem::getPrice).reduce(0.0, Double::sum);
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Double getTotal() {
        return total;
    }
}
