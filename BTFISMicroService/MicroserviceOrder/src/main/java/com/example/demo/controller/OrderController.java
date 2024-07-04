package com.example.demo.controller;

import com.example.demo.exception.BusinessCode;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.response.OrderResponse;
import com.example.demo.model.response.OrderResponseDTO;
import com.example.demo.service.OrderAdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController extends BaseController {

    private final OrderAdminService orderService;

    @GetMapping
    public ResponseEntity getOrders() {
        List<OrderResponseDTO> orderResponseDTOS = orderService.getOrders();
        return success(orderResponseDTOS);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity updateOrderStatus(@PathVariable("id") Long id,
                                            @RequestParam("newStatus") String newStatus) {
        OrderResponse updatedOrder = orderService.updateOrderStatus(id, newStatus);
        return success(updatedOrder);
    }

}
