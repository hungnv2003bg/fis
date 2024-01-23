package com.example.fis.model.response;

import com.example.fis.entity.Cart;
import com.example.fis.entity.Product;
import com.example.fis.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    private Long id;
    private User customer;
    private Product product;
    private Integer quantity;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public static CartResponse fromEntity(Cart entity) {
        User user = entity.getCustomer();
        user.setPassword("");
        return new CartResponse(
                entity.getId(),
                user,
                entity.getProduct(),
                entity.getQuantity(),
                entity.getCreateDate(),
                entity.getUpdateDate()
        );
    }

    public static List<CartResponse> fromCollection(List<Cart> collection) {
        List<CartResponse> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }

}
