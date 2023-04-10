package com.descartes_api.service;

import com.descartes_api.model.AspirantBasic;
import com.descartes_api.model.AspirantSuperior;
import com.descartes_api.repository.AspirantSuperiorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AspirantSuperiorService {
    @Autowired
    private AspirantSuperiorRepository aspirantSuperiorRepository;

    public List<AspirantSuperior> listAspirantSuperior(){
        return aspirantSuperiorRepository.findAll();
    }

    public ResponseEntity<AspirantSuperior> listAspirantSuperiorId(Integer id){
        try{
            AspirantSuperior aspirantSuperiorTemp= aspirantSuperiorRepository.findById(id).get();
            return new ResponseEntity<AspirantSuperior>(aspirantSuperiorTemp, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<AspirantSuperior>(HttpStatus.NOT_FOUND);
        }
    }

    public AspirantSuperior saveAspirantSuperior(AspirantSuperior aspirantSuperior){
        Optional<AspirantSuperior> aspirantOptional= aspirantSuperiorRepository.findByAspirantId(aspirantSuperior.getAspirant().getId());
        if (aspirantOptional.isPresent()) {
            return null;
        }
        return aspirantSuperiorRepository.save(aspirantSuperior);
    }

    public ResponseEntity<AspirantSuperior> putAspirantSuperior(AspirantSuperior aspirantSuperior, Integer id){
        Optional<AspirantSuperior> aspirantSuperiorOptional= aspirantSuperiorRepository.findById(id);
        if(!aspirantSuperiorOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        AspirantSuperior aspirantSuperiorTemp= aspirantSuperiorOptional.get();
        aspirantSuperiorTemp.setSchoolOrigin(aspirantSuperior.getSchoolOrigin());
        aspirantSuperiorTemp.setPhone(aspirantSuperior.getPhone());
        aspirantSuperiorTemp.setEmail(aspirantSuperior.getEmail());
        aspirantSuperiorTemp.setLevelHigher(aspirantSuperior.getLevelHigher());
        aspirantSuperiorTemp.setAspirant(aspirantSuperior.getAspirant());
        aspirantSuperiorRepository.save(aspirantSuperiorTemp);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<AspirantSuperior> deleteAspirantSuperior(Integer id){
        Optional<AspirantSuperior> aspirantSuperiorOptional= aspirantSuperiorRepository.findById(id);
        if(!aspirantSuperiorOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        aspirantSuperiorRepository.deleteById(aspirantSuperiorOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
