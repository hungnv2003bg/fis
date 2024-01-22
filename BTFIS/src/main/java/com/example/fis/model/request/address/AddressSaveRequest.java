package com.example.fis.model.request.address;

import com.example.fis.entity.User;
import com.example.fis.enums.StatusAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressSaveRequest {
    private Long id;
    private Long userId;
    private String receiver;
    private String wardId;
    private String districtId;
    private String provinceId;
    private String ward;
    private String district;
    private String province;
    private String addressDetail;
    private LocalDateTime createDate;
    private String phone;
    private Boolean mainDress;
    private StatusAddress status;
}
