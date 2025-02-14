package br.com.cleanarchitecture.infrastructure.repository.impl;


import br.com.cleanarchitecture.domain.entity.Address;
import br.com.cleanarchitecture.domain.entity.Customer;
import br.com.cleanarchitecture.domain.repository.CustomerRepository;
import br.com.cleanarchitecture.infrastructure.model.CustomerModel;
import br.com.cleanarchitecture.infrastructure.repository.CustomerModelRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerModelRepository repository;

    public CustomerRepositoryImpl(CustomerModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        customer.addRewards(0.0);
        var result =  repository.save(new CustomerModel(customer.getId(), customer.getName(),
                customer.getAddress().getStreet(),customer.getAddress().getNumber(),
                customer.getAddress().getZip(),customer.getAddress().getCity(),customer.getActive(), customer.getRewards()));
        var cust =  new Customer(result.getId(),result.getName());
        cust.setAddress(new Address(result.getStreet(),result.getNumber(),result.getZip(),result.getCity()));
        return cust;


    }

    @Override
    public Customer findById(String id) {
        var customerModel = repository.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
        Customer customer = new Customer(customerModel.getId(),customerModel.getName());
        Address address = new Address(customerModel.getStreet(),customerModel.getNumber(),
                customerModel.getZip(),customerModel.getCity());

        if (customerModel.isActive()) {
            customer.activate();
        } else {
            customer.deactivate();
        }
        customer.addRewards(customerModel.getRewards());

        customer.setAddress(address);

        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll().stream().map(customerModel -> {
            Customer customer = new Customer(customerModel.getId(), customerModel.getName());
            Address address = new Address(customerModel.getStreet(), customerModel.getNumber(),
                    customerModel.getZip(), customerModel.getCity());
            customer.setAddress(address);

            if (customerModel.isActive()) {
                customer.activate();
            } else {
                customer.deactivate();
            }
            customer.addRewards(customerModel.getRewards());

            return customer;
        }).collect(Collectors.toList());
    }

    @Override
    public Customer update(Customer customer) {
        var customerExists = repository.findById(customer.getId()).orElseThrow(()-> new RuntimeException("Customer not found"));
        customerExists.setName(customer.getName());
        customerExists.setCity(customer.getAddress().getCity());
        customerExists.setStreet(customer.getAddress().getStreet());
        customerExists.setNumber(customer.getAddress().getNumber());
        customerExists.setZip(customer.getAddress().getZip());

        var customerSaved =  repository.save(customerExists);

        var adress = new Address(customerSaved.getStreet(),customerSaved.getNumber(),customerSaved.getZip(),customerSaved.getCity());
        var newCustomer = new Customer(customerSaved.getId(),customerSaved.getName());
        newCustomer.setAddress(adress);
        newCustomer.addRewards(customerSaved.getRewards());
        newCustomer.activate();
        return newCustomer;
    }


}
