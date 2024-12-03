/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.dtos.convertidor;

import com.equipo7.negocio.dtos.IntegranteDTO;
import com.equipo7.persistencia.entidades.Integrante;

/**
 *
 * @author Saul Neri
 */
public class IntegranteConvertidor {

    public static IntegranteDTO entidadADto(Integrante integrante) {
        IntegranteDTO dto = new IntegranteDTO();
        dto.setNombre(integrante.getNombre());
        dto.setFechaIngreso(integrante.getFechaIngreso());
        dto.setFechaSalida(integrante.getFechaSalida());
        dto.setRol(integrante.getRol());
        dto.setActivo(integrante.getActivo());
        
        return dto;
    }

    public static Integrante dtoAEntidad(IntegranteDTO integranteDTO) {
        Integrante entidad = new Integrante();
        entidad.setNombre(integranteDTO.getNombre());
        entidad.setFechaIngreso(integranteDTO.getFechaIngreso());
        entidad.setFechaSalida(integranteDTO.getFechaSalida());
        entidad.setRol(integranteDTO.getRol());
        entidad.setActivo(integranteDTO.getActivo());
        return entidad; // Retornar la entidad convertida
    }

}
