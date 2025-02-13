package br.com.cleanarchitecture.usecase.customer.find;

public class InputFindCustomerDto {
    private String id;

    public InputFindCustomerDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
