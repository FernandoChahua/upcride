package com.myorg.upcride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;


@Entity

@Table(name = "auto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "auto_id")
    private Integer id;

    @Column (name="placa", length = 50, nullable = false)
    private String placa;

    @Column (name="poliza_soat", length = 50 , nullable = false )
    private String polizaSoat;

    @Column (name="marca", length = 50 , nullable = false )
    private String marca;

    @Column (name="modelo", length = 50 , nullable = false )
    private String modelo;

    @Column (name="limite_personas", length = 50 , nullable = false )
    private int limitePersonas;

    @OneToOne
    @JoinColumn(name = "conductor_id")
    private Usuario conductor;

}