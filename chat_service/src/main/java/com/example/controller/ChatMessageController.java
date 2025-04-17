package com.example.controller;

import com.example.model.ChatMessage;
import com.example.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class ChatMessageController {

    @Autowired
    private ChatMessageService messageService;

    /**
     * 发送一条聊天消息
     */
    @PostMapping("/")
    public ChatMessage send(@RequestBody ChatMessage msg) {
        return messageService.saveMessage(msg);
    }

    /**
     * 查询指定聊天室的消息历史
     */
    @GetMapping("/chat/{chatId}")
    public Optional<ChatMessage> history(@PathVariable Long chatId) {
        return messageService.findByChatId(chatId);
    }
}
