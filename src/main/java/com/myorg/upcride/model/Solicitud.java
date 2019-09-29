package com.myorg.upcride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitud_id")
    private Integer id;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario pasajero;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "viaje_id")
    private Viaje viaje;
    @Getter
    @Setter
    @Column(name = "mensaje", length = 120, nullable = true)
    private String mensaje;
    @Getter
    @Setter
    @Column(name = "confirmacion_conductor", length = 20, nullable = false)
    private String confirmacionConductor;
    @Getter
    @Setter
    @Column(name = "punto_encuentro", length = 30, nullable = false)
    private String puntoEncuentro;
    @Getter
    @Setter
    @Column(name = "encuentro_latitud", length = 30, nullable = false)
    private double encuentroLatitud;
    @Getter
    @Setter
    @Column(name = "encuentro_longitud", length = 30, nullable = false)
    private double encuentroLongitud;
    @Getter
    @Setter
    @Column(name = "fecha", nullable = false)
    private Date fecha;


}
