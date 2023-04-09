package com.descartes_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "aspirant_basic")
public class AspirantBasic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aspirant_id")
    private Aspirant aspirant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "level_basic_id", referencedColumnName = "id")
    private LevelBasic levelBasic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aspirant getAspirant() {
        return aspirant;
    }

    public void setAspirant(Aspirant aspirant) {
        this.aspirant = aspirant;
    }

    public LevelBasic getLevelBasic() {
        return levelBasic;
    }

    public void setLevelBasic(LevelBasic levelBasic) {
        this.levelBasic = levelBasic;
    }
}

