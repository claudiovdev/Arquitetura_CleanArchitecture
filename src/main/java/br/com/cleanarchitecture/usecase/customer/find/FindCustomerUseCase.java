package br.com.cleanarchitecture.usecase.customer.find;

import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindCustomerUseCase {
    @Autowired
    private CustomerRepository customerRepository;


    public OutputFindCustomerDto execute(InputFindCustomerDto inputFindCustomerDto) {
        var custumer = customerRepository.findById(inputFindCustomerDto.getId());
        return new OutputFindCustomerDto(custumer.getId(),custumer.getName(),
                new AddressDto(custumer.getAddress().getStreet(),
                        custumer.getAddress().getCity(),
                        custumer.getAddress().getNumber(),
                        custumer.getAddress().getZip()));
    }
}
