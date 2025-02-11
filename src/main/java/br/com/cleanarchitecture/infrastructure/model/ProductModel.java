package br.com.cleanarchitecture.infrastructure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double price;

    public ProductModel(String id, String nome, Double price) {
        this.id = id;
        this.nome = nome;
        this.price = price;
    }

    public ProductModel() {
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPrice() {
        return price;
    }
}
