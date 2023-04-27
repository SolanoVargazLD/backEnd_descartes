package com.descartes_api.model;

        import jakarta.persistence.*;
        import lombok.Getter;
        import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 75)
    private String street;

    @Column(length = 5)
    private String number;

    @Column(length = 75)
    private String colony;

    @Column(length = 75)
    private String municipality;

    @Column(length = 5)
    private String postal_code;

}
