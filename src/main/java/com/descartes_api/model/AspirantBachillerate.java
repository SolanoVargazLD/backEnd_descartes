package com.descartes_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aspirant_bachillerate")
public class AspirantBachillerate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "school_origin", length = 100)
    private String schoolOrigin;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aspirant_id", unique = true)
    private Aspirant aspirant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "level_upper_middle_id", referencedColumnName = "id")
    private LevelUpperMiddle levelUpperMiddle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolOrigin() {
        return schoolOrigin;
    }

    public void setSchoolOrigin(String schoolOrigin) {
        this.schoolOrigin = schoolOrigin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public LevelUpperMiddle getLevelUpperMiddle() {
        return levelUpperMiddle;
    }

    public void setLevelUpperMiddle(LevelUpperMiddle levelUpperMiddle) {
        this.levelUpperMiddle = levelUpperMiddle;
    }
}
