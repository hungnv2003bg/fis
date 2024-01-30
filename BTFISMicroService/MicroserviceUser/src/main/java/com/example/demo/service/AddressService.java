package com.example.demo.service;

import com.example.demo.model.request.address.AddressSaveRequest;
import com.example.demo.model.request.address.AddressUpdateRequest;
import com.example.demo.model.response.AddressResponse;

import java.util.List;

public interface AddressService {
    public List<AddressResponse> getAddressUser(Long userId);

    public AddressResponse addAddress(AddressSaveRequest addressSaveRequest);

    public AddressResponse updateAddress(Long id, AddressUpdateRequest updateRequest);

    public List<AddressResponse> deleteAddress(Long id);
}
