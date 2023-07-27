/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.controller;

import com.mx.examen.juan.dto.PacienteRequest;
import com.mx.examen.juan.dto.PacienteResponse;
import com.mx.examen.juan.exception.GeneralException;
import com.mx.examen.juan.service.IPacienteService;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fcoarteaga
 */

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    
    @Autowired
    private IPacienteService iPacienteService;
    
    @GetMapping("/all")
    public ResponseEntity<List<PacienteResponse>> getPacientes() throws GeneralException {
        //throw new GeneralException("test", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(iPacienteService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<PacienteResponse> save(@RequestBody PacienteRequest pacienteRequest) throws GeneralException {
        return new ResponseEntity<>(iPacienteService.save(pacienteRequest), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PacienteResponse> update(@RequestBody PacienteRequest pacienteRequest) throws GeneralException {
        return new ResponseEntity<>(iPacienteService.update(pacienteRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) throws GeneralException {
        return new ResponseEntity<>(iPacienteService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> getById(@PathVariable Long id) throws GeneralException {
        return new ResponseEntity<>(iPacienteService.findById(id), HttpStatus.OK);
    }
}
