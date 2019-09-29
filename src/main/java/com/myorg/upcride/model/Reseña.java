package com.myorg.upcride.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

public class Reseña implements Serializable{

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reseña_id")
    private Integer id;
    @Getter
    @Setter
   @Column (name = "contenido", length = 120 , nullable = false)
    private String contenido;
    @Getter
    @Setter
   @Column (name = "valoracion")
    private double valoracion;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Usuario cliente;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn (name = "viaje_id")
    private Viaje viaje;




}
