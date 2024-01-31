package com.example.demo.controller;

import com.example.demo.exception.BusinessCode;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.response.OrderResponseDTO;
import com.example.demo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController extends BaseController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity getOrders() {
        try {
            List<OrderResponseDTO> orderResponseDTOS = orderService.getOrders();
            return success(orderResponseDTOS);
        } catch (Exception e) {
            return error(new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR));
        }
    }
}
