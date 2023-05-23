package com.descartes_api.service;

import com.descartes_api.model.AspirantBasic;
import com.descartes_api.repository.AspirantBasicRepository;
import com.descartes_api.repository.AspirantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AspirantBasicService {
    @Autowired
    private AspirantBasicRepository aspirantBasicRepository;

    @Autowired
    private AspirantRepository aspirantRepository;
    public List<AspirantBasic> listAspirantBasic(){
        return aspirantBasicRepository.findAll();
    }

    public List<?> listAspirantBasicPreescolar(){
        List<Object[]> aspirantBasicInfoList = aspirantBasicRepository.findAspirantsWithBasicInfoPreescolar();
        List<Map<String, Object>> aspirantBasicInfoMapList = new ArrayList<>();

        for (Object[] row : aspirantBasicInfoList) {
            Map<String, Object> aspirantBasicInfoMap = new HashMap<>();
            aspirantBasicInfoMap.put("id_asp", row[0]);
            aspirantBasicInfoMap.put("id", row[1]);
            aspirantBasicInfoMap.put("tip_asp", row[2]);
            aspirantBasicInfoMap.put("name", row[3]);
            aspirantBasicInfoMap.put("lastNameP", row[4]);
            aspirantBasicInfoMap.put("lastNameM", row[5]);
            aspirantBasicInfoMap.put("curp", row[6]);
            aspirantBasicInfoMapList.add(aspirantBasicInfoMap);
        }
        return aspirantBasicInfoMapList;
    }

    public List<?> listAspirantBasicPrimaria(){
        List<Object[]> aspirantBasicInfoList = aspirantBasicRepository.findAspirantsWithBasicInfoPrimaria();
        List<Map<String, Object>> aspirantBasicInfoMapList = new ArrayList<>();

        for (Object[] row : aspirantBasicInfoList) {
            Map<String, Object> aspirantBasicInfoMap = new HashMap<>();
            aspirantBasicInfoMap.put("id_asp", row[0]);
            aspirantBasicInfoMap.put("id", row[1]);
            aspirantBasicInfoMap.put("tip_asp", row[2]);
            aspirantBasicInfoMap.put("name", row[3]);
            aspirantBasicInfoMap.put("lastNameP", row[4]);
            aspirantBasicInfoMap.put("lastNameM", row[5]);
            aspirantBasicInfoMap.put("curp", row[6]);
            aspirantBasicInfoMapList.add(aspirantBasicInfoMap);
        }
        return aspirantBasicInfoMapList;
    }

    public List<?> listAspirantBasicSecundaria(){
        List<Object[]> aspirantBasicInfoList = aspirantBasicRepository.findAspirantsWithBasicInfosecundaria();
        List<Map<String, Object>> aspirantBasicInfoMapList = new ArrayList<>();

        for (Object[] row : aspirantBasicInfoList) {
            Map<String, Object> aspirantBasicInfoMap = new HashMap<>();
            aspirantBasicInfoMap.put("id_asp", row[0]);
            aspirantBasicInfoMap.put("id", row[1]);
            aspirantBasicInfoMap.put("tip_asp", row[2]);
            aspirantBasicInfoMap.put("name", row[3]);
            aspirantBasicInfoMap.put("lastNameP", row[4]);
            aspirantBasicInfoMap.put("lastNameM", row[5]);
            aspirantBasicInfoMap.put("curp", row[6]);
            aspirantBasicInfoMapList.add(aspirantBasicInfoMap);
        }
        return aspirantBasicInfoMapList;
    }

    public ResponseEntity<AspirantBasic> listAspirantBasicId(Integer id){
        try{
            AspirantBasic aspirantBasic =aspirantBasicRepository.findById(id).get();
            return new ResponseEntity<AspirantBasic>(aspirantBasic, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<AspirantBasic>(HttpStatus.NOT_FOUND);
        }
    }

    public AspirantBasic saveAspirantBasic(AspirantBasic aspirantBasic)  {
        Optional<AspirantBasic> aspirantOptional= aspirantBasicRepository.findByAspirantId(aspirantBasic.getAspirant().getId());
        if (aspirantOptional.isPresent()) {
            return null;
        }
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
