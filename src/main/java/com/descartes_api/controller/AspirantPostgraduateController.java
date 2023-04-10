package com.descartes_api.controller;

import com.descartes_api.model.AspirantPostgraduate;
import com.descartes_api.service.AspirantPostgraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descartes")
public class AspirantPostgraduateController {
    @Autowired
    private AspirantPostgraduateService aspirantPostgraduateService;

    @GetMapping("/aspirantPostgraduate")
    public List<AspirantPostgraduate> getAspirantPostgraduate() {
        return aspirantPostgraduateService.listAspirantPostgraduate();
    }

    @GetMapping("/aspirantPostgraduate/{id}")
    public ResponseEntity<AspirantPostgraduate> getAspirantPostgraduateId(@PathVariable Integer id) {
        return aspirantPostgraduateService.listAspirantPostgraduateId(id);
    }

    @PostMapping("/aspirantPostgraduate")
    public ResponseEntity<AspirantPostgraduate> postAspirantPostgraduate(@RequestBody AspirantPostgraduate aspirantPostgraduate){
        AspirantPostgraduate aspirantPostgraduateTemp= aspirantPostgraduateService.saveAspirantPosgraduate(aspirantPostgraduate);
        return new ResponseEntity<>(aspirantPostgraduateTemp, HttpStatus.CREATED);
    }

    @PutMapping("/aspirantPostgraduate/{id}")
    public ResponseEntity<AspirantPostgraduate> putAspirantPostgraduate(@RequestBody AspirantPostgraduate aspirantPostgraduate, @PathVariable Integer id) {
        return aspirantPostgraduateService.putAspirantPosgraduate(aspirantPostgraduate,id);
    }

    @DeleteMapping("/aspirantPostgraduate/{id}")
    public ResponseEntity<AspirantPostgraduate> deleteAspirant(@PathVariable Integer id) {
        return aspirantPostgraduateService.deleteAspirantPosgraduate(id);
    }
}

