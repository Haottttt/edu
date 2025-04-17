package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.CopyOnWriteArraySet;

@Service
public class ChatWebSocketService {
  private final CopyOnWriteArraySet<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

  public void register(WebSocketSession session) {
    sessions.add(session);
  }

  public void broadcast(String payload) {
    sessions.forEach(sess -> {
      try {
        sess.sendMessage(new TextMessage(payload));
      } catch (Exception e) {
        // log
      }
    });
  }
}
