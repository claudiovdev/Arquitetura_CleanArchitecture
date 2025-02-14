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

    public OutputCreateCustomerDto execute(InputCreateCustomerDto inputCreateCustomerDto) {

        Customer customer = new Customer(UUID.randomUUID().toString(),inputCreateCustomerDto.getName());
        var adressDto = inputCreateCustomerDto.getAdress();
        Address address = new Address(adressDto.getStreet(),adressDto.getNumber(),adressDto.getZip(),adressDto.getCity());
        customer.setAddress(address);
        var result = customerRepository.save(customer);
        return  new OutputCreateCustomerDto(result.getId(),result.getName(), new CreateAddressDto(result.getAddress().getStreet(),
                result.getAddress().getCity(),result.getAddress().getNumber(),
                result.getAddress().getZip()));
    }
}
