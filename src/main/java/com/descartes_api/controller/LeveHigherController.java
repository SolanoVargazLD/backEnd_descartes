package com.descartes_api.controller;

import com.descartes_api.model.LevelHigher;
import com.descartes_api.service.LevelHigherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descartes")
public class LeveHigherController {
    @Autowired
    private LevelHigherService levelHigherService;

    @GetMapping("/levelHigher")
    public List<LevelHigher> getLevelHigher(){
        return levelHigherService.listLevelHigher();
    }

    @GetMapping("/levelHigher/{id}")
    public ResponseEntity<LevelHigher> getLevelHigherId(@PathVariable Integer id){
        return levelHigherService.listLevelHigherID(id);
    }

    @PostMapping("/levelHigher")
    public ResponseEntity<LevelHigher> postLevelHigher(@RequestBody LevelHigher levelHigher){
        LevelHigher levelHigherSave = levelHigherService.saveLevelHigher(levelHigher);
        return new ResponseEntity<>(levelHigherSave, HttpStatus.CREATED);
    }

    @PutMapping("/levelHigher/{id}")
    public ResponseEntity<LevelHigher> putLevelHigher(@RequestBody LevelHigher levelHigher, @PathVariable Integer id){
        return levelHigherService.putLevelHigher(levelHigher, id);
    }

    @DeleteMapping("/levelHigher/{id}")
    public ResponseEntity<LevelHigher> deleteLevelHigher(@PathVariable Integer id){
        return levelHigherService.deleteLevelHigher(id);
    }
}
