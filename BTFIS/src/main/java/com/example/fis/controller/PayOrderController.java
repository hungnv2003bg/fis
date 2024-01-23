package com.example.fis.controller;

import com.example.fis.model.request.order.OrderSaveRequest;
import com.example.fis.service.OrderCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/pay")
public class PayOrderController {
    private final OrderCustomerService orderCustomerService;

    @GetMapping("{orderId}")
    public ResponseEntity<?> getDataPay(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderCustomerService.getDataPay(orderId));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createInvoice(@RequestBody OrderSaveRequest orderSaveRequest) {
        return ResponseEntity.ok(orderCustomerService.addOrder(orderSaveRequest));
    }
}
