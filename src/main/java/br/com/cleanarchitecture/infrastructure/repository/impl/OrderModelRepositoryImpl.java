package br.com.cleanarchitecture.infrastructure.repository.impl;


import br.com.cleanarchitecture.domain.entity.Order;
import br.com.cleanarchitecture.domain.entity.OrderItem;
import br.com.cleanarchitecture.domain.repository.OrderRepository;
import br.com.cleanarchitecture.infrastructure.model.CustomerModel;
import br.com.cleanarchitecture.infrastructure.model.OrderItemModel;
import br.com.cleanarchitecture.infrastructure.model.OrderModel;
import br.com.cleanarchitecture.infrastructure.model.ProductModel;
import br.com.cleanarchitecture.infrastructure.repository.CustomerModelRepository;
import br.com.cleanarchitecture.infrastructure.repository.OrderModelRepository;
import br.com.cleanarchitecture.infrastructure.repository.ProductModelRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class OrderModelRepositoryImpl implements OrderRepository {


    private final OrderModelRepository orderModelRepository;
    private final CustomerModelRepository customerModelRepository;

    private final ProductModelRepository productModelRepository;

    public OrderModelRepositoryImpl(@Lazy OrderModelRepository orderModelRepository, CustomerModelRepository customerModelRepository, ProductModelRepository productModelRepository) {
        this.orderModelRepository = orderModelRepository;
        this.customerModelRepository = customerModelRepository;
        this.productModelRepository = productModelRepository;
    }

    @Override
    public void save(Order order) {
        // Busca o cliente
        CustomerModel customer = customerModelRepository.findById(order.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        OrderModel orderModel = new OrderModel();
        orderModel.setId(order.getId());
        orderModel.setCustomerModel(customer);
        orderModel.setTotal(order.getTotal());

        List<OrderItemModel> items = order.getItems().stream().map(o -> {
            ProductModel productModel = productModelRepository.findById(o.getProductId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            return new OrderItemModel(
                    o.getId(),
                    productModel,
                    orderModel, // Relaciona o item com o pedido
                    o.getNome(),
                    o.getPrice(),
                    o.getQuantity()
            );
        }).collect(Collectors.toList());

        // Associa os itens ao pedido
        orderModel.setItems(items);

        // Salva o pedido junto com os itens
        orderModelRepository.save(orderModel);
    }

    @Override
    public Order findById(String id) {
        OrderModel orderModel = orderModelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        List<OrderItem> orderItems = orderModel.getItems().stream().map(item ->
                new OrderItem(
                        item.getId(),
                        item.getProductModel().getId(),
                        item.getNome(),
                        item.getPrice(),
                        item.getQuantity()
                )
        ).collect(Collectors.toList());

        return new Order(orderModel.getId(), orderModel.getCustomerModel().getId(), orderItems);
    }

    @Override
    public List<Order> findAll() {
        return null; // Implementar lógica de busca
    }
}
