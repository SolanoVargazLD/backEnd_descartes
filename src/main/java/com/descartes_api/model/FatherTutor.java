package com.descartes_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

}
