package com.descartes_api.service;

import com.descartes_api.model.AspirantPostgraduate;
import com.descartes_api.repository.AspirantPostgraduateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AspirantPostgraduateService {
    @Autowired
    private AspirantPostgraduateRepository aspirantPostgraduateRepository;

    public List<AspirantPostgraduate> listAspirantPostgraduate() {
        return aspirantPostgraduateRepository.findAll();
    }

    public ResponseEntity<AspirantPostgraduate> listAspirantPostgraduateId(Integer id) {
        try {
            AspirantPostgraduate aspirantPostgraduateTemp = aspirantPostgraduateRepository.findById(id).get();
            return new ResponseEntity<AspirantPostgraduate>(aspirantPostgraduateTemp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<AspirantPostgraduate>(HttpStatus.NOT_FOUND);
        }
    }

    public AspirantPostgraduate saveAspirantPosgraduate(AspirantPostgraduate aspirantPostgraduate) {
        Optional<AspirantPostgraduate> aspirantOptional= aspirantPostgraduateRepository.findByAspirantId(aspirantPostgraduate.getAspirant().getId());
        if (aspirantOptional.isPresent()) {
            return null;
        }
        return aspirantPostgraduateRepository.save(aspirantPostgraduate);
    }

    public List<?> findAspirantsByLevelHigherNameCareer(String nameCareer, String nivelEducativo) {
        List<Object[]> aspirantPostInfoList = aspirantPostgraduateRepository.findAspirantsByLevelHigherNameCareerPosgraduate(nameCareer, nivelEducativo);
        List<Map<String, Object>> aspirantPostInfoMapList = new ArrayList<>();

        for (Object[] row : aspirantPostInfoList) {
            Map<String, Object> aspirantPostiInfoMap = new HashMap<>();
            aspirantPostiInfoMap.put("id_asp_posgrado", row[0]);
            aspirantPostiInfoMap.put("id_asp", row[1]);
            aspirantPostiInfoMap.put("tip_asp", row[2]);
            aspirantPostiInfoMap.put("name", row[3]);
            aspirantPostiInfoMap.put("lastNameP", row[4]);
            aspirantPostiInfoMap.put("lastNameM", row[5]);
            aspirantPostiInfoMap.put("cedula", row[6]);
            aspirantPostInfoMapList.add(aspirantPostiInfoMap);
        }
        return aspirantPostInfoMapList;
    }

    public ResponseEntity<AspirantPostgraduate> putAspirantPosgraduate(AspirantPostgraduate aspirantPostgraduate, Integer id) {
        Optional<AspirantPostgraduate> aspirantPostgraduateOptional = aspirantPostgraduateRepository.findById(id);
        if (!aspirantPostgraduateOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        AspirantPostgraduate aspirantPostgraduatePut = aspirantPostgraduateOptional.get();
        aspirantPostgraduatePut.setProfessionalLicense(aspirantPostgraduate.getProfessionalLicense());
        aspirantPostgraduatePut.setEmail(aspirantPostgraduate.getEmail());
        aspirantPostgraduatePut.setPhone(aspirantPostgraduate.getPhone());
        /*aspirantPostgraduatePut.setAspirant(aspirantPostgraduate.getAspirant());
        aspirantPostgraduatePut.setLevelHigher(aspirantPostgraduate.getLevelHigher());*/
        aspirantPostgraduateRepository.save(aspirantPostgraduatePut);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<AspirantPostgraduate> deleteAspirantPosgraduate(Integer id) {
        Optional<AspirantPostgraduate> aspirantPostgraduateOptional = aspirantPostgraduateRepository.findById(id);
        if (!aspirantPostgraduateOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        aspirantPostgraduateRepository.deleteById(aspirantPostgraduateOptional.get().getId());
        return ResponseEntity.noContent().build();
    }

    public List<AspirantPostgraduate> listAspirantSuperiorPorPosgrado(String nivelEducativo, String nameCareer) {
        return aspirantPostgraduateRepository.findByLevelHigherNivelEducativoAndLevelHigherNameCareer(nivelEducativo, nameCareer);
    }


}
