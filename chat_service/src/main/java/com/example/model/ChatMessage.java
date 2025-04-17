package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_message")
public class ChatMessage {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
}
  public void setId(Long id) {
    this.id = id;
  }
  private Long chatId;        // 所属 Chat 房间
  public Long getChatId() {
    return chatId;
}
  public void setChatId(Long chatId) {
    this.chatId = chatId;
  }
  private Long senderId;
  public Long getSenderId() {
    return senderId;
}
  public void setSenderId(Long senderId) {
    this.senderId = senderId;
  }
  private String content;
  public String getContent() {
    return content;
}
  public void setContent(String content) {
    this.content = content;
  }
  private LocalDateTime sentAt;

  public LocalDateTime getSentAt() {
    return sentAt;
  }
  public void setSentAt(LocalDateTime sentAt) {
    this.sentAt = sentAt;
  }

}
