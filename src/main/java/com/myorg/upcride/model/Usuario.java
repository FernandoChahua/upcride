package com.myorg.upcride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
//
import javax.persistence.*;



@Entity
@Table (name= "usuario")
public class Usuario implements Serializable {

 private static final long serialVersionUID = 1L;
 @Getter
 @Setter
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name= "usuario_id")
 private Integer id;
 @Getter
 @Setter
 @Column(name = "codigo_upc")
 private String codigo;
 @Getter
 @Setter
 @Column(name = "correo_upc", length = 50, nullable = false)
 private String correoUPC;
 @Getter
 @Setter
 @Column(name = "contraseña", length = 40, nullable = false)
 private String contraseña;
 @Getter
 @Setter
 @Column(name = "nombres", length = 60, nullable = false)
 private String nombres;
 @Getter
 @Setter
 @Column(name = "apellidos", length = 60, nullable = true)
 private String apellidos;
 @Getter
 @Setter
 @Column(name = "ubicacion_latitud", length = 100, nullable = false)
 private double ubicacionLatitud;
 @Getter
 @Setter
 @Column(name = "ubicacion_longitud", length = 100, nullable = false)
 private double ubicacionLongitud;
 @Getter
 @Setter
 @Column(name = "facebook_id", length = 60, nullable = true)
 private String facebook_id;
 @Getter
 @Setter
 @Column(name = "telefono", length = 25, nullable = false)
 private String telefono;
 @Getter
 @Setter
 @Column(name = "distrito", length = 100, nullable = false)
 private String distrito;
 @Getter
 @Setter
 @Column(name = "rol") //C: Conductor P: Pasajero
 private char rol;
 @Getter
 @Setter
 @Column(name = "licencia_conducir", length = 9, nullable = true)
 private String licenciaConducir;
 @Getter
 @Setter
 @Column(name="sede", length = 20, nullable= false)
 private String sede;



}