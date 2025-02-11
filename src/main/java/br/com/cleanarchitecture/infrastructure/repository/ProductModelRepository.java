package br.com.cleanarchitecture.infrastructure.repository;

import br.com.cleanarchitecture.infrastructure.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel,String> {
}
