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
    @JsonIgnore
    private Set<AspirantBachillerate> aspirantBachillerates = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "school_id", referencedColumnName = "id", nullable = false)
    private School school;
}

