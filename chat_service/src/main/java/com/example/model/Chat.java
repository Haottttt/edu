package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat")
public class Chat {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
}
  public void setId(Long id) {
    this.id = id;
  }
  private Long roomId;
  public Long getRoomId() {
    return roomId;
}
  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }
  private String name;        // 房间名或聊天主题
  public String getName() {
    return name;
}
  public void setName(String name) {
    this.name = name;
  }
  private LocalDateTime createdAt;

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

}
