package dev.khukhuna.untoldthings.dto;

public class AddMessageResponse {
    private Long id;

    public AddMessageResponse(Long id) {
        this.id = id;
    }

    public Long getMessageId() {
        return this.id;
    }

    public void setMessageId(Long id) {
        this.id = id;
    }
}
