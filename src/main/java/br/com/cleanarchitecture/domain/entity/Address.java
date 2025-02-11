package br.com.cleanarchitecture.domain.entity;

public class Address {
    private String street;
    private Integer number;
    private String zip;
    private String city;

    public Address(String street, Integer number, String zip, String city) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
    }

    private void validate(){
        if (this.street == null || this.street.isBlank()){
            throw new RuntimeException("Street is required");
        }
        if (this.number == null){
            throw new RuntimeException("Number is required");
        }
        if (this.zip == null || this.zip.isBlank()){
            throw new RuntimeException("Zip is required");
        }
        if (this.city == null || this.city.isBlank()){
            throw new RuntimeException("City is required");
        }
    }

    @Override
    public String toString() {
        return "address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
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
}
