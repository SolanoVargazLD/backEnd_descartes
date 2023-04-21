package com.descartes_api.controller;

import com.descartes_api.model.Administrative;
import com.descartes_api.service.AdministrativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/descartes")
public class AdministrativeController {
    @Autowired
    private AdministrativeService administrativeService;

    @GetMapping("/administrative")
    public List<Administrative> getAdministrative(){
        return administrativeService.listAdministrative();
    }

    @GetMapping("/administrative/{id}")// ? Listar por ID
    public ResponseEntity<Administrative> getadministrativeID(@PathVariable Integer id){
        return administrativeService.listadministrativeId(id);
    }
    @PostMapping("/administrative")
    public ResponseEntity<Administrative> saveAdministrativeConRol(@RequestBody Administrative administrative) {
        Administrative administrativeTemp= administrativeService.saveAdministrative(administrative);
        return new ResponseEntity<Administrative>(administrativeTemp, HttpStatus.CREATED);
    }

    @PutMapping("/administrative/{id}")
    public ResponseEntity<Administrative> updateAdministrativeConRol(@RequestBody Administrative administrative, @PathVariable Integer id){
        return administrativeService.putAdministrativeId(administrative, id);
    }

    @DeleteMapping("/administrative/{id}")
    public ResponseEntity<Administrative> deleteAdministrative(@PathVariable Integer id){
        return administrativeService.deleteAdministrativeId(id);
    }
}
