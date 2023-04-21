package com.descartes_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 75)
    private String name;

    @Column(name = "key_school", length = 20)
    private String keySchool;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<LevelBasic> levelBasics = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<LevelHigher> levelHighers = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<LevelUpperMiddle> levelUpperMiddles = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "school")
    @JsonIgnore
    private Set<Administrative> administratives = new HashSet();

}