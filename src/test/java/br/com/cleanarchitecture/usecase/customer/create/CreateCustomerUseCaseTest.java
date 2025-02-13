package br.com.cleanarchitecture.usecase.customer.create;

import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CreateCustomerUseCaseTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CreateCustomerUseCase createCustomerUseCase;

    @Test
    void shouldCreateACustomer(){
        CreateAddressDto addressDto = new CreateAddressDto("Street","zip",123,"city");
        InputCreateCustomerDto outputFindCustomerDto = new InputCreateCustomerDto( "Vinicius",addressDto );


        createCustomerUseCase.execute(outputFindCustomerDto);

        var resultado = customerRepository.findAll();

        assertEquals("Vinicius", resultado.get(0).getName());

    }

    @Test
    void shouldThrownAnErrorWhenNameIsMissing(){
        CreateAddressDto addressDto = new CreateAddressDto("Street","zip",123,"city");
        InputCreateCustomerDto outputFindCustomerDto = new InputCreateCustomerDto( "",addressDto );


        RuntimeException exception = assertThrows(RuntimeException.class, ()-> createCustomerUseCase.execute(outputFindCustomerDto));

        assertEquals("Name is required", exception.getMessage());

    }

}