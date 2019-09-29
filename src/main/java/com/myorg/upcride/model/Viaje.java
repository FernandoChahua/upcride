package com.myorg.upcride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "viaje")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viaje implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viaje_id")
    private Integer id;
    
    
    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Usuario conductor;
    
    
    @Column (name = "descripcion", length = 500, nullable = false)
    private String descripcion;
    
    
    @Column(name = "punto_partida", length = 60, nullable = false) //Distrito partida
    private String puntoPartida;
    
    
    @Column(name = "punto_destino", length = 60, nullable = false) //Distrito destino
    private String puntoDestino;
    
    
    @Column(name = "destino_latitud", length = 60, nullable = false)
    private double destinoLatitud;
    
    
    @Column(name = "destino_longitud", length = 60, nullable = false)
    private double destintoLongitud;
    
    
    @Column(name = "partida_latitud", length = 60, nullable = false)
    private double partidaLatitud;
    
    
    @Column(name = "partida_longitud", length = 60, nullable = false)
    private double partidaLongitud;
    
    
    @Column (name = "hora_partida", nullable = false)
    private Time horaPartida;
    
    
    @Column (name = "hora_llegada", nullable = false)
    private Time horaLlegada;

    
    
    @Column (name = "entradaSalida", nullable = false) //E: Entrada - S: Salida
    private int entradaSalida;
    
    
    @Column (name = "fecha", nullable = false)
    private Date fecha;
    
    
    @Column (name = "dia", length = 20, nullable = false)
    private String dia;
    
    
    @Column (name = "estado", length = 60, nullable = true)
    private String estado;
    
    
    @Column (name = "visualizacion_habilitada", nullable = false) //1: visible - 0: invisible
    private int visualizacionHabilitada;
    
    
    @Column(name = "numero_pasajeros", nullable = true)
    private int numeroPasajeros;
    
    
    @Column(name = "limite_pasajeros", nullable = false)
    private int limitePasajeros;
    
    
    @Column(name = "precio_base", nullable = false)
    private double precioBase;
}
