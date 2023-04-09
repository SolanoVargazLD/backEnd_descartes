package com.descartes_api.model;

import jakarta.persistence.*;

@Entity
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aspirante_id", unique = true)
    private Aspirant aspirant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "level_higher_id", referencedColumnName = "id")
    private LevelHigher levelHigher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessionalLicense() {
        return professionalLicense;
    }

    public void setProfessionalLicense(String professionalLicense) {
        this.professionalLicense = professionalLicense;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Aspirant getAspirant() {
        return aspirant;
    }

    public void setAspirant(Aspirant aspirant) {
        this.aspirant = aspirant;
    }

    public LevelHigher getLevelHigher() {
        return levelHigher;
    }

    public void setLevelHigher(LevelHigher levelHigher) {
        this.levelHigher = levelHigher;
    }
}




