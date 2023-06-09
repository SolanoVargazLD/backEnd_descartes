package com.descartes_api.service;

import com.descartes_api.model.Aspirant;
import com.descartes_api.repository.AspirantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AspirantService {

    @Autowired
    private AspirantRepository aspirantRepository;

    public List<Aspirant> listAspirant() {
        return aspirantRepository.findAll();
    }

    public ResponseEntity<Aspirant> listAspirantId(Integer id) {
        try {
            Aspirant aspirantTemp = aspirantRepository.findById(id).get();
            return new ResponseEntity<Aspirant>(aspirantTemp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Aspirant>(HttpStatus.NOT_FOUND);
        }
    }

    public Aspirant saveAspirant(Aspirant aspirant) {
        return aspirantRepository.save(aspirant);
    }

    public ResponseEntity<Aspirant> putAspirant(Aspirant aspirant, Integer id) {
        Optional<Aspirant> aspirantOptional = aspirantRepository.findById(id);
        if (!aspirantOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Aspirant aspirantPut= aspirantOptional.get();
        aspirantPut.setName(aspirant.getName());
        aspirantPut.setLastNameP(aspirant.getLastNameP());
        aspirantPut.setLastNameM(aspirant.getLastNameM());
        aspirantPut.setCurp(aspirant.getCurp());
        aspirantPut.setBloodType(aspirant.getBloodType());
        aspirantPut.setConditionS(aspirant.getConditionS());
        aspirantPut.setSex(aspirant.getSex());
        aspirantPut.setAspirantBasic(aspirant.getAspirantBasic());
        aspirantPut.setAspirantBachillerate(aspirant.getAspirantBachillerate());
        aspirantPut.setAspirantSuperior(aspirant.getAspirantSuperior());
        aspirantPut.setAspirantPostgraduate(aspirant.getAspirantPostgraduate());
        aspirantPut.setFatherTutor(aspirant.getFatherTutor());
        aspirantPut.setAddress(aspirant.getAddress());
        aspirantRepository.save(aspirantPut);
        return ResponseEntity.noContent().build();
    }

    public boolean deleteAspirantId(Integer id) {
        Optional<Aspirant> aspirantOptional = aspirantRepository.findById(id);
        if (!aspirantOptional.isPresent()) {
            return false;
        }
        aspirantRepository.deleteById(aspirantOptional.get().getId());
        return true;
    }
}
