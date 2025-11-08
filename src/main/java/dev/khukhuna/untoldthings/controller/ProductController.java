package dev.khukhuna.untoldthings.controller;

import dev.khukhuna.untoldthings.dto.CreateOrderRequest;
import dev.khukhuna.untoldthings.dto.GetProductsResponse;
import dev.khukhuna.untoldthings.entity.Order;
import dev.khukhuna.untoldthings.repository.OrderRepository;
import dev.khukhuna.untoldthings.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/v1/products")
    public GetProductsResponse getProducts() {
        GetProductsResponse getProductsResponse = new GetProductsResponse();
        getProductsResponse.setProducts(productRepository.findAll());
        return getProductsResponse;
    }

    @PostMapping("/v1/orders")
    public void addOrder(@RequestBody CreateOrderRequest orderRequest) {
        Order order = new Order();
        order.setName(orderRequest.getName());
        order.setPhoneNumber(orderRequest.getPhoneNumber());
        order.setAddress(orderRequest.getAddress());
        order.setCity(orderRequest.getCity());
        order.setBoughtProducts(orderRequest.getBoughtProducts());

        orderRepository.save(order);
    }
}
