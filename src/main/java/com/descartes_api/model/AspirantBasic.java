package com.descartes_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "aspirant_basic")
public class AspirantBasic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "aspirant_id", unique = true)
    private Aspirant aspirant;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "level_basic_id", referencedColumnName = "id")
    private LevelBasic levelBasic;
}

