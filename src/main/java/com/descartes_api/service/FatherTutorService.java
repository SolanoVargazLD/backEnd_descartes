package com.descartes_api.service;

import com.descartes_api.model.FatherTutor;
import com.descartes_api.repository.FatherTutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FatherTutorService {
    @Autowired
    private FatherTutorRepository fatherTutorRepository;

    public List<FatherTutor> listFatherTutors(){
        return fatherTutorRepository.findAll();
    }

    public ResponseEntity<FatherTutor> listFatherTutorId(Integer id){
        try {
            FatherTutor fatherTutorTemp= fatherTutorRepository.findById(id).get();
            return new ResponseEntity<FatherTutor>(fatherTutorTemp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<FatherTutor>(HttpStatus.NOT_FOUND);
        }
    }

    public FatherTutor saveFatherTutor(FatherTutor fatherTutor) {
        return fatherTutorRepository.save(fatherTutor);
    }

    public ResponseEntity<FatherTutor> putFatherTutor(FatherTutor fatherTutor, Integer id){
        Optional<FatherTutor> fatherTutorOptional= fatherTutorRepository.findById(id);
        if(!fatherTutorOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        FatherTutor fatherTutorPut= fatherTutorOptional.get();
        fatherTutorPut.setName(fatherTutor.getName());
        fatherTutorPut.setLastNameP(fatherTutor.getLastNameP());
        fatherTutorPut.setLastNameM(fatherTutor.getLastNameM());
        fatherTutorPut.setPhone1(fatherTutor.getPhone1());
        fatherTutorPut.setPhone2(fatherTutor.getPhone2());
        fatherTutorPut.setEmail(fatherTutor.getEmail());
        fatherTutorPut.setAspirant(fatherTutor.getAspirant());
        fatherTutorRepository.save(fatherTutorPut);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<FatherTutor> deleteFatherTutorId(Integer id){
        Optional<FatherTutor> fatherTutorOptional= fatherTutorRepository.findById(id);
        if(!fatherTutorOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        fatherTutorRepository.deleteById(fatherTutorOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
