package dev.khukhuna.untoldthings.entity;

public class UntoldMessage {
    private Long id;
    private String messageTo;
    private String message;
    private Long timestamp;
    private Integer likes;
    private Integer shares;
    private MessageStatus messageStatus;

    public enum MessageStatus {
        PENDING,
        APPROVED,
        REJECTED
    }

    public UntoldMessage(Long id, String messageTo, String message, Long timestamp, Integer likes, Integer shares, MessageStatus messageStatus) {
        this.id = id;
        this.messageTo = messageTo;
        this.message = message;
        this.timestamp = timestamp;
        this.likes = likes;
        this.shares = shares;
        this.messageStatus = messageStatus;
    }

    public UntoldMessage() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long getId) {
        this.id = getId;
    }

    public String getMessageTo() {
        return this.messageTo;
    }

    public void setMessageTo(String messageTo) {
        this.messageTo = messageTo;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLikes() {
        return this.likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getShares() {
        return this.shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public MessageStatus getMessageStatus() {
        return this.messageStatus;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }

}




