package dev.khukhuna.untoldthings.dto;

import dev.khukhuna.untoldthings.entity.UntoldMessage;

public class GetMessageResponse {
    private UntoldMessage message;

    public GetMessageResponse() {

    }

    public UntoldMessage getMessage() {
        return this.message;
    }

    public void setMessage(UntoldMessage message) {
        this.message = message;
    }

}
