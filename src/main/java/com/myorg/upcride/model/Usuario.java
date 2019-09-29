package com.myorg.upcride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "usuario")
public class Usuario implements Serializable {

 private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name= "usuario_id")
 private Integer id;

 @Column(name = "codigo_upc")
 private String codigo;

 @Column(name = "correo_upc", length = 50, nullable = false)
 private String correoUPC;

 @Column(name = "contraseña", length = 40, nullable = false)
 private String contraseña;

 @Column(name = "nombres", length = 60, nullable = false)
 private String nombres;

 @Column(name = "apellidos", length = 60, nullable = true)
 private String apellidos;

 @Column(name = "ubicacion_latitud", length = 100, nullable = false)
 private double ubicacionLatitud;

 @Column(name = "ubicacion_longitud", length = 100, nullable = false)
 private double ubicacionLongitud;

 @Column(name = "facebook_id", length = 60, nullable = true)
 private String facebook_id;

 @Column(name = "telefono", length = 25, nullable = false)
 private String telefono;

 @Column(name = "distrito", length = 100, nullable = false)
 private String distrito;

 @Column(name = "rol") //C: Conductor P: Pasajero
 private char rol;

 @Column(name = "licencia_conducir", length = 9, nullable = true)
 private String licenciaConducir;

 @Column(name="sede", length = 20, nullable= false)
 private String sede;



}