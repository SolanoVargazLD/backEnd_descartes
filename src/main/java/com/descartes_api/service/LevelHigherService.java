package com.descartes_api.service;

import com.descartes_api.model.LevelHigher;
import com.descartes_api.repository.LevelHigherRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LevelHigherService {

    @Autowired
    private LevelHigherRespository levelHigherRespository;

    public List<LevelHigher> listLevelHigher(){
        return levelHigherRespository.findAll();
    }

    public ResponseEntity<LevelHigher> listLevelHigherID(Integer id){
        try {
            LevelHigher levelHigher = levelHigherRespository.findById(id).get();
            return new ResponseEntity<LevelHigher>(levelHigher, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<LevelHigher>(HttpStatus.NOT_FOUND);
        }
    }

    public List<?> listLicenciatures(){
        List<Object[]> InfoList = levelHigherRespository.findIdAndNivelEducativoByLicenciatura();
        List<Map<String, Object>> InfoMapList = new ArrayList<>();

        for (Object[] row : InfoList) {
            Map<String, Object> ListInfoMap = new HashMap<>();
            ListInfoMap.put("id", row[0]);
            ListInfoMap.put("name", row[1]);
            InfoMapList.add(ListInfoMap);
        }
        return InfoMapList;
    }

    public List<?> listPostgraduate(String nivelEducativePosgrado){
        List<Object[]> InfoList = levelHigherRespository.findIdAndNivelEducativoByPosgrado(nivelEducativePosgrado);
        List<Map<String, Object>> InfoMapList = new ArrayList<>();

        for (Object[] row : InfoList) {
            Map<String, Object> ListInfoMap = new HashMap<>();
            ListInfoMap.put("id", row[0]);
            ListInfoMap.put("name", row[1]);
            InfoMapList.add(ListInfoMap);
        }
        return InfoMapList;
    }

    public LevelHigher saveLevelHigher(LevelHigher levelHigher){
        return levelHigherRespository.save(levelHigher);
    }

    public ResponseEntity<LevelHigher> putLevelHigher(LevelHigher levelHigher, Integer id){
        Optional<LevelHigher> levelHigherOptional= levelHigherRespository.findById(id);
        if(!levelHigherOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        LevelHigher levelHigherTemporal = levelHigherOptional.get();
        levelHigherTemporal.setNameCareer(levelHigher.getNameCareer());
        levelHigherTemporal.setKeyCareer(levelHigher.getKeyCareer());
        levelHigherTemporal.setNivelEducativo(levelHigher.getNivelEducativo());
        levelHigherTemporal.setImg(levelHigher.getImg());
        levelHigherTemporal.setPdf(levelHigher.getPdf());
        levelHigherTemporal.setSchool(levelHigher.getSchool());
        levelHigherRespository.save(levelHigherTemporal);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<LevelHigher> deleteLevelHigher(Integer id){
        Optional<LevelHigher> levelHigherOptional= levelHigherRespository.findById(id);
        if(!levelHigherOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        levelHigherRespository.deleteById(levelHigherOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
