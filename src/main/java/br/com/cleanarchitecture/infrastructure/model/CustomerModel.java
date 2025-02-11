package br.com.cleanarchitecture.infrastructure.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerModel {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private Integer number;
    @Column(nullable = false)
    private String zip;

    private String city;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = false)
    private Double rewards;

    public CustomerModel(String id, String name, String street, Integer number, String zip,String city,boolean active, Double rewards) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.active = active;
        this.rewards = rewards;
        this.city = city;
    }

    public CustomerModel() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public boolean isActive() {
        return active;
    }

    public Double getRewards() {
        return rewards;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRewards(Double rewards) {
        this.rewards = rewards;
    }
}
