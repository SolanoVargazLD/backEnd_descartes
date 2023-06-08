package com.descartes_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "administrative")
public class Administrative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "last_name_p", length = 75)
    private String lastNameP;

    @Column(name = "last_name_m", length = 75)
    private String lastNameM;

    @Column(length = 150)
    private String password;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 10)
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = false)
    private Roles roles;

    @ManyToOne(fetch = FetchType.EAGER,  optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "school_id", referencedColumnName = "id", nullable = false)
    private School school;

}

