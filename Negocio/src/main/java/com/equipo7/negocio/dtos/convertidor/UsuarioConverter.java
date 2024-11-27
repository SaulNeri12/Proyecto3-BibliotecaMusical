package com.equipo7.negocio.dtos.convertidor;

import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.persistencia.entidades.Usuario;

public class UsuarioConverter extends Converter<UsuarioDTO, Usuario> {

    public UsuarioConverter(){
        super(UsuarioConverter::convertToEntity, UsuarioConverter::convertToDto);
    }

    private static UsuarioDTO convertToDto(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getNombreUsuario(),
                usuario.getCorreoElectronico(),
                usuario.getContrasena(),
                usuario.getImagenPerfil(),
                
                usuario.getGenerosRestringidos()
        );
    }

    private static Usuario convertToEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNombreUsuario(dto.getNombreUsuario());
        u.setCorreoElectronico(dto.getCorreoElectronico());
        u.setContrasena(dto.getContrasena());
        
        u.setGenerosRestringidos(dto.getGenerosRestringidos());
        u.setImagenPerfil(dto.getImagenPerfil());
        return u;
    }
}
