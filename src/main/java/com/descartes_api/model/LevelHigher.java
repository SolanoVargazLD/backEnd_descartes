package com.descartes_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "level_higher")
public class LevelHigher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_career", length = 100)
    private String nameCareer;

    @Column(name = "key_career", length = 20)
    private String keyCareer;

    @Column(name = "img")
    private String img;

    @Column(name = "pdf")
    private String pdf;

    @OneToMany(mappedBy = "levelHigher", fetch = FetchType.EAGER)
    private Set<AspirantPostgraduate> aspirantPostgraduateList= new HashSet<>();

    @OneToMany(mappedBy = "levelHigher", fetch = FetchType.EAGER)
    private Set<AspirantSuperior> aspirantSuperiorList= new HashSet<>();

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

    public String getNameCareer() {
        return nameCareer;
    }

    public void setNameCareer(String nameCareer) {
        this.nameCareer = nameCareer;
    }

    public String getKeyCareer() {
        return keyCareer;
    }

    public void setKeyCareer(String keyCareer) {
        this.keyCareer = keyCareer;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public Set<AspirantPostgraduate> getAspirantPostgraduateList() {
        return aspirantPostgraduateList;
    }

    public void setAspirantPostgraduateList(Set<AspirantPostgraduate> aspirantPostgraduateList) {
        this.aspirantPostgraduateList = aspirantPostgraduateList;
    }

    public Set<AspirantSuperior> getAspiringSuperiorList() {
        return aspirantSuperiorList;
    }

    public void setAspiringSuperiorList(Set<AspirantSuperior> aspiringSuperiorList) {
        this.aspirantSuperiorList = aspiringSuperiorList;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}

