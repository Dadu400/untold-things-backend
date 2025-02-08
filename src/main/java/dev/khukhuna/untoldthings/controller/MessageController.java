package dev.khukhuna.untoldthings.controller;

import dev.khukhuna.untoldthings.dto.*;
import dev.khukhuna.untoldthings.entity.UntoldMessage;
import dev.khukhuna.untoldthings.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/v1/messages")
    public GetMessagesResponse getApprovedMessages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size,
            @RequestParam(defaultValue = "") String query
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<UntoldMessage> responsePage = messageRepository.getUntoldMessageByMessageStatus(UntoldMessage.MessageStatus.APPROVED, query, pageable);

        GetMessagesResponse messages = new GetMessagesResponse();
        messages.setMessages(responsePage.getContent());
        return messages;
    }

    @GetMapping("/v1/messages/{id}")
    public GetMessageResponse getMessageById(@PathVariable Long id) {
        GetMessageResponse response = new GetMessageResponse();
        response.setMessage(messageRepository.findById(id).orElse(null));
        return response;
    }

    @PostMapping("/v1/messages")
    public AddMessageResponse addMessage(@RequestBody PostMessageRequest message) {
        if (message.getMessage().length() > 230) {
            throw new IllegalStateException("Message is too long");
        }
        UntoldMessage newMessage = new UntoldMessage();
        newMessage.setMessageTo(message.getTo());
        newMessage.setMessage(message.getMessage());
        newMessage.setTimestamp(System.currentTimeMillis());
        newMessage.setLikes(0);
        newMessage.setShares(0);
        newMessage.setMessageStatus(UntoldMessage.MessageStatus.PENDING);

        messageRepository.save(newMessage);

        return new AddMessageResponse(newMessage.getId());
    }

    @PostMapping("/v1/messages/{id}/like")
    public void likeMessage(@PathVariable Long id) {
        UntoldMessage untoldMessage = messageRepository.findById(id).orElse(null);
        if (untoldMessage != null) {
            untoldMessage.setLikes(untoldMessage.getLikes() + 1);
            messageRepository.save(untoldMessage);
        }
    }

    @PostMapping("/v1/messages/{id}/unlike")
    public void unlikeMessage(@PathVariable Long id) {
        UntoldMessage untoldMessage = messageRepository.findById(id).orElse(null);
        if (untoldMessage != null) {
            untoldMessage.setLikes(untoldMessage.getLikes() - 1);
            messageRepository.save(untoldMessage);
        }
    }

    @PostMapping("/v1/messages/{id}/share")
    public void shareMessage(@PathVariable Long id) {
        UntoldMessage untoldMessage = messageRepository.findById(id).orElse(null);
        if (untoldMessage != null) {
            untoldMessage.setShares(untoldMessage.getShares() + 1);
            messageRepository.save(untoldMessage);
        }
    }

    @PostMapping("/v1/messages/filtered")
    public GetMessagesResponse getFilteredUntoldMessage(@RequestBody GetFilteredMessageRequest message) {
        List <UntoldMessage> response = messageRepository.getFilteredUntoldMessage(UntoldMessage.MessageStatus.APPROVED, message.getQuery());
        Collections.reverse(response);

        GetMessagesResponse messages = new GetMessagesResponse();
        messages.setMessages(response);
        return messages;
    }
}

