package com.descartes_api.service;

import com.descartes_api.model.School;
import com.descartes_api.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> listSchool(){
        return schoolRepository.findAll();
    }

    public ResponseEntity<School> listSchoolId(Integer id){
        try {
            School school = schoolRepository.findById(id).get();
            return new ResponseEntity<School>(school, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<School>(HttpStatus.NOT_FOUND);
        }
    }

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public ResponseEntity<School> putSchool(School school, Integer id) {
        Optional<School> schoolOptional = schoolRepository.findById(id);
        if(!schoolOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        School schoolPut= schoolOptional.get();
        schoolPut.setName(school.getName());
        schoolPut.setKeySchool(school.getKeySchool());
        schoolPut.setLevelBasics(school.getLevelBasics());
        schoolPut.setLevelHighers(school.getLevelHighers());
        schoolPut.setLevelUpperMiddles(school.getLevelUpperMiddles());
        schoolPut.setAdministratives(school.getAdministratives());
        schoolRepository.save(schoolPut);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<School>  deleteSchoolId(Integer id){
        Optional<School> schoolOptional = schoolRepository.findById(id);
        if(!schoolOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        schoolRepository.deleteById(schoolOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
