package com.example.service;

import com.example.model.ChatMessage;
import com.example.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {
  @Autowired
  private ChatMessageRepository messageRepo;

  public ChatMessage saveMessage(ChatMessage msg) {
    msg.setSentAt(java.time.LocalDateTime.now());
    return messageRepo.save(msg);
  }

  public Optional<ChatMessage> history(Long chatId) {
    return messageRepo.findById(chatId);
  }
}
