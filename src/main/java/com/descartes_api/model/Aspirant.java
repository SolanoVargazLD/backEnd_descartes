package com.descartes_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aspirant")
public class Aspirant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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


    @OneToOne(mappedBy = "aspirant", fetch = FetchType.LAZY)
    @JsonIgnore
    private AspirantBasic aspirantBasic;

    @OneToOne(mappedBy = "aspirant", fetch = FetchType.LAZY)
    @JsonIgnore
    private AspirantBachillerate aspirantBachillerate;

    @OneToOne(mappedBy = "aspirant", fetch = FetchType.LAZY)
    @JsonIgnore
    private AspirantSuperior aspirantSuperior;

    @OneToOne(mappedBy = "aspirant", fetch = FetchType.LAZY)
    @JsonIgnore
    private AspirantPostgraduate aspirantPostgraduate;

    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "aspirant", fetch = FetchType.EAGER)
    private Set<FatherTutor> fatherTutor= new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

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

    public String getLastNameP() {
        return lastNameP;
    }

    public void setLastNameP(String lastNameP) {
        this.lastNameP = lastNameP;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getConditionS() {
        return conditionS;
    }

    public void setConditionS(String conditionS) {
        this.conditionS = conditionS;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public AspirantBasic getAspirantBasic() {
        return aspirantBasic;
    }

    public void setAspirantBasic(AspirantBasic aspirantBasic) {
        this.aspirantBasic = aspirantBasic;
    }

    public AspirantBachillerate getAspirantBachillerate() {
        return aspirantBachillerate;
    }

    public void setAspirantBachillerate(AspirantBachillerate aspirantBachillerate) {
        this.aspirantBachillerate = aspirantBachillerate;
    }

    public AspirantSuperior getAspirantSuperior() {
        return aspirantSuperior;
    }

    public void setAspirantSuperior(AspirantSuperior aspirantSuperior) {
        this.aspirantSuperior = aspirantSuperior;
    }

    public AspirantPostgraduate getAspirantPostgraduate() {
        return aspirantPostgraduate;
    }

    public void setAspirantPostgraduate(AspirantPostgraduate aspirantPostgraduate) {
        this.aspirantPostgraduate = aspirantPostgraduate;
    }

    public Set<FatherTutor> getFatherTutor() {
        return fatherTutor;
    }

    public void setFatherTutor(Set<FatherTutor> fatherTutors) {
        this.fatherTutor = fatherTutors;
        for(FatherTutor fatherTutor:fatherTutors)
            fatherTutor.setAspirant(this);
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
