package com.descartes_api.service;

import com.descartes_api.model.LevelBasic;
import com.descartes_api.repository.LevelBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelBasicService {
    @Autowired
    private LevelBasicRepository levelBasicRepository;

    public List<LevelBasic> listLevelBasic(){
        return levelBasicRepository.findAll();
    }

    public ResponseEntity<LevelBasic> listLevelBasicId(Integer id){
        try{
            LevelBasic levelBasic= levelBasicRepository.findById(id).get();
            return new ResponseEntity<LevelBasic>(levelBasic, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<LevelBasic>(HttpStatus.NOT_FOUND);
        }
    }

    public LevelBasic saveLevelBasic(LevelBasic levelBasic){
        return levelBasicRepository.save(levelBasic);
    }

    public ResponseEntity<LevelBasic> putLevelBasic(LevelBasic levelBasic, Integer id){
        Optional<LevelBasic> levelBasicOptional= levelBasicRepository.findById(id);
        if(!levelBasicOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        LevelBasic levelBasicPut= levelBasicOptional.get();
        levelBasicPut.setName(levelBasic.getName());
        levelBasicPut.setLevel(levelBasic.getLevel());
        levelBasicPut.setImg(levelBasic.getImg());
        //levelBasicPut.setAspirantBasic(levelBasic.getAspirantBasic());
        levelBasicRepository.save(levelBasicPut);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<LevelBasic> deleteLevelBasic(Integer id){
        Optional<LevelBasic> levelBasicOptional= levelBasicRepository.findById(id);
        if(!levelBasicOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        levelBasicRepository.deleteById(levelBasicOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
