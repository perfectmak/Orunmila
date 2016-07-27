package com.orunmila.models;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Perfect<perfect@kudi.ai>
 *         Created on 7/27/16.
 */
public class Message {
    private String id;
    private final String text;
    private final String senderId;
    private final String recipientId;
    private Date timeCreated;
    private String intentId;

    public Message(String id, String text, String senderId, String recipientId, Date timeCreated, String intentId) {
        this.id = id;
        this.text = text;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.timeCreated = timeCreated;
        this.intentId = intentId;
    }

    public Message(String id, String text, String senderId, String recipientId, String intentId) {
        this.id = id;
        this.text = text;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.intentId = intentId;
        this.timeCreated = Calendar.getInstance().getTime();
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getSenderId() {
        return senderId;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public String getIntentId() {
        return intentId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", senderId='" + senderId + '\'' +
                ", recipientId='" + recipientId + '\'' +
                ", timeCreated=" + timeCreated +
                ", intentId='" + intentId + '\'' +
                '}';
    }
}
