package com.example.demo.model.response;

import com.example.demo.base.BaseResponseInternal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCartDTO {
    private BaseResponseInternal user;
    private CartResponse cart;
}
