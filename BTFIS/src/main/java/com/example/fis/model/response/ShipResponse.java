package com.example.fis.model.response;

import com.example.fis.entity.Order;
import com.example.fis.entity.Ship;
import com.example.fis.enums.StatusShip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShipResponse {
    private Long id;
    private String codeShip;
    private String nameShip;
    private StatusShip statusShip;
    private List<Order> orderList;
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;

    public static ShipResponse fromEntity(Ship entity) {
        return new ShipResponse(
                entity.getId(),
                entity.getCodeShip(),
                entity.getNameShip(),
                entity.getStatusShip(),
                entity.getOrderList(),
                entity.getCreateDate(),
                entity.getUpdatedDate()
        );
    }

    public static List<ShipResponse> fromCollection(List<Ship> collection) {
        List<ShipResponse> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
