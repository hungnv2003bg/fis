package com.example.fis.model.response;

import com.example.fis.entity.Address;
import com.example.fis.entity.Cart;
import com.example.fis.entity.User;
import com.example.fis.enums.StatusAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public static AddressResponse fromEntity(Address entity) {
        User user = entity.getUser();
        user.setPassword("");
        return new AddressResponse(
                entity.getId(),
                user,
                entity.getReceiver(),
                entity.getWardId(),
                entity.getDistrictId(),
                entity.getProvinceId(),
                entity.getWard(),
                entity.getDistrict(),
                entity.getProvince(),
                entity.getAddressDetail(),
                entity.getCreateDate(),
                entity.getUpdateDate(),
                entity.getPhone(),
                entity.getMainDress(),
                entity.getStatus()
        );
    }

    public static List<AddressResponse> fromCollection(List<Address> collection) {
        List<AddressResponse> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
