/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author fcoarteaga
 */

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veterinario")
public class Veterinario {
    
//    apellido_paterno, apellido_materno, nombre , cedula_profesional, fecha_alta
    
    public Veterinario(String apellidoPaterno, String apellidoMaterno, String nombre, String cedulaProfesional, Date fechaAlta){
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombre = nombre;
        this.cedulaProfesional = cedulaProfesional;
        this.fechaAlta = fechaAlta;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement
    private Long id;
    
    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;
    
    @Column(name = "apellido_materno", nullable = false)
    private String apellidoMaterno;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "cedula_profesional", nullable = false)
    private String cedulaProfesional;
    
    @Column(name = "fecha_alta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta; 
    
    
}
