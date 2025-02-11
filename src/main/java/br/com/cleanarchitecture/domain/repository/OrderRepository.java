package br.com.cleanarchitecture.domain.repository;

import br.com.cleanarchitecture.domain.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {

    void save(Order order);

    Order findById(String id);

    List<Order> findAll();
}
