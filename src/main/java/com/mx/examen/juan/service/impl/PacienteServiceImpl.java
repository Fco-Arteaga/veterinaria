/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.service.impl;

import com.mx.examen.juan.dto.PacienteRequest;
import com.mx.examen.juan.dto.PacienteResponse;
import com.mx.examen.juan.entity.Paciente;
import com.mx.examen.juan.exception.GeneralException;
import com.mx.examen.juan.repository.PacienteRepository;
import com.mx.examen.juan.service.IPacienteService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Override
    @Transactional(readOnly = true)
    public PacienteResponse findById(Long id) throws GeneralException {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(()-> new GeneralException("No existe el paciente", HttpStatus.NOT_FOUND));
        return new PacienteResponse(
        paciente.getId(),
        paciente.getNombrePaciente(),
        paciente.getIdTipoPaciente(),
        paciente.getFechaNacimiento(),
        paciente.getApellidoPaterno(),
        paciente.getApellidoMaterno(),
        paciente.getNombre(),
        paciente.getTelefono()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteResponse> findAll() throws GeneralException {

        return (List<PacienteResponse>) pacienteRepository.findAll().stream().map((paciente) -> new PacienteResponse(
         paciente.getId(),
 paciente.getNombrePaciente(),
 paciente.getIdTipoPaciente(),
paciente.getFechaNacimiento(),
paciente.getApellidoPaterno(),
paciente.getApellidoMaterno(),
      paciente.getNombre(),
     paciente.getTelefono()
            )).collect(Collectors.toList());
    }

    @Override
    public PacienteResponse save(PacienteRequest pacienteRequest) throws GeneralException {
        if (pacienteRepository.existsByNombrePaciente(pacienteRequest.getNombrePaciente())) {
            throw new GeneralException("paciente ya existe", HttpStatus.UNPROCESSABLE_ENTITY);
        }
          
        Paciente paciente = pacienteRepository.save(new Paciente(
 pacienteRequest.getNombrePaciente(),
 pacienteRequest.getIdTipoPaciente(),
pacienteRequest.getFechaNacimiento(),
pacienteRequest.getApellidoPaterno(),
pacienteRequest.getApellidoMaterno(),
      pacienteRequest.getNombre(),
     pacienteRequest.getTelefono()                
         ));

        return new PacienteResponse(
         paciente.getId(),
 paciente.getNombrePaciente(),
 paciente.getIdTipoPaciente(),
paciente.getFechaNacimiento(),
paciente.getApellidoPaterno(),
paciente.getApellidoMaterno(),
      paciente.getNombre(),
     paciente.getTelefono()
        );

    }

    @Override
    public PacienteResponse update(PacienteRequest pacienteRequest) throws GeneralException {

        Paciente pacienteUpdate = pacienteRepository.findById(pacienteRequest.getId()).get();

        pacienteUpdate.setNombrePaciente(pacienteRequest.getNombrePaciente());
        pacienteUpdate.setIdTipoPaciente(pacienteRequest.getIdTipoPaciente());
        pacienteUpdate.setFechaNacimiento(pacienteRequest.getFechaNacimiento());
        pacienteUpdate.setApellidoPaterno(pacienteRequest.getApellidoPaterno());
        pacienteUpdate.setApellidoMaterno(pacienteRequest.getApellidoMaterno());
        pacienteUpdate.setNombre(pacienteRequest.getNombre());
        pacienteUpdate.setTelefono(pacienteRequest.getTelefono());
        
        pacienteRepository.save(pacienteUpdate);
        
        return new PacienteResponse(
         pacienteUpdate.getId(),
 pacienteUpdate.getNombrePaciente(),
 pacienteUpdate.getIdTipoPaciente(),
pacienteUpdate.getFechaNacimiento(),
pacienteUpdate.getApellidoPaterno(),
pacienteUpdate.getApellidoMaterno(),
      pacienteUpdate.getNombre(),
     pacienteUpdate.getTelefono()
        );
    }

    @Override
    public Map<String, Object> delete(Long id) throws GeneralException {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            if (!pacienteRepository.findById(id).isPresent())
                throw new GeneralException("paciente no existe", HttpStatus.UNPROCESSABLE_ENTITY);

            pacienteRepository.deleteById(id);
            response.put("deleted", true);

            return response;

        } catch (Exception e) {
            throw new GeneralException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
