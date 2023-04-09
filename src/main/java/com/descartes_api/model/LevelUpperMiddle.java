package com.descartes_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "level_upper_middle")
public class LevelUpperMiddle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "level", length = 50)
    private String level;

    @Column(name = "img")
    private String img;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "levelUpperMiddle")
    private Set<AspirantBachillerate> aspirantBachillerates= new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "school_id",referencedColumnName = "id", nullable = false)
    private School school;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<AspirantBachillerate> getAspirantBachillerates() {
        return aspirantBachillerates;
    }

    public void setAspiringBachillerates(Set<AspirantBachillerate> aspiringBachillerates) {
        this.aspirantBachillerates = aspiringBachillerates;
    }
}

