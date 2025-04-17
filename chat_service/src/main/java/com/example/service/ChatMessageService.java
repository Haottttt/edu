package com.example.service;

import com.example.model.ChatMessage;
import com.example.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.Optional;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository repo;

    /**
     * 保存并返回新消息，同时记录发送时间
     */
    public ChatMessage saveMessage(ChatMessage msg) {
        msg.setSentAt(LocalDateTime.now());
        return repo.save(msg);
    }

    /**
     * 根据 chatId 查询该聊天室所有消息
     */
    public Optional<ChatMessage> findByChatId(Long chatId) {
        return repo.findById(chatId);
    }
}
