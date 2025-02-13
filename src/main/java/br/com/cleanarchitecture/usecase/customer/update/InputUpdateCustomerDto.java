package br.com.cleanarchitecture.usecase.customer.update;

import br.com.cleanarchitecture.usecase.customer.create.CreateAddressDto;

public class InputUpdateCustomerDto {
    private String id;
    private String name;
    private UpdateAddressDto adress;

    public InputUpdateCustomerDto(String id,String name, UpdateAddressDto adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public UpdateAddressDto getAdress() {
        return adress;
    }

    public String getId(){
        return id;
    }


}
