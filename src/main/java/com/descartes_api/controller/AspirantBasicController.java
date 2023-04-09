package com.descartes_api.controller;

import com.descartes_api.model.AspirantBasic;
import com.descartes_api.service.AspirantBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descartes")
public class AspirantBasicController {
    @Autowired
    private AspirantBasicService aspirantBasicService;

    @GetMapping("/aspirantBasic")
    public List<AspirantBasic> getAspirantBasic(){
        return this.aspirantBasicService.listAspirantBasic();
    }

    @GetMapping("/aspirantBasic/{id}")
    public ResponseEntity<AspirantBasic> getAspirantBasicId(@PathVariable Integer id){
        return aspirantBasicService.listAspirantBasicId(id);
    }

    @PostMapping("/aspirantBasic")
    public ResponseEntity<AspirantBasic> postAspirantBasicId(@RequestBody AspirantBasic aspirantBasic){
        AspirantBasic aspirantBasicTemp = aspirantBasicService.saveAspirantBasic(aspirantBasic);
        return new ResponseEntity<>(aspirantBasicTemp, HttpStatus.CREATED);
    }

    @PutMapping("/aspirantBasic/{id}")
    public ResponseEntity<AspirantBasic> putAspirantBasicId(@RequestBody AspirantBasic aspirantBasic, @PathVariable Integer id){
        return aspirantBasicService.putAspirantBasic(aspirantBasic, id);
    }

    @DeleteMapping("/aspirantBasic/{id}")
    public ResponseEntity<AspirantBasic> deleteAspirantBasicId(@PathVariable Integer id){
        return aspirantBasicService.deleteAspirantBasic(id);
    }
}