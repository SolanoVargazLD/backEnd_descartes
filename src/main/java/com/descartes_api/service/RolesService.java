package com.descartes_api.service;

import com.descartes_api.model.Roles;
import com.descartes_api.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> listRoles(){
        return rolesRepository.findAll();
    }

    public ResponseEntity<Roles> listRolesId(Integer id){
        try {
            Roles rolesTemp= rolesRepository.findById(id).get();
            return new ResponseEntity<Roles>(rolesTemp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
        }
    }

    public Roles saveRoles(Roles roles) {
        return rolesRepository.save(roles);
    }

    public ResponseEntity<Roles> putRolesId(Roles roles, Integer id){
        Optional<Roles> rolesOptional= rolesRepository.findById(id);
        if (!rolesOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Roles rolesPut= rolesOptional.get();
        rolesPut.setRolesType(roles.getRolesType());
        rolesPut.setAdministratives(roles.getAdministratives());
        rolesRepository.save(rolesPut);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Roles> deleteRolId(Integer id){
        Optional<Roles> rolesOptional= rolesRepository.findById(id);
        if (!rolesOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        rolesRepository.deleteById(rolesOptional.get().getId());
        return ResponseEntity.noContent().build();
    }
}
