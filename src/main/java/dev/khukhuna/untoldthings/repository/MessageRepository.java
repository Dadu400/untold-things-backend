package dev.khukhuna.untoldthings.repository;

import dev.khukhuna.untoldthings.entity.UntoldMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<UntoldMessage, Long> {

    @Query("SELECT m FROM UntoldMessage m WHERE m.messageStatus = ?1")
    List<UntoldMessage> getUntoldMessageByMessageStatus(UntoldMessage.MessageStatus messageStatus);

    @Query("SELECT m FROM UntoldMessage m WHERE m.messageStatus = ?1 AND lower(m.messageTo) = lower(?2)")
    List<UntoldMessage> getFilteredUntoldMessage(UntoldMessage.MessageStatus messageStatus, String messageTo);

}
