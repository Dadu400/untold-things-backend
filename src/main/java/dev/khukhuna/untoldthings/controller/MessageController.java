package dev.khukhuna.untoldthings.controller;

import dev.khukhuna.untoldthings.dto.GetMessageResponse;
import dev.khukhuna.untoldthings.dto.GetMessagesResponse;
import dev.khukhuna.untoldthings.dto.PostMessageRequest;
import dev.khukhuna.untoldthings.entity.UntoldMessage;
import dev.khukhuna.untoldthings.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/v1/messages")
    public GetMessagesResponse getAllMessages() {
        GetMessagesResponse messages = new GetMessagesResponse();
        messages.setMessages(messageRepository.findAll());
        return messages;
    }

    @GetMapping("/v1/messages/{id}")
    public GetMessageResponse getMessageById(@PathVariable Long id) {
        GetMessageResponse response = new GetMessageResponse();
        response.setMessage(messageRepository.findById(id).orElse(null));
        return response;
    }

    @PostMapping("/v1/messages")
    public void addMessage(@RequestBody PostMessageRequest message) {
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
}

