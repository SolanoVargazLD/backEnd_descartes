package com.descartes_api.controller;

import com.descartes_api.model.AspirantBasic;
import com.descartes_api.service.AspirantBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/descartes/aspirantBasic")
public class AspirantBasicController {
    @Autowired
    private AspirantBasicService aspirantBasicService;

    @GetMapping
    public List<AspirantBasic> getAspirantBasic(){
        return this.aspirantBasicService.listAspirantBasic();
    }

    @GetMapping("/listNivelBasic")
    public List<?> getAspirantBasicNivel(@RequestParam("name") String name){
        return this.aspirantBasicService.listAspirantBasicNivel(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AspirantBasic> getAspirantBasicId(@PathVariable Integer id){
        return aspirantBasicService.listAspirantBasicId(id);
    }

    @PostMapping
    public ResponseEntity<Integer> postAspirantBasicId(@RequestBody AspirantBasic aspirantBasic){
        Integer savedAspirantBasicId = aspirantBasicService.saveAspirantBasic(aspirantBasic);
        return new ResponseEntity<>(savedAspirantBasicId, HttpStatus.CREATED); // Retorna el ID del AspirantBasic guardado
    }

    @PutMapping("/{id}")
    public ResponseEntity<AspirantBasic> putAspirantBasicId(@RequestBody AspirantBasic aspirantBasic, @PathVariable Integer id){
        return aspirantBasicService.putAspirantBasic(aspirantBasic, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AspirantBasic> deleteAspirantBasicId(@PathVariable Integer id){
        return aspirantBasicService.deleteAspirantBasic(id);
    }


    }
