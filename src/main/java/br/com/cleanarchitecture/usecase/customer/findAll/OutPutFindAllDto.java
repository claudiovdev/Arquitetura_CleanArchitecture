package br.com.cleanarchitecture.usecase.customer.findAll;

import br.com.cleanarchitecture.usecase.customer.update.UpdateAddressDto;

public class OutPutFindAllDto {
    private String id;
    private String name;
    private FindAllAdress address;

    public OutPutFindAllDto(String id, String name, FindAllAdress address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FindAllAdress getAddress() {
        return address;
    }

    public void setAddress(FindAllAdress address) {
        this.address = address;
    }
}
