package com.descartes_api.service;

import com.descartes_api.model.Address;
import com.descartes_api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> listAddress(){
        return addressRepository.findAll();
    }

    public ResponseEntity<Address> listAddressId(Integer id){
        try{
            Address addressTemp= addressRepository.findById(id).get();
            return new ResponseEntity<Address>(addressTemp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
    }
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public ResponseEntity<Address> putAddress(Address address, Integer id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(!addressOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        Address addressPut= addressOptional.get();
        addressPut.setStreet(address.getStreet());
        addressPut.setNumber(address.getNumber());
        addressPut.setColony(address.getColony());
        addressPut.setMunicipality(address.getMunicipality());
        addressPut.setPostal_code(address.getPostal_code());
        addressRepository.save(addressPut);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Address> deleteAddressId(Integer id){
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(!addressOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        addressRepository.deleteById(addressOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
