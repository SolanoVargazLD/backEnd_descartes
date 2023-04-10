package com.descartes_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "roles_type", length = 30)
    private String rolesType;

    @OneToMany(mappedBy = "roles", fetch = FetchType. EAGER)
    private Set<Administrative> administratives= new HashSet<>();

    /*public void setAdministratives(Set<Administrative> administratives) {
        this.administratives = administratives;
        for (Administrative administrative:administratives)
            administrative.setRoles(this);//? Contexto del Trabajo
    }*/
}
