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
@Table(name = "paciente")
public class Paciente {
    
//nombre_paciente, id_tipo_paciente, fecha_nacimiento, apellido_paterno, 
//apellido_materno, nombre, telefono
    
    public Paciente(String nombrePaciente, String idTipoPaciente, String fechaNacimiento, String apellidoPaterno, String apellidoMaterno, String nombre, String telefono){
        this.nombrePaciente = nombrePaciente;
        this.idTipoPaciente = idTipoPaciente;
        this.fechaNacimiento = fechaNacimiento;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement
    private Long id;
    
    @Column(name = "nombre_paciente", nullable = false)
    private String nombrePaciente;
    
    @Column(name = "id_tipo_paciente", nullable = false)
    private String idTipoPaciente;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    private String fechaNacimiento;
    
    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;
    
    @Column(name = "apellido_materno", nullable = false)
    private String apellidoMaterno;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
      
}
