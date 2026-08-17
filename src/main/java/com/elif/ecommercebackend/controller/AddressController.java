package com.elif.ecommercebackend.controller;

import com.elif.ecommercebackend.entity.Address;
import com.elif.ecommercebackend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/address")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<List<Address>> getAddresses() {
        return ResponseEntity.ok(addressRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        Address saved = addressRepository.save(address);
        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        Address updated = addressRepository.save(address);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}