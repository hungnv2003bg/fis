package com.example.demo.model.response;


import com.example.demo.entity.User;
import com.example.demo.enums.StatusAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private Long id;
    private User user;
    private String receiver;
    private String wardId;
    private String districtId;
    private String provinceId;
    private String ward;
    private String district;
    private String province;
    private String addressDetail;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String phone;
    private Boolean mainDress;
    private StatusAddress status;

}
