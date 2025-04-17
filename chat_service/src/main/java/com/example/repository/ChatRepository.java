package com.example.repository;

import com.example.model.Chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByUserId(Long name);
}
