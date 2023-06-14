package com.descartes_api.service;

import com.descartes_api.model.AspirantBasic;
import com.descartes_api.model.AspirantPostgraduate;
import com.descartes_api.model.AspirantSuperior;
import com.descartes_api.repository.AspirantSuperiorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<?> findAspirantsByLevelHigherNameCareer(String nameCareer) {
        List<Object[]> aspirantSuperiorInfoList = aspirantSuperiorRepository.findAspirantsByLevelHigherNameCareer(nameCareer);
        List<Map<String, Object>> aspirantSuperiorInfoMapList = new ArrayList<>();

        for (Object[] row : aspirantSuperiorInfoList) {
            Map<String, Object> aspirantSuperioriInfoMap = new HashMap<>();
            aspirantSuperioriInfoMap.put("id_asp_licenciature", row[0]);
            aspirantSuperioriInfoMap.put("id_asp", row[1]);
            aspirantSuperioriInfoMap.put("tip_asp", row[2]);
            aspirantSuperioriInfoMap.put("name", row[3]);
            aspirantSuperioriInfoMap.put("lastNameP", row[4]);
            aspirantSuperioriInfoMap.put("lastNameM", row[5]);
            aspirantSuperioriInfoMap.put("curp", row[6]);
            aspirantSuperiorInfoMapList.add(aspirantSuperioriInfoMap);
        }
        return aspirantSuperiorInfoMapList;
    }

    public Integer saveAspirantSuperior(AspirantSuperior aspirantSuperior){
        AspirantSuperior aspirantOptional= aspirantSuperiorRepository.save(aspirantSuperior);
        return aspirantOptional.getId();
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
        /*aspirantSuperiorTemp.setLevelHigher(aspirantSuperior.getLevelHigher());
        aspirantSuperiorTemp.setAspirant(aspirantSuperior.getAspirant());*/
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

    public List<AspirantSuperior> listAspirantSuperiorPorProfecion(String nameCareer){
        return aspirantSuperiorRepository.findByLevelHigherNivelEducativoAndLevelHigherNameCareer("Licenciatura", nameCareer);
    }

    public AspirantSuperior getAspirantBasicById(int id) {
        return aspirantSuperiorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("AspirantSuperior not found with id: " + id));
    }

}
