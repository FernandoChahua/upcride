package com.myorg.upcride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;


@Entity
@Table(name = "itinerario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Itinerario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="itinerario_id")
    private Integer id;

    @Column (name = "entrada_salida", nullable = false) //E: Entrada - S: Salida
    private int entradaSalida;

    @Column(name="punto_partida",length = 50 , nullable = false)
    private String puntoPartida;

    @Column(name="punto_destino",length = 50 , nullable = false)
    private String puntoDestino;

    @Column (name="partida_latitud", length = 50 , nullable = false )
    private double partidaLatitud;

    @Column (name="partida_longitud", length = 50 , nullable = false )
    private double partidaLongitud;
    
    @Column (name="destino_latitud", length = 50 , nullable = false )
    private double destinoLatitud;

    @Column (name="destino_longitud", length = 50 , nullable = false )
    private double destinoLongitud;

    @Column (name="hora", length = 50, nullable = false)
    private Time hora;

    @Column (name="dia", length = 50 , nullable = false )
    private String dia;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
