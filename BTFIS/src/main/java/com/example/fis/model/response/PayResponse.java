package com.example.fis.model.response;

import com.example.fis.entity.Order;
import com.example.fis.entity.Pay;
import com.example.fis.enums.StatusPay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayResponse {
    private Long id;
    private String codePay;
    private String namePay;
    private StatusPay status;
    private List<Order> orderList;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;

    public static PayResponse fromEntity(Pay entity) {
        return new PayResponse(
                entity.getId(),
                entity.getCodePay(),
                entity.getNamePay(),
                entity.getStatus(),
                entity.getOrderList(),
                entity.getCreateDate(),
                entity.getUpdatedDate()
        );
    }

    public static List<PayResponse> fromCollection(List<Pay> collection) {
        List<PayResponse> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
