package com.descartes_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "aspirant_superior")
public class AspirantSuperior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "school_origin", length = 100)
    private String schoolOrigin;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "aspirant_id", unique = true)
    private Aspirant aspirant;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "level_higher_id", referencedColumnName = "id")
    private LevelHigher levelHigher;

}

