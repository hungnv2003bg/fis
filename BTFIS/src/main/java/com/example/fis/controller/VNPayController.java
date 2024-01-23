package com.example.fis.controller;


import com.example.fis.service.OrderCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/vnpay")
public class VNPayController {
    private OrderCustomerService orderCustomerService;

    @RequestMapping("/checkvnpay")
    public ResponseEntity<?> checkVNPay(@RequestParam Long id, @RequestParam Long statusOrder) {
        orderCustomerService.checkPayVNPay(id, statusOrder);
        return ResponseEntity.ok("");
    }

}
