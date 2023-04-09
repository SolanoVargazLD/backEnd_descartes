package com.descartes_api.controller;

import com.descartes_api.model.Address;
import com.descartes_api.model.Aspirant;
import com.descartes_api.model.FatherTutor;
import com.descartes_api.model.School;
import com.descartes_api.service.AddressService;
import com.descartes_api.service.AspirantService;
import com.descartes_api.service.FatherTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/descartes")
public class AspirantController {

    @Autowired
    private AspirantService aspirantService;

    @GetMapping("/aspirants")
    public List<Aspirant> getAllAspirants() {
        return aspirantService.listAspirant();
    }

    @GetMapping("/aspirants/{id}")
    public ResponseEntity<Aspirant> getAspirantById(@PathVariable int id) {
        return aspirantService.listAspirantId(id);
    }

    @PostMapping("/aspirants")
    public ResponseEntity<Aspirant> createAspirant(@RequestBody Aspirant aspirant) {
        Aspirant savedAspirant = aspirantService.saveAspirant(aspirant);
        return new ResponseEntity<>(savedAspirant, HttpStatus.CREATED);
    }

    @PutMapping("/aspirants/{id}")
    public ResponseEntity<Aspirant> updateAspirant(@PathVariable Integer id, @RequestBody Aspirant aspirant) {
        return aspirantService.putAspirant(aspirant, id);
    }

    @DeleteMapping("/aspirants/{id}")
    public ResponseEntity<Aspirant> deleteAspirantById(@PathVariable Integer id) {
        return aspirantService.deleteAspirantId(id);
    }
}
