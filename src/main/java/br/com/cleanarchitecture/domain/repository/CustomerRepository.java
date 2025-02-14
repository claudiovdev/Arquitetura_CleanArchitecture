package br.com.cleanarchitecture.domain.repository;

import br.com.cleanarchitecture.domain.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {
    Customer save(Customer customer);
    Customer findById(String id);

    List<Customer> findAll();

    Customer update(Customer customer);


}
