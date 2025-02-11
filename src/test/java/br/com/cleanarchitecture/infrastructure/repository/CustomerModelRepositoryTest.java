package br.com.cleanarchitecture.infrastructure.repository;


import br.com.cleanarchitecture.domain.entity.Address;
import br.com.cleanarchitecture.domain.entity.Customer;
import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import br.com.cleanarchitecture.infrastructure.repository.impl.CustomerRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Import(CustomerRepositoryImpl.class)
class CustomerModelRepositoryTest {

    @Autowired
    CustomerRepository repository;

    @Autowired
    CustomerModelRepository modelRepository;

    @Test
    void shouldCreateCustomer(){
        Customer customer = new Customer("6", "Gabriela Melo");
        Address address = new Address("Avenida Paulista", 123, "01310-000", "São Paulo");
        customer.setAddress(address);
        customer.activate();
        customer.addRewards(100.00);

        repository.save(customer);

        var customerFound = modelRepository.findById("6");


        assertNotNull(customerFound);
    }

    @Test
    void shouldFindAllCustomer(){
        Customer customer1 = new Customer("1", "João Silva");
        Address address1 = new Address("Rua das Flores", 456, "01020-300", "Rio de Janeiro");
        customer1.setAddress(address1);
        customer1.activate();
        customer1.addRewards(50.00);
        repository.save(customer1);

        Customer customer2 = new Customer("4", "Ana Souza");
        Address address2 = new Address("Avenida Paulista", 500, "01310-900", "São Paulo");
        customer2.setAddress(address2);
        customer2.activate();
        customer2.addRewards(150.75);

        repository.save(customer2);

        Customer customer3 = new Customer("3", "Carlos Santos");
        Address address3 = new Address("Rua XV de Novembro", 101, "80240-010", "Curitiba");
        customer3.setAddress(address3);
        customer3.activate();
        customer3.addRewards(0.00); // Sem recompensas ainda

        repository.save(customer3);

        var costumers = repository.findAll();

        assertEquals(3, costumers.size());


    }

}