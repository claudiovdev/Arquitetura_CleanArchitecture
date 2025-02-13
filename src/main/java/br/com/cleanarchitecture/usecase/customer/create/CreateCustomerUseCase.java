package br.com.cleanarchitecture.usecase.customer.create;

import br.com.cleanarchitecture.domain.entity.Address;
import br.com.cleanarchitecture.domain.entity.Customer;
import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCustomerUseCase {

    @Autowired
    private CustomerRepository customerRepository;

    public void execute(InputCreateCustomerDto inputCreateCustomerDto) {

        Customer customer = new Customer(UUID.randomUUID().toString(),inputCreateCustomerDto.getName());
        var adressDto = inputCreateCustomerDto.getAdress();
        Address address = new Address(adressDto.getStreet(),adressDto.getNumber(),adressDto.getZip(),adressDto.getCity());
        customer.setAddress(address);
        customerRepository.save(customer);
    }
}
