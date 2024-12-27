package dev.khukhuna.untoldthings.dto;

import dev.khukhuna.untoldthings.entity.UntoldMessage;

import java.util.ArrayList;
import java.util.List;

public class GetMessagesResponse {
    private List<UntoldMessage> messages = new ArrayList<>();

    public GetMessagesResponse() {

    }

    public List<UntoldMessage> getMessages() {
        return this.messages;
    }

    public void setMessages(List<UntoldMessage> messages) {
        this.messages = messages;
    }
}
