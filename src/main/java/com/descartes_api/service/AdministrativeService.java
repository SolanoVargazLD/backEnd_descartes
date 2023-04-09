package com.descartes_api.service;

import com.descartes_api.model.Administrative;
import com.descartes_api.repository.AdministrativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativeService {

    @Autowired
    private AdministrativeRepository administrativeRepository;

    public List<Administrative> listAdministrative(){
        return administrativeRepository.findAll();
    }

    public ResponseEntity<Administrative> listadministrativeId(Integer id){
        try {
            Administrative administrative= administrativeRepository.findById(id).get();
            return new ResponseEntity<>(administrative, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Administrative saveAdministrative(Administrative administrative) {
        return administrativeRepository.save(administrative);
    }

    public ResponseEntity<Administrative> putAdministrativeId(Administrative administrative, Integer id){
         Optional<Administrative> administrativeOptional= administrativeRepository.findById(id);
         if(!administrativeOptional.isPresent()){
             return ResponseEntity.unprocessableEntity().build();
         }
         Administrative administrativePut= administrativeOptional.get();
         administrativePut.setName(administrative.getName());
         administrativePut.setLastNameP(administrative.getLastNameP());
         administrativePut.setLastNameM(administrative.getLastNameM());
         administrativePut.setEmail(administrative.getEmail());
         administrativePut.setPhone(administrative.getPhone());
         administrativePut.setRoles(administrative.getRoles());
         administrativePut.setSchool(administrative.getSchool());
         administrativeRepository.save(administrativePut);
         return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Administrative> deleteAdministrativeId(Integer id){
        Optional<Administrative> administrativeOptional= administrativeRepository.findById(id);
        if(!administrativeOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        administrativeRepository.deleteById(administrativeOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
