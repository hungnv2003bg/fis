package com.example.fis.controller;

import com.example.fis.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/statistic")
public class Statistic {
    private final OrderService orderService;

    @GetMapping("/revenuedaytoday")
    public ResponseEntity<?> getRevenue(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        BigDecimal totalRevenue = orderService.sumRevenue(startDate.atStartOfDay(), endDate.atStartOfDay().plusDays(1).minusNanos(1));
        return ResponseEntity.ok(totalRevenue);
    }

}
