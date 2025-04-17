package com.example.service;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {
  @Autowired private OrderRepository repo;

  public Order create(Long studentId, Long courseId, Double amount) {
    Order o = new Order();
    o.setStudentId(studentId);
    o.setCourseId(courseId);
    o.setAmount(amount);
    o.setStatus("PENDING");
    o.setCreatedAt(LocalDateTime.now());
    return repo.save(o);
  }

  public Order updateStatus(Long id, String status) {
    Order o = repo.findById(id).orElseThrow(() -> new RuntimeException("订单不存在"));
    o.setStatus(status);
    return repo.save(o);
  }

  public Optional<Order> findById(Long id) {
    return repo.findById(id);
  }
}
