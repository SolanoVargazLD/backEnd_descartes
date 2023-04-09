package com.descartes_api.service;

import com.descartes_api.model.AspirantBachillerate;
import com.descartes_api.repository.AspirantBachillerateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AspirantBachillerateService {
    @Autowired
    private AspirantBachillerateRepository aspirantBachillerateRepository;

    public List<AspirantBachillerate> listAspirantBachillerates(){
        return aspirantBachillerateRepository.findAll();
    }

    public ResponseEntity<AspirantBachillerate> listAspirantBachillerateId(Integer id){
        try{
            AspirantBachillerate aspirantBachillerate= aspirantBachillerateRepository.findById(id).get();
            return new ResponseEntity<AspirantBachillerate>(aspirantBachillerate, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<AspirantBachillerate>(HttpStatus.NOT_FOUND);
        }
    }

    public AspirantBachillerate postAspirantBachillerate(AspirantBachillerate aspirantBachillerate){
        return aspirantBachillerateRepository.save(aspirantBachillerate);
    }

    public ResponseEntity<AspirantBachillerate> putAspirantBachillerate(AspirantBachillerate aspirantBachillerate, Integer id){
        Optional<AspirantBachillerate> aspirantBachillerateOptional= aspirantBachillerateRepository.findById(id);
        if (!aspirantBachillerateOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        AspirantBachillerate aspirantBachillerateTemp= aspirantBachillerateOptional.get();
        aspirantBachillerateTemp.setSchoolOrigin(aspirantBachillerate.getSchoolOrigin());
        aspirantBachillerateTemp.setPhone(aspirantBachillerate.getPhone());
        aspirantBachillerateTemp.setEmail(aspirantBachillerate.getEmail());
        aspirantBachillerateTemp.setAspirant(aspirantBachillerate.getAspirant());
        aspirantBachillerateTemp.setLevelUpperMiddle(aspirantBachillerate.getLevelUpperMiddle());
        aspirantBachillerateRepository.save(aspirantBachillerateTemp);
        return ResponseEntity.noContent().build();
    }

    public  ResponseEntity<AspirantBachillerate> deleteAspirantBachillerate(Integer id){
        Optional<AspirantBachillerate> aspirantBachillerateOptional= aspirantBachillerateRepository.findById(id);
        if (!aspirantBachillerateOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        aspirantBachillerateRepository.deleteById(aspirantBachillerateOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
