package com.descartes_api.service;

import com.descartes_api.model.LevelUpperMiddle;
import com.descartes_api.repository.LevelUpperMiddleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class LevelUpperMiddleService {
    @Autowired
    private LevelUpperMiddleRepository levelUpperMiddleRepository;

    public List<LevelUpperMiddle> listLevelUpperMiddle(){
        return levelUpperMiddleRepository.findAll();
    }

    public ResponseEntity<LevelUpperMiddle> listLevelUpperMiddleID(Integer id){
        try{
            LevelUpperMiddle levelUpperMiddle= levelUpperMiddleRepository.findById(id).get();
            return new ResponseEntity<LevelUpperMiddle>(levelUpperMiddle, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<LevelUpperMiddle>(HttpStatus.NOT_FOUND);
        }
    }

    public LevelUpperMiddle saveLevelUpperMiddle(LevelUpperMiddle levelUpperMiddle){
        return levelUpperMiddleRepository.save(levelUpperMiddle);
    }

    public ResponseEntity<LevelUpperMiddle> putlevelUpper(LevelUpperMiddle levelUpper, Integer id){
        Optional<LevelUpperMiddle> levelUpperMiddlOptional = levelUpperMiddleRepository.findById(id);
        if(!levelUpperMiddlOptional.isPresent())
            return ResponseEntity.unprocessableEntity().build();
        LevelUpperMiddle levelUpperMiddle= levelUpperMiddlOptional.get();
        levelUpperMiddle.setName(levelUpper.getName());
        levelUpperMiddle.setLevel(levelUpper.getLevel());
        levelUpperMiddle.setImg(levelUpper.getImg());
        levelUpperMiddle.setAspiringBachillerates(levelUpper.getAspirantBachillerates());
        levelUpperMiddle.setSchool(levelUpper.getSchool());
        levelUpperMiddleRepository.save(levelUpperMiddle);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<LevelUpperMiddle> deleteLevelUpper(Integer id){
        Optional<LevelUpperMiddle> levelUpperMiddlOptional= levelUpperMiddleRepository.findById(id);
        if (!levelUpperMiddlOptional.isPresent())
            return ResponseEntity.unprocessableEntity().build();
        levelUpperMiddleRepository.deleteById(levelUpperMiddlOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
