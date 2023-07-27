/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fcoarteaga
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PacienteRequest {
    
    private Long id;
    
    @JsonProperty("nombre_paciente")
    private String nombrePaciente;
    
    @JsonProperty("id_tipo_paciente")
    private String idTipoPaciente;
    
    @JsonProperty("fecha_nacimiento")
    private String fechaNacimiento;
    
    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;
    
    @JsonProperty("apellido_materno")
    private String apellidoMaterno;
    
    @JsonProperty("nombre")
    private String nombre;
    
    @JsonProperty("telefono")
    private String telefono;
}
