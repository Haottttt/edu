package com.example.controller;

import com.example.model.RefundRequest;
import com.example.service.RefundRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refund")
public class RefundRequestController {
  @Autowired private RefundRequestService service;

  @PostMapping("/request")
  public RefundRequest request(@RequestParam Long orderId,
                               @RequestParam String reason) {
    return service.request(orderId, reason);
  }

  @PostMapping("/updateStatus")
  public RefundRequest update(@RequestParam Long id,
                              @RequestParam String status) {
    return service.updateStatus(id, status);
  }
}
