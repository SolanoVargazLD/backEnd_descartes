package com.descartes_api.controller;

import com.descartes_api.model.LevelBasic;
import com.descartes_api.model.LevelUpperMiddle;
import com.descartes_api.service.LevelUpperMiddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descartes")
public class LevelUpperController {
    @Autowired
    private LevelUpperMiddleService levelUpperMiddleService;

    @GetMapping("/levelUpper")
    public List<LevelUpperMiddle> getLevelUpper(){
        return levelUpperMiddleService.listLevelUpperMiddle();
    }

    @GetMapping("/levelUpper/{id}")
    public ResponseEntity<LevelUpperMiddle> getLevelUpperID(@PathVariable Integer id){
        return levelUpperMiddleService.listLevelUpperMiddleID(id);
    }

    @PostMapping("/levelUpper")
    public ResponseEntity<LevelUpperMiddle> savaLevelUpperMiddle(@RequestBody LevelUpperMiddle levelUpperMiddle){
        LevelUpperMiddle levelUpperMiddleSave = levelUpperMiddleService.saveLevelUpperMiddle(levelUpperMiddle);
        return new ResponseEntity<>(levelUpperMiddleSave, HttpStatus.CREATED);
    }

    @PutMapping("/levelUpper/{id}")
    public ResponseEntity<LevelUpperMiddle> putLevelUpper(@RequestBody LevelUpperMiddle levelUpper, @PathVariable Integer id){
        return levelUpperMiddleService.putlevelUpper(levelUpper, id);
    }

    @DeleteMapping("/levelUpper/{id}")
    public ResponseEntity<LevelUpperMiddle> deleteLevelUpper(@PathVariable Integer id){
        return levelUpperMiddleService.deleteLevelUpper(id);
    }
}
