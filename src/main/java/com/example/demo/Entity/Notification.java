package com.example.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "sent_by")
    private String sentBy;

    @Column(name = "sent_to")
    private int sentTo;

    @Column(name = "sent_time")
    private LocalTime sentTime;

    @Column(name = "sent_date")
    private LocalDate sentDate;

    @Column(name = "content")
    private String content;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getSentBy() {
        return sentBy;
    }

    public int getSentTo() {
        return sentTo;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public LocalTime getSentTime() {
        return sentTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public void setSentDate(LocalDate sentDate) {
        this.sentDate = sentDate;
    }

    public void setSentTime(LocalTime sentTime) {
        this.sentTime = sentTime;
    }

    public void setSentTo(int sentTo) {
        this.sentTo = sentTo;
    }
}
