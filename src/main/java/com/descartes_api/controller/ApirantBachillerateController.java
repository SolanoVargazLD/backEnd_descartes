package com.descartes_api.controller;

import com.descartes_api.model.AspirantBachillerate;
import com.descartes_api.service.AspirantBachillerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descartes")
public class ApirantBachillerateController {
    @Autowired
    private AspirantBachillerateService aspirantBachillerateService;

    @GetMapping("/aspirantBachillerate")
    public List<AspirantBachillerate> getAspirantBachillerate(){
        return aspirantBachillerateService.listAspirantBachillerates();
    }

    @GetMapping("/aspirantBachillerate/{id}")
    public ResponseEntity<AspirantBachillerate> getAspirantBachillerateId(@PathVariable Integer id){
        return aspirantBachillerateService.listAspirantBachillerateId(id);
    }

    @PostMapping("/aspirantBachillerate")
    public ResponseEntity<AspirantBachillerate> postAspirantBachillerate(@RequestBody AspirantBachillerate aspirantBachillerate){
        AspirantBachillerate aspirantBachillerateTemp= aspirantBachillerateService.postAspirantBachillerate(aspirantBachillerate);
        return new ResponseEntity<>(aspirantBachillerateTemp, HttpStatus.CREATED);
    }

    @PutMapping("/aspirantBachillerate/{id}")
    public  ResponseEntity<AspirantBachillerate> putAspirantBachillerateId(@RequestBody AspirantBachillerate aspirantBachillerate,@PathVariable Integer id ){
        return aspirantBachillerateService.putAspirantBachillerate(aspirantBachillerate,id);
    }

    @DeleteMapping("/aspirantBachillerate/{id}")
    public ResponseEntity<AspirantBachillerate> deleteAspirantBachillerateId(@PathVariable Integer id){
        return  aspirantBachillerateService.deleteAspirantBachillerate(id);
    }
}
