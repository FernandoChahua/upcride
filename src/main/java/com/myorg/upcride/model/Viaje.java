package com.myorg.upcride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

public class Viaje implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viaje_id")
    private Integer id;
    
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Usuario conductor;
    
    @Getter
    @Setter
    @Column (name = "descripcion", length = 500, nullable = false)
    private String descripcion;
    
    @Getter
    @Setter
    @Column(name = "punto_partida", length = 60, nullable = false) //Distrito partida
    private String puntoPartida;
    
    @Getter
    @Setter
    @Column(name = "punto_destino", length = 60, nullable = false) //Distrito destino
    private String puntoDestino;
    
    @Getter
    @Setter
    @Column(name = "destino_latitud", length = 60, nullable = false)
    private double destinoLatitud;
    
    @Getter
    @Setter
    @Column(name = "destino_longitud", length = 60, nullable = false)
    private double destintoLongitud;
    
    @Getter
    @Setter
    @Column(name = "partida_latitud", length = 60, nullable = false)
    private double partidaLatitud;
    
    @Getter
    @Setter
    @Column(name = "partida_longitud", length = 60, nullable = false)
    private double partidaLongitud;
    
    @Getter
    @Setter
    @Column (name = "hora_partida", nullable = false)
    private Time horaPartida;
    
    @Getter
    @Setter
    @Column (name = "hora_llegada", nullable = false)
    private Time horaLlegada;

    
    @Getter
    @Setter
    @Column (name = "entradaSalida", nullable = false) //E: Entrada - S: Salida
    private int entradaSalida;
    
    @Getter
    @Setter
    @Column (name = "fecha", nullable = false)
    private Date fecha;
    
    @Getter
    @Setter
    @Column (name = "dia", length = 20, nullable = false)
    private String dia;
    
    @Getter
    @Setter
    @Column (name = "estado", length = 60, nullable = true)
    private String estado;
    
    @Getter
    @Setter
    @Column (name = "visualizacion_habilitada", nullable = false) //1: visible - 0: invisible
    private int visualizacionHabilitada;
    
    @Getter
    @Setter
    @Column(name = "numero_pasajeros", nullable = true)
    private int numeroPasajeros;
    
    @Getter
    @Setter
    @Column(name = "limite_pasajeros", nullable = false)
    private int limitePasajeros;
    
    @Getter
    @Setter
    @Column(name = "precio_base", nullable = false)
    private double precioBase;
    
}
