package br.com.cleanarchitecture.usecase.customer.update;

import br.com.cleanarchitecture.domain.entity.Address;
import br.com.cleanarchitecture.domain.entity.Customer;
import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerUseCase {

    @Autowired
    private CustomerRepository repository;
    public OutputUpdateCustomerDto execute(InputUpdateCustomerDto inputUpdateCustomerDto) {
        Customer customer = new Customer(inputUpdateCustomerDto.getId(),inputUpdateCustomerDto.getName());
        var adressDto = inputUpdateCustomerDto.getAdress();
        Address address = new Address(adressDto.getStreet(),adressDto.getNumber(),adressDto.getZip(),adressDto.getCity());
        customer.setAddress(address);
       var customerUpdate = repository.update(customer);
       var addressUpdate = customerUpdate.getAddress();
       var adress = new UpdateAddressDto(addressUpdate.getStreet(), addressUpdate.getCity(),addressUpdate.getNumber(),addressUpdate.getZip());
       return new OutputUpdateCustomerDto(customerUpdate.getId(),customerUpdate.getName(),adress);
    }
}
