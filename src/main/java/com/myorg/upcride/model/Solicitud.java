package com.myorg.upcride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author slayz
 */

@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitud_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pasajero_id")
    private Usuario pasajero;

    @ManyToOne
    @JoinColumn(name = "viaje_id")
    private Viaje viaje;

    @Column(name = "mensaje", length = 120, nullable = true)
    private String mensaje;

    @Column(name = "confirmacion_conductor", length = 20, nullable = false)
    private String confirmacionConductor;

    @Column(name = "punto_encuentro", length = 30, nullable = false)
    private String puntoEncuentro;

    @Column(name = "encuentro_latitud", length = 30, nullable = false)
    private double encuentroLatitud;

    @Column(name = "encuentro_longitud", length = 30, nullable = false)
    private double encuentroLongitud;

    @Column(name = "fecha", nullable = false)
    private Date fecha;


}
