package com.descartes_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "father_tutor")
public class FatherTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 75)
    private String name;

    @Column(name = "last_name_p", length = 50)
    private String lastNameP;

    @Column(name = "last_name_m", length = 50)
    private String lastNameM;

    @Column(length = 10)
    private String phone1;

    @Column(length = 10)
    private String phone2;

    @Column(length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "aspirant_id", referencedColumnName = "id", nullable = false)
    private Aspirant aspirant;

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

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Aspirant getAspirant() {
        return aspirant;
    }

    public void setAspirant(Aspirant aspirant) {
        this.aspirant = aspirant;
    }


}
