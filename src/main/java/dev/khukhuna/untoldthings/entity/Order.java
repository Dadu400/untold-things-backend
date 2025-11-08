package dev.khukhuna.untoldthings.entity;

import dev.khukhuna.untoldthings.dto.BoughtProduct;
import dev.khukhuna.untoldthings.utils.BoughtProductsConverter;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private String city;

    @Convert(converter = BoughtProductsConverter.class)
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private List<BoughtProduct> boughtProducts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<BoughtProduct> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<BoughtProduct> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }
}
