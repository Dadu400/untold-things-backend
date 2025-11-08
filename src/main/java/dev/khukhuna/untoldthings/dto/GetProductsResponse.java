package dev.khukhuna.untoldthings.dto;

import dev.khukhuna.untoldthings.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class GetProductsResponse {
    private List<Product> products = new ArrayList<>();

    public GetProductsResponse() {
    };

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
