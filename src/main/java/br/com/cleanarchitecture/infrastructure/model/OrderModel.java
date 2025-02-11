package br.com.cleanarchitecture.infrastructure.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class OrderModel {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private CustomerModel customerModel;

    @OneToMany(mappedBy = "orderModel",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemModel> items;
    @Column(nullable = false)
    private Double total;

    public OrderModel(String id, CustomerModel customerModel, List<OrderItemModel> items, Double total) {
        this.id = id;
        this.customerModel = customerModel;
        this.items = items;
        this.total = total;
    }

    public OrderModel() {
    }

    public String getId() {
        return id;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public List<OrderItemModel> getItems() {
        return items;
    }

    public Double getTotal() {
        return total;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public void setItems(List<OrderItemModel> items) {
        this.items = items;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
