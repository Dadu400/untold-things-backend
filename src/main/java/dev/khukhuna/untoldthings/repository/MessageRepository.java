package dev.khukhuna.untoldthings.repository;

import dev.khukhuna.untoldthings.entity.UntoldMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<UntoldMessage, Long> {
}
