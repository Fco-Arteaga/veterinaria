/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.repository;

import com.mx.examen.juan.entity.Veterinario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fcoarteaga
 */
@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
    
    boolean existsByCedulaProfesional(String name);
    
    
   
    
    
}
