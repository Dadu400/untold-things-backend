package dev.khukhuna.untoldthings.dto;

public class PostMessageRequest {
    private String to;
    private String message;

    public String getTo() {
        return this.to;
    }

    public String getMessage() {
        return this.message;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
