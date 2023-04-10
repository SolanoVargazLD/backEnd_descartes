package com.descartes_api.service;

import com.descartes_api.model.AspirantPostgraduate;
import com.descartes_api.repository.AspirantPostgraduateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<AspirantPostgraduate> putAspirantPosgraduate(AspirantPostgraduate aspirantPostgraduate, Integer id) {
        Optional<AspirantPostgraduate> aspirantPostgraduateOptional = aspirantPostgraduateRepository.findById(id);
        if (!aspirantPostgraduateOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        AspirantPostgraduate aspirantPostgraduatePut = aspirantPostgraduateOptional.get();
        aspirantPostgraduatePut.setProfessionalLicense(aspirantPostgraduate.getProfessionalLicense());
        aspirantPostgraduatePut.setEmail(aspirantPostgraduate.getEmail());
        aspirantPostgraduatePut.setPhone(aspirantPostgraduate.getPhone());
        aspirantPostgraduatePut.setAspirant(aspirantPostgraduate.getAspirant());
        aspirantPostgraduatePut.setLevelHigher(aspirantPostgraduate.getLevelHigher());
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
}
