package dev.khukhuna.untoldthings.repository;

import dev.khukhuna.untoldthings.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
