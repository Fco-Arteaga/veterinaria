/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.service.impl;

import com.mx.examen.juan.dto.VeterinarioRequest;
import com.mx.examen.juan.dto.VeterinarioResponse;
import com.mx.examen.juan.entity.Veterinario;
import com.mx.examen.juan.exception.GeneralException;
import com.mx.examen.juan.repository.VeterinarioRepository;
import com.mx.examen.juan.service.IVeterinarioService;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fcoarteaga
 */
@Slf4j
@Service
public class VeterinarioServiceImpl implements IVeterinarioService{

    @Autowired
    private VeterinarioRepository veterinarioRepository;
    
    
    @Override
    @Transactional(readOnly = true)
    public VeterinarioResponse findById(Long id) throws GeneralException {
        Veterinario veterinario = veterinarioRepository.findById(id).orElseThrow(()-> new GeneralException("No existe el veterinario", HttpStatus.NOT_FOUND));
        return new VeterinarioResponse(
        veterinario.getId(),
        veterinario.getApellidoPaterno(),
        veterinario.getApellidoMaterno(),
        veterinario.getNombre(),
        veterinario.getCedulaProfesional(),
        veterinario.getFechaAlta()
        );
    }

    
    @Override
    @Transactional(readOnly = true)
    public List<VeterinarioResponse> findAll() throws GeneralException {

        return veterinarioRepository.findAll().stream().map((veterinario) -> new VeterinarioResponse(
                veterinario.getId(),
       veterinario.getApellidoPaterno(),
       veterinario.getApellidoMaterno(),
             veterinario.getNombre(),
     veterinario.getCedulaProfesional(),
           veterinario.getFechaAlta()
               )).collect(Collectors.toList());
    }

    @Override
    public VeterinarioResponse save(VeterinarioRequest veterinarioRequest) throws GeneralException {
       if (veterinarioRepository.existsByCedulaProfesional(veterinarioRequest.getCedulaProfesional())) {
            throw new GeneralException("veterinario con cedula profesional existente", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        Veterinario veterinario = veterinarioRepository.save(new Veterinario(
                veterinarioRequest.getApellidoPaterno(),
                veterinarioRequest.getApellidoMaterno(),
                veterinarioRequest.getNombre(),
                veterinarioRequest.getCedulaProfesional(),                
                new Date()
                ));

        return new VeterinarioResponse(
        veterinario.getId(),
        veterinario.getApellidoPaterno(),
        veterinario.getApellidoMaterno(),
        veterinario.getNombre(),
        veterinario.getCedulaProfesional(),
        veterinario.getFechaAlta()
        );
    }

    @Override
    public VeterinarioResponse update(VeterinarioRequest veterinarioRequest) throws GeneralException {


        Veterinario veterinarioUpdate = veterinarioRepository.findById(veterinarioRequest.getId()).get();
        
        
//log.info("veterinarioEncontrado " + veterinarioUpdate.getId());   


        veterinarioUpdate.setApellidoPaterno(veterinarioRequest.getApellidoPaterno());
        veterinarioUpdate.setApellidoMaterno(veterinarioRequest.getApellidoMaterno());
        veterinarioUpdate.setNombre( veterinarioRequest.getNombre());
        veterinarioUpdate.setCedulaProfesional(veterinarioRequest.getCedulaProfesional());
        
        veterinarioRepository.save(veterinarioUpdate);
        
//log.info("veterinarioEncontrado " + veterinarioRequest.getNombre());   

      
        return new VeterinarioResponse(
        veterinarioUpdate.getId(),
        veterinarioUpdate.getApellidoPaterno(),
        veterinarioUpdate.getApellidoMaterno(),
        veterinarioUpdate.getNombre(),
        veterinarioUpdate.getCedulaProfesional(),
        veterinarioUpdate.getFechaAlta()
        );
    }

    @Override
    public Map<String, Object> delete(Long id) throws GeneralException {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            if (!veterinarioRepository.findById(id).isPresent())
                throw new GeneralException("veterinario no existe", HttpStatus.UNPROCESSABLE_ENTITY);

            veterinarioRepository.deleteById(id);
            response.put("deleted", true);

            return response;

        } catch (Exception e) {
            throw new GeneralException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
