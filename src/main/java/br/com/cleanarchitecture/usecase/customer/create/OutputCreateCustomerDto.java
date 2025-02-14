package br.com.cleanarchitecture.usecase.customer.create;

public class OutputCreateCustomerDto {

    private String id;
    private String name;

    private CreateAddressDto adress;

    public OutputCreateCustomerDto(String id, String name, CreateAddressDto adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CreateAddressDto getAdress() {
        return adress;
    }
}
