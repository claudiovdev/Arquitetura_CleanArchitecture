package br.com.cleanarchitecture.infrastructure.repository;


import br.com.cleanarchitecture.infrastructure.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderModelRepository extends JpaRepository<OrderModel, String> {
}
