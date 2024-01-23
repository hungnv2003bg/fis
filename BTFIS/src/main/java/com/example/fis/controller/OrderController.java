package com.example.fis.controller;

import com.example.fis.model.request.order.OrderUpdateRequest;
import com.example.fis.model.response.OrderResponse;
import com.example.fis.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/cancel")
    public ResponseEntity<?> getInvoiceCancel() {
        return ResponseEntity.ok(orderService.getInvoiceCancel());
    }

    @GetMapping("/pending")
    public ResponseEntity<?> getInvoicePending() {
        return ResponseEntity.ok(orderService.getInvociePending());
    }

    @GetMapping("/pendingship")
    public ResponseEntity<?> getInvoicePendingShip() {
        return ResponseEntity.ok(orderService.getInvociePendingShip());
    }

    @GetMapping("/shipping")
    public ResponseEntity<?> getInvoiceShipping() {
        return ResponseEntity.ok(orderService.getInvoiceShipping());
    }

    @GetMapping("/completed")
    public ResponseEntity<?> getInvoiceCompleted() {
        return ResponseEntity.ok(orderService.getInvoiceCompleted());
    }


    @PutMapping("/status/{id}")
    public ResponseEntity<?> updateOrderStatus(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String newStatus = requestBody.get("statusOrder");
        OrderResponse updatedOrder = orderService.updateOrderStatus(id, newStatus);
        return ResponseEntity.ok(updatedOrder);
    }


}
