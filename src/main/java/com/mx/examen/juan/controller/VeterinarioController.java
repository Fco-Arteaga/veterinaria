/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mx.examen.juan.controller;

import com.mx.examen.juan.dto.VeterinarioRequest;
import com.mx.examen.juan.dto.VeterinarioResponse;
import com.mx.examen.juan.exception.GeneralException;
import com.mx.examen.juan.service.IVeterinarioService;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
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
@RequestMapping("/veterinario")
public class VeterinarioController {
 
    @Autowired
    private IVeterinarioService iVeterinarioService;
    
    @GetMapping("/all")
    public ResponseEntity<List<VeterinarioResponse>> getVeterinarios() throws GeneralException {
        //throw new GeneralException("test", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(iVeterinarioService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<VeterinarioResponse> save(@RequestBody VeterinarioRequest veterinarioRequest) throws GeneralException {
        return new ResponseEntity<>(iVeterinarioService.save(veterinarioRequest), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VeterinarioResponse> update(@RequestBody VeterinarioRequest veterinarioRequest) throws GeneralException {
        return new ResponseEntity<>(iVeterinarioService.update(veterinarioRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) throws GeneralException {
        return new ResponseEntity<>(iVeterinarioService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioResponse> getById(@PathVariable Long id) throws GeneralException {
        return new ResponseEntity<>(iVeterinarioService.findById(id), HttpStatus.OK);
    }
    
    
    
}
