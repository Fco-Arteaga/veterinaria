/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mx.examen.juan.service;

import com.mx.examen.juan.dto.VeterinarioRequest;
import com.mx.examen.juan.dto.VeterinarioResponse;
import com.mx.examen.juan.exception.GeneralException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fcoarteaga
 */
public interface IVeterinarioService {
    
    
    VeterinarioResponse findById(Long id) throws GeneralException;

    List<VeterinarioResponse> findAll() throws GeneralException;
    
    VeterinarioResponse save(VeterinarioRequest veterinarioRequest) throws GeneralException;

    VeterinarioResponse update(VeterinarioRequest veternarioRequest) throws GeneralException;

    Map<String, Object> delete(Long id) throws GeneralException;
}
