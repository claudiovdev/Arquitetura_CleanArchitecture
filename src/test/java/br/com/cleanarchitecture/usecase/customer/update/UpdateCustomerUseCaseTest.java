package br.com.cleanarchitecture.usecase.customer.update;

import br.com.cleanarchitecture.domain.entity.Address;
import br.com.cleanarchitecture.domain.entity.Customer;
import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UpdateCustomerUseCaseTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @BeforeEach
    void beforEach(){
        Customer customer = new Customer("2a1f2bd1-d88b-46d9-9daf-051894a1ebd2","Vinicius");
        Address address = new Address("Street",123,"zip","city");
        customer.setAddress(address);
        customer.addRewards(10.00);
        customerRepository.save(customer);
    }

    @Test
    void shoudUpdateCustomer(){
        UpdateAddressDto addressDto = new UpdateAddressDto("Street","zip",123,"city");
        InputUpdateCustomerDto inputUpdateCustomerDto = new InputUpdateCustomerDto( "2a1f2bd1-d88b-46d9-9daf-051894a1ebd2","Fran",addressDto );

        var retorno = updateCustomerUseCase.execute(inputUpdateCustomerDto);

        assertEquals("Fran", retorno.getName());


    }


}