
package com.example.repository;

import com.example.model.RefundRequest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRequestRepository extends JpaRepository<RefundRequest, Long> {
    List<RefundRequest> findByOrderId(Long orderId);
    List<RefundRequest> findByStatus(String status);
 }