package dev.khukhuna.untoldthings.controller;

import dev.khukhuna.untoldthings.dto.GetMessageResponse;
import dev.khukhuna.untoldthings.dto.GetMessagesResponse;
import dev.khukhuna.untoldthings.dto.PostMessageRequest;
import dev.khukhuna.untoldthings.entity.UntoldMessage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class MessageController {

    private List<UntoldMessage> messages = new ArrayList<>();

    @GetMapping("/v1/messages")
    public GetMessagesResponse getAllMessages() {
        GetMessagesResponse messages = new GetMessagesResponse();
        messages.setMessages(this.messages);
        return messages;
    }

    @GetMapping("/v1/messages/{id}")
    public GetMessageResponse getMessageById(@PathVariable Long id) {
        for (UntoldMessage message : messages) {
            if (message.getId().equals(id)) {
                GetMessageResponse response = new GetMessageResponse();
                response.setMessage(message);
                return response;
            }
        }
        return null;
    }

    @PostMapping("/v1/messages")
    public void addMessage(@RequestBody PostMessageRequest message) {
        if (message.getMessage().length() > 230) {
            throw new IllegalStateException("Message is too long");
        }
        UntoldMessage newMessage = new UntoldMessage();
        newMessage.setId(messages.size() + 1L);
        newMessage.setMessageTo(message.getTo());
        newMessage.setMessage(message.getMessage());
        newMessage.setTimestamp(System.currentTimeMillis());
        newMessage.setLikes(0);
        newMessage.setShares(0);
        newMessage.setMessageStatus(UntoldMessage.MessageStatus.PENDING);

        messages.add(newMessage);
    }

    @PostMapping("/v1/messages/{id}/like")
    public void likeMessage(@PathVariable Long id) {
        for (UntoldMessage message : messages) {
            if (message.getId().equals(id)) {
                message.setLikes(message.getLikes() + 1);
            }
        }
    }

    @PostMapping("/v1/messages/{id}/unlike")
    public void unlikeMessage(@PathVariable Long id) {
        for (UntoldMessage message : messages) {
            if (message.getId().equals(id)) {
                message.setLikes(message.getLikes() - 1);
            }
        }
    }

    @PostMapping("/v1/messages/{id}/share")
    public void shareMessage(@PathVariable Long id) {
        for (UntoldMessage message : messages) {
            if (message.getId().equals(id)) {
                message.setShares(message.getShares() + 1);
            }
        }
    }
}

