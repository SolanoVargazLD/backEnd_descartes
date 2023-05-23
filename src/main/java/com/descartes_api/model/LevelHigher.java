package com.descartes_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "level_higher")
public class LevelHigher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_career", length = 100)
    private String nameCareer;

    @Column(name = "key_career", length = 20)
    private String keyCareer;

    @Column(name = "nivel_educative", length = 20)
    private String nivelEducativo;

    @Column(name = "img")
    private String img;

    @Column(name = "pdf")
    private String pdf;

    @OneToMany(mappedBy = "levelHigher", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<AspirantPostgraduate> aspirantPostgraduateList= new HashSet<>();

    @OneToMany(mappedBy = "levelHigher", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<AspirantSuperior> aspirantSuperiorList= new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "school_id",referencedColumnName = "id", nullable = false)
    private School school;

}

