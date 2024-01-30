package com.example.demo.controller;

import com.example.demo.model.request.address.AddressSaveRequest;
import com.example.demo.model.request.address.AddressUpdateRequest;
import com.example.demo.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("{userId}")
    public ResponseEntity<?> getAddress(@PathVariable Long userId){
        return ResponseEntity.ok(addressService.getAddressUser(userId));
    }

    @PostMapping
    public ResponseEntity<?> addAddress(@RequestBody AddressSaveRequest addressSaveRequest){
        return ResponseEntity.ok(addressService.addAddress(addressSaveRequest));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody AddressUpdateRequest updateRequest){
        return ResponseEntity.ok(addressService.updateAddress(id, updateRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id){
        return ResponseEntity.ok(addressService.deleteAddress(id));
    }

}
