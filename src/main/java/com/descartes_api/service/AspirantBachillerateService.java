package com.descartes_api.service;

import com.descartes_api.model.AspirantBachillerate;
import com.descartes_api.repository.AspirantBachillerateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

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
        Optional<AspirantBachillerate> aspirantOptional= aspirantBachillerateRepository.findByAspirantId(aspirantBachillerate.getAspirant().getId());
        if (aspirantOptional.isPresent()) {
            return null;
        }
        return aspirantBachillerateRepository.save(aspirantBachillerate);
    }

    public List<?> listAspirantBaachillerateM(){
        List<Object[]> aspirantBachillerateInfoList = aspirantBachillerateRepository.findAspirantsWithBachillerateInfo();
        List<Map<String, Object>> aspirantBachillerateInfoMapList = new ArrayList<>();

        for (Object[] row : aspirantBachillerateInfoList) {
            Map<String, Object> aspirantBachillerateInfoMap = new HashMap<>();
            aspirantBachillerateInfoMap.put("id_bachillerate", row[0]);
            aspirantBachillerateInfoMap.put("id_asp", row[1]);
            aspirantBachillerateInfoMap.put("tip_asp", row[2]);
            aspirantBachillerateInfoMap.put("name", row[3]);
            aspirantBachillerateInfoMap.put("lastNameP", row[4]);
            aspirantBachillerateInfoMap.put("lastNameM", row[5]);
            aspirantBachillerateInfoMap.put("curp", row[6]);
            aspirantBachillerateInfoMapList.add(aspirantBachillerateInfoMap);
        }
        return aspirantBachillerateInfoMapList;
    }

    public boolean putAspirantBachillerate(AspirantBachillerate aspirantBachillerate, Integer id){
        Optional<AspirantBachillerate> aspirantBachillerateOptional= aspirantBachillerateRepository.findById(id);
        if (!aspirantBachillerateOptional.isPresent()){
            return false;
        }
        AspirantBachillerate aspirantBachillerateTemp= aspirantBachillerateOptional.get();
        aspirantBachillerateTemp.setSchoolOrigin(aspirantBachillerate.getSchoolOrigin());
        aspirantBachillerateTemp.setPhone(aspirantBachillerate.getPhone());
        aspirantBachillerateTemp.setEmail(aspirantBachillerate.getEmail());
        /*aspirantBachillerateTemp.setAspirant(aspirantBachillerate.getAspirant());
        aspirantBachillerateTemp.setLevelUpperMiddle(aspirantBachillerate.getLevelUpperMiddle());*/
        aspirantBachillerateRepository.save(aspirantBachillerateTemp);
        return true;
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
