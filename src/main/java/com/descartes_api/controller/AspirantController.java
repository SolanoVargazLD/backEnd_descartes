package com.descartes_api.controller;

import com.descartes_api.model.Aspirant;
import com.descartes_api.service.AspirantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/descartes/aspirants")
public class AspirantController {

    @Autowired
    private AspirantService aspirantService;

    @GetMapping
    public List<Aspirant> getAllAspirants() {
        return aspirantService.listAspirant();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aspirant> getAspirantById(@PathVariable int id) {
        return aspirantService.listAspirantId(id);
    }

    @PostMapping
    public ResponseEntity<Aspirant> createAspirant(@RequestBody Aspirant aspirant) {
        Aspirant savedAspirant = aspirantService.saveAspirant(aspirant);
        return new ResponseEntity<>(savedAspirant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aspirant> updateAspirant(@PathVariable Integer id, @RequestBody Aspirant aspirant) {
        return aspirantService.putAspirant(aspirant, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aspirant> deleteAspirantById(@PathVariable Integer id) {
        return aspirantService.deleteAspirantId(id);
    }
}
