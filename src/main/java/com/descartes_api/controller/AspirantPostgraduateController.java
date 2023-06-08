package com.descartes_api.controller;

import com.descartes_api.model.AspirantPostgraduate;
import com.descartes_api.service.AspirantPostgraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/descartes/aspirantPostgraduate")
public class AspirantPostgraduateController {
    @Autowired
    private AspirantPostgraduateService aspirantPostgraduateService;

    @GetMapping
    public List<AspirantPostgraduate> getAspirantPostgraduate() {
        return aspirantPostgraduateService.listAspirantPostgraduate();
    }

    @GetMapping("/especific")
    public List<?> findAspirantsByLevelHigherNameCareer(@RequestParam("nameCareer") String nameCareer, @RequestParam("nivelEducativo") String nivelEducativo) {
        return aspirantPostgraduateService.findAspirantsByLevelHigherNameCareer(nameCareer, nivelEducativo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AspirantPostgraduate> getAspirantPostgraduateId(@PathVariable Integer id) {
        return aspirantPostgraduateService.listAspirantPostgraduateId(id);
    }

    @PostMapping
    public ResponseEntity<AspirantPostgraduate> postAspirantPostgraduate(@RequestBody AspirantPostgraduate aspirantPostgraduate){
        AspirantPostgraduate aspirantPostgraduateTemp= aspirantPostgraduateService.saveAspirantPosgraduate(aspirantPostgraduate);
        return new ResponseEntity<>(aspirantPostgraduateTemp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AspirantPostgraduate> putAspirantPostgraduate(@RequestBody AspirantPostgraduate aspirantPostgraduate, @PathVariable Integer id) {
        return aspirantPostgraduateService.putAspirantPosgraduate(aspirantPostgraduate,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AspirantPostgraduate> deleteAspirant(@PathVariable Integer id) {
        return aspirantPostgraduateService.deleteAspirantPosgraduate(id);
    }


}

