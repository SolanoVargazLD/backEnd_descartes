package com.descartes_api.service;

import com.descartes_api.model.AspirantBasic;
import com.descartes_api.repository.AspirantBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AspirantBasicService {
    @Autowired
    private AspirantBasicRepository aspirantBasicRepository;

    public List<AspirantBasic> listAspirantBasic(){
        return aspirantBasicRepository.findAll();
    }

    public ResponseEntity<AspirantBasic> listAspirantBasicId(Integer id){
        try{
            AspirantBasic aspirantBasic =aspirantBasicRepository.findById(id).get();
            return new ResponseEntity<AspirantBasic>(aspirantBasic, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<AspirantBasic>(HttpStatus.NOT_FOUND);
        }
    }

    public AspirantBasic saveAspirantBasic(AspirantBasic aspirantBasic){
        return aspirantBasicRepository.save(aspirantBasic);
    }

    public ResponseEntity<AspirantBasic> putAspirantBasic(AspirantBasic aspirantBasic, Integer id){
        Optional<AspirantBasic> aspirantBasicOptional= aspirantBasicRepository.findById(id);
        if(!aspirantBasicOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        AspirantBasic aspirantBasicPut= aspirantBasicOptional.get();
        aspirantBasicPut.setAspirant(aspirantBasic.getAspirant());
        aspirantBasicPut.setLevelBasic(aspirantBasic.getLevelBasic());
        aspirantBasicRepository.save(aspirantBasicPut);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<AspirantBasic> deleteAspirantBasic(Integer id){
        Optional<AspirantBasic> aspirantBasicOptional= aspirantBasicRepository.findById(id);
        if(!aspirantBasicOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        aspirantBasicRepository.deleteById(aspirantBasicOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
