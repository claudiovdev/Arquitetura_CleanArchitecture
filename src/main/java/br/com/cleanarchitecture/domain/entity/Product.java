package br.com.cleanarchitecture.domain.entity;

public class Product {
    private String id;
    private String name;
    private Double price;

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validate();
    }

    private void validate(){
        if (this.id == null || this.id.isBlank()){
            throw new RuntimeException("Id is required");
        }
        if (this.name == null || this.name.isBlank()){
            throw new RuntimeException("Nome is required");
        }
        if (this.price == null || this.price < 0){
            throw new RuntimeException("Price must be greater than zero");
        }
    }

    public String getName() {
        return name;
    }

    public void changeName(String novoNome) {
        this.name = novoNome;
        this.validate();
    }


    public double getPrice() {
        return price;
    }

    public void changePrice(double newPrice) {
        this.price = newPrice;
        validate();
    }

    public String getId() {
        return id;
    }
}
