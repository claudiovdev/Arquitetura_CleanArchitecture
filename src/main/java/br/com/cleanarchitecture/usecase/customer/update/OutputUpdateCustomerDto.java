package br.com.cleanarchitecture.usecase.customer.update;

import br.com.cleanarchitecture.usecase.customer.create.CreateAddressDto;

public class OutputUpdateCustomerDto {
    private String id;
    private String name;
    private UpdateAddressDto address;

    public OutputUpdateCustomerDto(String id, String name, UpdateAddressDto address) {
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

    public UpdateAddressDto getAddress() {
        return address;
    }

}
