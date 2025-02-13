package br.com.cleanarchitecture.usecase.customer.find;

public class OutputFindCustomerDto {
    private String id;
    private String name;
    private AddressDto address;

    public OutputFindCustomerDto(String id, String name, AddressDto address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AddressDto getAddress() {
        return address;
    }

}
