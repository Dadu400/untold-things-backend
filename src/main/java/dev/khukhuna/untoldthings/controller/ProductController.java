package dev.khukhuna.untoldthings.controller;

import dev.khukhuna.untoldthings.dto.GetProductsResponse;
import dev.khukhuna.untoldthings.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/v1/products")
    public GetProductsResponse getProducts() {
    GetProductsResponse getProductsResponse = new GetProductsResponse();
    getProductsResponse.setProducts(productRepository.findAll());
    return getProductsResponse;
    }
}
