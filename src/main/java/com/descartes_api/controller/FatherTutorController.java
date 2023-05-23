package com.descartes_api.controller;

import com.descartes_api.model.FatherTutor;
import com.descartes_api.service.FatherTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/descartes")
public class FatherTutorController {

    @Autowired
    private FatherTutorService fatherTutorService;

    @GetMapping("/fatherTutors")
    public List<FatherTutor> getFatherTutors() {
        return fatherTutorService.listFatherTutors();
    }

    @GetMapping("/fatherTutors/{id}")// ? Listar por ID
    public ResponseEntity<FatherTutor> getFatherTutorsID(@PathVariable Integer id){
        return fatherTutorService.listFatherTutorId(id);
    }

    @PostMapping("/fatherTutors")
    public ResponseEntity<FatherTutor> SaveFatherTutors(@RequestBody FatherTutor fatherTutor){
        FatherTutor fatherTutorTemp= fatherTutorService.saveFatherTutor(fatherTutor);
        return new ResponseEntity<>(fatherTutorTemp, HttpStatus.CREATED);
    }

    @PutMapping("/fatherTutors/{id}")
    public ResponseEntity<FatherTutor> updateFatherTutors(@RequestBody FatherTutor fatherTutor, @PathVariable Integer id) {
        return fatherTutorService.putFatherTutor(fatherTutor, id);
    }

    @DeleteMapping("/fatherTutors/{id}")
    public ResponseEntity<FatherTutor> deleteFatherTutors(@PathVariable Integer id){
        return fatherTutorService.deleteFatherTutorId(id);
    }
}
