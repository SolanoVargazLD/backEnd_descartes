package com.descartes_api.controller;

import com.descartes_api.model.AspirantSuperior;
import com.descartes_api.service.AspirantSuperiorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/descartes")
public class AspirantSuperiosController {
    @Autowired
    private AspirantSuperiorService aspirantSuperiorService;

    @GetMapping("/aspirantSuperior")
    public List<AspirantSuperior> getAspirantSuperior(){
        return this.aspirantSuperiorService.listAspirantSuperior();
    }

    @GetMapping("/aspirantSuperior/{id}")
    public ResponseEntity<AspirantSuperior> getAspirantSuperiorId(@PathVariable Integer id){
        return this.aspirantSuperiorService.listAspirantSuperiorId(id);
    }

    @GetMapping("/aspirantSuperior/licenciatura/{nameCareer}")
    public List<?> getAspirantsByNivelEducativoAndNameCareer(@PathVariable String nameCareer) {
        return aspirantSuperiorService.findAspirantsByLevelHigherNameCareer(nameCareer);
    }


    @PostMapping("/aspirantSuperior")
    public ResponseEntity<AspirantSuperior> postAspirantSuperior(@RequestBody AspirantSuperior aspirantSuperior){
        AspirantSuperior aspirantSuperiorTemp= aspirantSuperiorService.saveAspirantSuperior(aspirantSuperior);
        return new ResponseEntity<>(aspirantSuperior, HttpStatus.CREATED);
    }

   @PutMapping("/aspirantSuperior/{id}")
   public ResponseEntity<AspirantSuperior> putAsirantSuperior(@RequestBody AspirantSuperior aspirantSuperior, @PathVariable Integer id ){
        return aspirantSuperiorService.putAspirantSuperior(aspirantSuperior, id);
   }

   @DeleteMapping("/aspirantSuperior/{id}")
    public ResponseEntity<AspirantSuperior> deleteAspirantSuperior(@PathVariable Integer id ){
        return this.aspirantSuperiorService.deleteAspirantSuperior(id);
   }
}
