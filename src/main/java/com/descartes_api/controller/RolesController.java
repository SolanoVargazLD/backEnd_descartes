package com.descartes_api.controller;

import com.descartes_api.model.Roles;
import com.descartes_api.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/descartes")
@CrossOrigin
public class RolesController {

    @Autowired
    private RolesService rolesService;


    @GetMapping("/roles")
    public List<Roles> getRoles() {
        return rolesService.listRoles();
    }

    @GetMapping("/roles/{id}")// ? Listar por ID
    public ResponseEntity<Roles> getSchoolID(@PathVariable Integer id){
        return  rolesService.listRolesId(id);
    }

    @PostMapping("/roles")
    public ResponseEntity<Roles> SaveRoles(@RequestBody Roles roles){
        Roles rolesTemp= rolesService.saveRoles(roles);
        return new ResponseEntity<>(rolesTemp, HttpStatus.CREATED);
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Roles> updateRoles(@RequestBody Roles roles, @PathVariable Integer id) {
        return rolesService.putRolesId(roles, id);
    }

    @DeleteMapping("/roles/{id}") //? Eliminar un rol en base a su ID
    public ResponseEntity<Roles> deleteRol(@PathVariable Integer id){
        return rolesService.deleteRolId(id);
    }
}
