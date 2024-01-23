package com.example.fis.controller;

import com.example.fis.model.request.order.OrderUpdateRequest;
import com.example.fis.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

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

    @PutMapping("/topendingship/{id}")
    public ResponseEntity<?> toInvoicePendingShip(@PathVariable Long id, @RequestBody OrderUpdateRequest updateRequest) {
        return ResponseEntity.ok(orderService.toInvoicePendingShip(id, updateRequest));
    }


    @PutMapping("/status/{id}")
    public ResponseEntity<?> toStatusInvoice(@PathVariable Long id, @RequestBody OrderUpdateRequest updateRequest) {
        return ResponseEntity.ok(orderService.updateStatus(id, updateRequest));
    }


}
