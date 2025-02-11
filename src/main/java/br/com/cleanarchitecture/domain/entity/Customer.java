package br.com.cleanarchitecture.domain.entity;

public class Customer {
    private String id;

    private String name;
    private Address address;

    private boolean active;

    private Double rewards;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        validate();
    }

    private void validate(){
        if(this.id == null || this.id.isBlank()){
            throw new RuntimeException("Id is required");
        }
        if (this.name == null || this.name.isBlank()){
            throw new RuntimeException("Name is required");
        }
    }

    public void changeName(String name){
        this.name  = name;
        validate();
    }

    public void activate(){
        if (this.address == null){
            throw new RuntimeException("Address is mandatory to activate a customer");
        }
        this.active = true;
    }

    public void deactivate(){
        this.active = false;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public boolean isActive() {
        return this.active;
    }

    public double getRewards() {
        return this.rewards;
    }

    public void addRewards(Double rewards){
        if (this.rewards == null){
            this.rewards = 0.0;
        }
        this.rewards = this.rewards + rewards;
    }

    public Address getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public boolean getActive(){
        return active;
    }


}
