/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.dto;

import java.util.Date;
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
public class VeterinarioResponse {
     
    private Long id;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String nombre;
    
    private String cedulaProfesional;
    
    private Date fechaAlta; 
}
