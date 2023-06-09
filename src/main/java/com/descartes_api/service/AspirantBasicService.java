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

    public List<?> listAspirantBasicNivel(String name){
        List<Object[]> aspirantBasicInfoList = aspirantBasicRepository.findAspirantsWithBasicNivel(name);
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

    public Integer saveAspirantBasic(AspirantBasic aspirantBasic)  {
        AspirantBasic savedAspirantBasic = aspirantBasicRepository.save(aspirantBasic);
        return savedAspirantBasic.getId(); // Retorna el ID del AspirantBasic guardado
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

    public List<AspirantBasic> listAspirantBasicXLXS(String name){
        return aspirantBasicRepository.findByLevelBasicName(name);
    }

    public AspirantBasic getAspirantBasicById(int id) {
        return aspirantBasicRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("AspirantBasic not found with id: " + id));
    }
}
