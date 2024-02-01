package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOut {
    private List<CartResponse> cartResponses;
    private List<AddressDTO> addressDTOS;
    private List<PayDTO> payDTOS;
    private List<ShipDTO> shipDTOS;
}
