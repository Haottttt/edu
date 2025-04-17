package com.example.repository;

import com.example.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStudentId(Long studentId);
    List<Order> findByCourseId(Long courseId);
    List<Order> findByStatus(String status);
 }
