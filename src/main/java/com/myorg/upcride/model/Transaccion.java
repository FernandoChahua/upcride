package com.myorg.upcride.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transaccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaccion_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "pasajero_id")
    private Usuario pasajero;
    @ManyToOne
    @JoinColumn(name = "viaje_id")
    private Viaje viaje;


}
