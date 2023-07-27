/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.repository;

import com.mx.examen.juan.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fcoarteaga
 */
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
    boolean existsByNombrePaciente(String name);
    
}
