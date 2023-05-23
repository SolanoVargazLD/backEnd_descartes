package com.descartes_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "aspirant_postgraduate")
public class AspirantPostgraduate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "professional_license", length = 10)
    private String professionalLicense;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 10)
    private String phone;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "aspirante_id", unique = true)
    private Aspirant aspirant;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "level_higher_id", referencedColumnName = "id")
    private LevelHigher levelHigher;

}




