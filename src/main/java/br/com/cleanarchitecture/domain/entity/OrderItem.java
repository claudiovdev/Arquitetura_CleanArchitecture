package br.com.cleanarchitecture.domain.entity;

public class OrderItem {
    private String id;
    private String productId;
    private String nome;
    private Double price;
    private Integer quantity;

    public OrderItem(String id, String productId, String nome, Double price, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.nome = nome;
        this.price = price;
        this.quantity = quantity;
    }

    public Double getPrice() {
        return this.price * this.quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getNome() {
        return nome;
    }
}
