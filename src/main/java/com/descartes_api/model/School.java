package com.descartes_api.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 75)
    private String name;

    @Column(name = "key_school", length =20)
    private String keySchool;

    @OneToMany( fetch = FetchType.EAGER,mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LevelHigher> levelHighers = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LevelBasic> levelBasics = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LevelUpperMiddle> levelUpperMiddles = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy="school")
    private Set<Administrative> administratives = new HashSet();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeySchool() {
        return keySchool;
    }

    public void setKeySchool(String keySchool) {
        this.keySchool = keySchool;
    }

    public Set<LevelHigher> getLevelHighers() {
        return levelHighers;
    }

    public void setLevelHighers(Set<LevelHigher> levelHighers) {
        this.levelHighers = levelHighers;
    }

    public Set<LevelBasic> getLevelBasics() {
        return levelBasics;
    }

    public void setLevelBasics(Set<LevelBasic> levelBasics) {
        this.levelBasics = levelBasics;
    }

    public Set<LevelUpperMiddle> getLevelUpperMiddles() {
        return levelUpperMiddles;
    }

    public void setLevelUpperMiddles(Set<LevelUpperMiddle> levelUpperMiddles) {
        this.levelUpperMiddles = levelUpperMiddles;
    }

    public Set<Administrative> getAdministratives() {
        return administratives;
    }

    public void setAdministratives(Set<Administrative> administratives) {
        this.administratives = administratives;
    }
}

