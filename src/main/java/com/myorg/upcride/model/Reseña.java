package com.myorg.upcride.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "resena")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class Reseña implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reseña_id")
    private Integer id;

   @Column (name = "contenido", length = 120 , nullable = false)
    private String contenido;

   @Column (name = "valoracion")
    private double valoracion;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn (name = "viaje_id")
    private Viaje viaje;




}
