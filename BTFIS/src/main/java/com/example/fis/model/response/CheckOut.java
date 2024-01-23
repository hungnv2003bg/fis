package com.example.fis.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOut {
    private List<CartResponse> productList;
    private List<AddressResponse> addressResponseList;
    private List<PayResponse> payResponseListist;
    private List<ShipResponse> shipResponseList;
}
