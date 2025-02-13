package br.com.cleanarchitecture.usecase.customer.findAll;

import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllCustomerUseCase {

    @Autowired
    private CustomerRepository customerRepository;

    public OutPutFindAllListDto execute() {
        var outputFindAllDto = new ArrayList<OutPutFindAllDto>();


        var customers = customerRepository.findAll();
        customers.stream().forEach(c -> {
            var adress = new FindAllAdress(c.getAddress().getStreet(),c.getAddress().getCity(),
                    c.getAddress().getNumber(),c.getAddress().getZip());
            var customer = new OutPutFindAllDto(c.getId(),c.getName(),adress);
            outputFindAllDto.add(customer);
        });


        return new OutPutFindAllListDto(outputFindAllDto);


    }
}
