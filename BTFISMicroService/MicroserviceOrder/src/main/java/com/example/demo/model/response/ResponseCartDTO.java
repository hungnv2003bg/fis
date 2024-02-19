package com.example.demo.model.response;

import com.example.demo.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCartDTO {
    private BaseResponse<UserDTO> user;
    private CartResponse cart;
    private ProductDTO product;
}
