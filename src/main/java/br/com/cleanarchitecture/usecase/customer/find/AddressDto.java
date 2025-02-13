package br.com.cleanarchitecture.usecase.customer.find;

public class AddressDto {
    private String street;
    private String city;
    private int number;

    private String zip;

    public AddressDto(String street, String city, int number, String zip) {
        this.street = street;
        this.city = city;
        this.number = number;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getNumber() {
        return number;
    }

    public String getZip() {
        return zip;
    }




}
