package com.example.controller;

import com.example.model.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
  @Autowired private OrderService service;

  @PostMapping("/create")
  public Order create(@RequestParam Long studentId,
                      @RequestParam Long courseId,
                      @RequestParam Double amount) {
    return service.create(studentId, courseId, amount);
  }

  @GetMapping("/{id}")
  public Order get(@PathVariable Long id) {
    return service.findById(id)
                  .orElseThrow(() -> new RuntimeException("订单不存在"));
  }
}
