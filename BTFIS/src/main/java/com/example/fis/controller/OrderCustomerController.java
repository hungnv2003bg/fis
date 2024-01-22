package com.example.fis.controller;

import com.example.fis.model.request.order.OrderSaveRequest;
import com.example.fis.service.OrderCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/create-order")
public class OrderCustomerController {
    private final OrderCustomerService orderCustomerService;

    public ResponseEntity<?> add(@RequestBody OrderSaveRequest orderSaveRequest){
        return ResponseEntity.ok(orderCustomerService.addOrder(orderSaveRequest));
    }
}
