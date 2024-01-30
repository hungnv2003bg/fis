package com.example.demo.service.impl;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.model.request.address.AddressSaveRequest;
import com.example.demo.model.request.address.AddressUpdateRequest;
import com.example.demo.model.response.AddressResponse;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    private final UserRepo userRepo;

    private final AddressMapper addressMapper;

    @Override
    public List<AddressResponse> getAddressUser(Long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUD);
        }
        List<Address> addressList = addressRepo.findAddresssByUser(userOptional.get());
        return addressList.stream().map(addressMapper::toAddressReponse).toList();
    }

    @Override
    public AddressResponse addAddress(AddressSaveRequest addressSaveRequest) {
        if (addressSaveRequest.getReceiver().equals("")) {
            throw new BusinessException(ErrorCode.RECEIVER_NOT_BLANK);
        }
        if (addressSaveRequest.getWard().equals("")) {
            throw new BusinessException(ErrorCode.WARD_NOT_BLANK);
        }
        if (addressSaveRequest.getDistrict().equals("")) {
            throw new BusinessException(ErrorCode.DISTRICT_NOT_BLANK);
        }
        if (addressSaveRequest.getProvince().equals("")) {
            throw new BusinessException(ErrorCode.PROVINCE_NOT_BLANK);
        }
        if (addressSaveRequest.getAddressDetail().equals("")) {
            throw new BusinessException(ErrorCode.DETAILADDRESS_NOT_BLANK);
        }
        if (addressSaveRequest.getMainDress().equals("")) {
            throw new BusinessException(ErrorCode.MAINDRESS_NOT_BLANK);
        }
        User user = userRepo.findById(addressSaveRequest.getUserId())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUD));
        Address address = addressMapper.toAddress(addressSaveRequest);
        address.setCreateDate(LocalDateTime.now());
        addressRepo.save(address);
        return addressMapper.toAddressReponse(address);
    }

    @Override
    public AddressResponse updateAddress(Long id, AddressUpdateRequest updateRequest) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.ADDRESS_NOT_FOUD);
        }
        Address address = addressMapper.toAddress(updateRequest);
        address.setUpdateDate(LocalDateTime.now());
        addressRepo.save(address);
        return addressMapper.toAddressReponse(address);
    }

    @Override
    public List<AddressResponse> deleteAddress(Long id) {
        Optional<Address> addressOptional = addressRepo.findById(id);
        if (addressOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.ADDRESS_NOT_FOUD);
        }
        addressRepo.deleteById(id);
        return getAddressUser(addressOptional.get().getUser().getId());
    }
}
