package br.com.cleanarchitecture.usecase.customer.find;

import br.com.cleanarchitecture.domain.entity.Address;
import br.com.cleanarchitecture.domain.entity.Customer;
import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import br.com.cleanarchitecture.infrastructure.repository.impl.CustomerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Import(FindCustomerUseCase.class)
class FindCustomerUseCaseTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FindCustomerUseCase findCustomerUseCase;

    @BeforeEach
    void before(){
        Customer customer = new Customer("123","Vinicius");
        Address address = new Address("Street",123,"zip","city");
        customer.setAddress(address);
        customer.addRewards(10.00);
        customerRepository.save(customer);
    }

    @Test
    void shoudFindACustomer(){
        InputFindCustomerDto inputFindCustomerDto = new InputFindCustomerDto("123");

        OutputFindCustomerDto retorno = findCustomerUseCase.execute(inputFindCustomerDto);


        assertEquals("123", retorno.getId());

    }

    @Test
    void shouldNotFindACustomer(){
        InputFindCustomerDto inputFindCustomerDto = new InputFindCustomerDto("1234");
        RuntimeException exception = assertThrows(RuntimeException.class, ()-> findCustomerUseCase.execute(inputFindCustomerDto));

        assertEquals("Customer not found", exception.getMessage());
    }

}