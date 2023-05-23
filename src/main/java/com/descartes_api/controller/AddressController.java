package com.descartes_api.controller;

import com.descartes_api.model.Address;
import com.descartes_api.repository.AddressRepository;
import com.descartes_api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/descartes")
@CrossOrigin
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public List<Address> getAddress() {
        return addressService.listAddress();
    }

    @GetMapping("/address/{id}")// ? Listar por ID
    public ResponseEntity<Address> getAddressID(@PathVariable Integer id){
        return addressService.listAddressId(id);
    }

    @PostMapping("/address")
    public ResponseEntity<Address> SaveRoles(@RequestBody Address address){
        Address addressTemp= addressService.saveAddress(address);
        return new ResponseEntity<>(addressTemp,HttpStatus.CREATED);
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<Address> updateRoles(@RequestBody Address address, @PathVariable Integer id) {
        return addressService.putAddress(address, id);
    }

    @DeleteMapping("/address/{id}") //? Eliminar un rol en base a su ID
    public ResponseEntity<Address> deleteRol(@PathVariable Integer id){
        return addressService.deleteAddressId(id);
    }

}
