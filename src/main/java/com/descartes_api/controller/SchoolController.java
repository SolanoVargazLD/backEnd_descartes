package com.descartes_api.controller;

import com.descartes_api.model.School;
import com.descartes_api.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/descartes")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/school") //? Listar todos
    public List<School> getSchool(){
        return schoolService.listSchool();
    }

    @GetMapping("/school/{id}")// ? Listar por ID
    public ResponseEntity<School> getSchoolID(@PathVariable Integer id){
        return schoolService.listSchoolId(id);
    }

    @PostMapping("/school")
    public ResponseEntity<School> saveSchool(@RequestBody School school){
        School schoolTemp= schoolService.saveSchool(school);
        return new ResponseEntity<>(schoolTemp, HttpStatus.CREATED);
    }

    @PutMapping("/school/{id}")
    public ResponseEntity<School> updateSchool(@RequestBody School school, @PathVariable Integer id) {
        return schoolService.putSchool(school, id);
    }

    @DeleteMapping("/school/{id}") //? Eliminar una School en base a su ID
    public ResponseEntity<School> deleteSchool(@PathVariable Integer id){
        return schoolService.deleteSchoolId(id);
    }
}
