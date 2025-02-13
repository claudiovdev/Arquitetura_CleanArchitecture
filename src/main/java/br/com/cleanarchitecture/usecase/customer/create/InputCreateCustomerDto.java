package br.com.cleanarchitecture.usecase.customer.create;

public class InputCreateCustomerDto {
    private String name;
    private CreateAddressDto adress;

    public InputCreateCustomerDto(String name, CreateAddressDto adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public CreateAddressDto getAdress() {
        return adress;
    }
}
