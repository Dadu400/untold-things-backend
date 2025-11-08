package dev.khukhuna.untoldthings.repository;

import dev.khukhuna.untoldthings.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
