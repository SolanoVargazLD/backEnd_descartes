package com.descartes_api.controller;

import com.descartes_api.model.LevelBasic;
import com.descartes_api.service.LevelBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descartes")
public class LevelBasicController {
    @Autowired
    private LevelBasicService levelBasicService;

    @GetMapping("/levelBasic")
    public List<LevelBasic> getLevelBasic(){
        return levelBasicService.listLevelBasic();
    }

    @GetMapping("/levelBasic/{id}")
    public ResponseEntity<LevelBasic> getLevelBasicId(@PathVariable Integer id){
        return levelBasicService.listLevelBasicId(id);
    }

    @PostMapping("/levelBasic")
    public ResponseEntity<LevelBasic> saveLevelBasic(@RequestBody LevelBasic levelBasic){
        LevelBasic levelBasicSave = levelBasicService.saveLevelBasic(levelBasic);
        return new ResponseEntity<>(levelBasicSave, HttpStatus.CREATED);
    }

    @PutMapping("/levelBasic/{id}")
    public ResponseEntity<LevelBasic> putLevelBasic(@RequestBody LevelBasic levelBasic, @PathVariable Integer id){
        return  levelBasicService.putLevelBasic(levelBasic, id);
    }

    @DeleteMapping("/levelBasic/{id}")
    public ResponseEntity<LevelBasic> delelteLevelBasic(@PathVariable Integer id){
        return  levelBasicService.deleteLevelBasic(id);
    }
}
