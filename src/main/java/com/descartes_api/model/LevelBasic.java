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
@Table(name = "level_basic")
public class LevelBasic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String level;

    private String img;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "levelBasic")
    @JsonIgnore
    private Set<AspirantBasic> aspirantBasicList = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "school_id", referencedColumnName = "id", nullable = false)
    private School school;

    public void setFatherTutor(Set<AspirantBasic> aspirantBasics) {
        this.aspirantBasicList = aspirantBasics;
        for(AspirantBasic aspirantBasicS:aspirantBasics)
            aspirantBasicS.setLevelBasic(this);
    }
}