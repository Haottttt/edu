package com.example.controller;

import com.example.model.ChatMessage;
import com.example.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chat")
public class ChatController {
  @Autowired
  private ChatService service;

  @PostMapping("/send")
  public ChatMessage send(@RequestBody ChatMessage msg) {
    return service.saveMessage(msg);
  }

  @GetMapping("/history/{chatId}")
  public Optional<ChatMessage> history(@PathVariable Long chatId) {
    return service.history(chatId);
  }
}
