package br.com.cleanarchitecture.infrastructure.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItemModel {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderModel orderModel;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    public OrderItemModel(String id, ProductModel productModel, OrderModel orderModel, String nome, Double price, Integer quantity) {
        this.id = id;
        this.productModel = productModel;
        this.orderModel = orderModel;
        this.nome = nome;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public OrderModel getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
