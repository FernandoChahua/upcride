package com.myorg.upcride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "auto")

public class Auto implements Serializable{

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "auto_id")
    private Integer id;

    @Getter
    @Setter
    @Column (name="placa", length = 50, nullable = false)
    private String placa;

    @Getter
    @Setter
    @Column (name="poliza_soat", length = 50 , nullable = false )
    private String polizaSoat;

    @Getter
    @Setter
    @Column (name="marca", length = 50 , nullable = false )
    private String marca;

    @Getter
    @Setter
    @Column (name="modelo", length = 50 , nullable = false )
    private String modelo;

    @Getter
    @Setter
    @Column (name="limite_personas", length = 50 , nullable = false )
    private int limitePersonas;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "conductor_id")
    private Usuario conductor;

}