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
@Table(name = "aspirant")
public class Aspirant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_aspirant")
    private char tipoAspirant;

    @Column(length = 75)
    private String name;

    @Column(name = "last_name_p", length= 50)
    private String lastNameP;

    @Column(name = "last_name_m", length= 50)
    private String lastNameM;

    @Column(length = 18)
    private String curp;

    @Column(name = "blood_type", length = 4)
    private String bloodType;

    @Column(length = 100)
    private String conditionS;

    private char sex;


    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "aspirant", fetch = FetchType.LAZY)
    @JsonIgnore
    private AspirantBasic aspirantBasic;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "aspirant", fetch = FetchType.LAZY)
    @JsonIgnore
    private AspirantBachillerate aspirantBachillerate;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "aspirant", fetch = FetchType.LAZY)
    @JsonIgnore
    private AspirantSuperior aspirantSuperior;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "aspirant", fetch = FetchType.LAZY)
    @JsonIgnore
    private AspirantPostgraduate aspirantPostgraduate;

    @OneToMany( cascade =  CascadeType.ALL,mappedBy = "aspirant", fetch = FetchType.EAGER)
    private Set<FatherTutor> fatherTutor= new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    public void setFatherTutor(Set<FatherTutor> fatherTutors) {
        this.fatherTutor = fatherTutors;
        for(FatherTutor fatherTutor:fatherTutors)
            fatherTutor.setAspirant(this);
    }
}
