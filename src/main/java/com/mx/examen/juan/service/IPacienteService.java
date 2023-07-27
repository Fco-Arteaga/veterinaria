/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.service;

import com.mx.examen.juan.dto.PacienteRequest;
import com.mx.examen.juan.dto.PacienteResponse;
import com.mx.examen.juan.exception.GeneralException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fcoarteaga
 */
public interface IPacienteService {
    
    PacienteResponse findById(Long id) throws GeneralException;

    List<PacienteResponse> findAll() throws GeneralException;
    
    PacienteResponse save(PacienteRequest pacienteRequest) throws GeneralException;

    PacienteResponse update(PacienteRequest pacienteRequest) throws GeneralException;

    Map<String, Object> delete(Long id) throws GeneralException;
}
