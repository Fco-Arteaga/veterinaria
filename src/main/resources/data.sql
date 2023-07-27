/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fcoarteaga
 * Created: 26 jul 2023
 */

INSERT INTO veterinario (apellido_paterno, apellido_materno, nombre , cedula_profesional, fecha_alta) 
VALUES ('Arteaga', 'Flores', 'Juan Francisco', '0001', now() );

INSERT INTO paciente (nombre_paciente, id_tipo_paciente, fecha_nacimiento, apellido_paterno, apellido_materno, nombre, telefono)
VALUES ('GATITO', '2', '2020_10_15', 'Arteaga', 'Flores', 'Juan Francisco', '8331002050');








