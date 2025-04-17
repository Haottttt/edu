package com.example.controller;

import com.example.model.Payment;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
  @Autowired private PaymentService service;

  @PostMapping("/pay")
  public Payment pay(@RequestParam Long orderId,
                     @RequestParam String method) {
    return service.pay(orderId, method);
  }
}
