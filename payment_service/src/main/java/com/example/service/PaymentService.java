package com.example.service;

import com.example.model.Order;
import com.example.model.Payment;
import com.example.repository.OrderRepository;
import com.example.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
  @Autowired private PaymentRepository payRepo;
  @Autowired private OrderRepository orderRepo;

  public Payment pay(Long orderId, String method) {
    Order o = orderRepo.findById(orderId)
      .orElseThrow(() -> new RuntimeException("订单不存在"));
    Payment p = new Payment();
    p.setOrderId(orderId);
    p.setAmount(o.getAmount());
    p.setMethod(method);
    p.setStatus("SUCCESS");
    p.setPaidAt(LocalDateTime.now());
    p = payRepo.save(p);
    // 更新订单状态
    o.setStatus("PAID");
    orderRepo.save(o);
    return p;
  }
}
