package com.example.service;

import com.example.model.RefundRequest;
import com.example.repository.RefundRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RefundRequestService {
  @Autowired private RefundRequestRepository repo;

  public RefundRequest request(Long orderId, String reason) {
    RefundRequest r = new RefundRequest();
    r.setOrderId(orderId);
    r.setReason(reason);
    r.setStatus("REQUESTED");
    r.setRequestAt(LocalDateTime.now());
    return repo.save(r);
  }

  public RefundRequest updateStatus(Long id, String status) {
    RefundRequest r = repo.findById(id)
      .orElseThrow(() -> new RuntimeException("退款请求不存在"));
    r.setStatus(status);
    return repo.save(r);
  }
}
