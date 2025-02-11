package br.com.cleanarchitecture.domain.repository;

import br.com.cleanarchitecture.domain.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {
    void save(Customer customer);
    Customer findById(String id);

    List<Customer> findAll();
}
