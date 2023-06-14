package com.descartes_api.controller;

import com.descartes_api.model.AspirantBachillerate;
import com.descartes_api.service.AspirantBachillerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/descartes/aspirantBachillerate")
public class ApirantBachillerateController {
    @Autowired
    private AspirantBachillerateService aspirantBachillerateService;

    @GetMapping
    public List<AspirantBachillerate> getAspirantBachillerate(){
        return aspirantBachillerateService.listAspirantBachillerates();
    }

    @GetMapping("/listBachillerate")
    public List<?> getListAspirantBachillerate(){
        return this.aspirantBachillerateService.listAspirantBaachillerateM();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AspirantBachillerate> getAspirantBachillerateId(@PathVariable Integer id){
        return aspirantBachillerateService.listAspirantBachillerateId(id);
    }


    @PostMapping
    public ResponseEntity<Integer> postAspirantBachillerate(@RequestBody AspirantBachillerate aspirantBachillerate){
        Integer savedAspirantBachillerId = aspirantBachillerateService.postAspirantBachillerate(aspirantBachillerate);
        return new ResponseEntity<>(savedAspirantBachillerId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  boolean putAspirantBachillerateId(@RequestBody AspirantBachillerate aspirantBachillerate,@PathVariable Integer id ){
        return aspirantBachillerateService.putAspirantBachillerate(aspirantBachillerate,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AspirantBachillerate> deleteAspirantBachillerateId(@PathVariable Integer id){
        return  aspirantBachillerateService.deleteAspirantBachillerate(id);
    }
}
