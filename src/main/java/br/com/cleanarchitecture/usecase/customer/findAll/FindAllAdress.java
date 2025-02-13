package br.com.cleanarchitecture.usecase.customer.findAll;

public class FindAllAdress {
    private String street;
    private String city;
    private int number;

    private String zip;


    public FindAllAdress(String street, String city, int number, String zip) {
        this.street = street;
        this.city = city;
        this.number = number;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
