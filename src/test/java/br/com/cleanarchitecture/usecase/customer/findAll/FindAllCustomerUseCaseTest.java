package br.com.cleanarchitecture.usecase.customer.findAll;

import br.com.cleanarchitecture.domain.entity.Address;
import br.com.cleanarchitecture.domain.entity.Customer;
import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FindAllCustomerUseCaseTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FindAllCustomerUseCase useCase;

    @BeforeEach
    void beforEach(){
        Customer customer = new Customer("123","Vinicius");
        Address address = new Address("Street",123,"zip","city");
        customer.setAddress(address);
        customer.addRewards(10.00);
        customerRepository.save(customer);

        Customer customer2 = new Customer("1234","Fran");
        Address address2 = new Address("Street",123,"zip","city");
        customer2.setAddress(address2);
        customer2.addRewards(10.00);
        customerRepository.save(customer2);
    }

    @Test
    void shoulListCustomer(){

        var resultado = useCase.execute();

        assertEquals(2, resultado.getOutPutFindAllDtoList().size());
    }

}