package com.equipo7.negocio.dtos.convertidor;

import com.equipo7.negocio.dtos.CancionDTO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.persistencia.entidades.Cancion;
import com.equipo7.persistencia.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioConverter extends Converter<UsuarioDTO, Usuario> {

    public UsuarioConverter() {
        super(UsuarioConverter::convertToEntity, UsuarioConverter::convertToDto);
    }

    private static UsuarioDTO convertToDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO(
                usuario.getNombreUsuario(),
                usuario.getCorreoElectronico(),
                usuario.getContrasena(),
                usuario.getImagenPerfil(),
                usuario.getGenerosRestringidos()
        );
        
        if(usuario.getGenerosRestringidos() != null){
            dto.setGenerosRestringidos(usuario.getGenerosRestringidos());
        }
        if (usuario.getAlbumesFavoritos() != null) {
            dto.setAlbumesFavoritos(usuario.getAlbumesFavoritos());
        }

        if (usuario.getArtistasFavoritos() != null) {
            dto.setArtistasFavoritos(usuario.getArtistasFavoritos());
        }

        if (usuario.getCancionesFavoritas() != null) {
            List<CancionDTO> canciones = (List<CancionDTO>) usuario.getCancionesFavoritas().stream().map(c -> {
                CancionDTO dto__ = new CancionDTO();
                dto__.setIdAlbum(c.getIdAlbum());
                dto__.setImagenPortadaURL(c.getImagenPortadaURL());
                dto__.setNombre(c.getNombre());

                return dto__;
            }).collect(Collectors.toList());

            dto.setCancionesFavoritas(canciones);
        }
        
        return dto;
    }

    private static Usuario convertToEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNombreUsuario(dto.getNombreUsuario());
        u.setCorreoElectronico(dto.getCorreoElectronico());
        u.setContrasena(dto.getContrasena());
        u.setGenerosRestringidos(dto.getGenerosRestringidos());
        u.setImagenPerfil(dto.getImagenPerfil());
        
        if (dto.getArtistasFavoritos() != null) {
            u.setArtistasFavoritos(dto.getArtistasFavoritos());
        }
        
        if (dto.getAlbumesFavoritos() != null) {
            u.setAlbumesFavoritos(dto.getAlbumesFavoritos());
        }
        
        if(dto.getGenerosRestringidos() != null){
            u.setGenerosRestringidos(dto.getGenerosRestringidos());
        }
        
        if (dto.getCancionesFavoritas() != null) {
            List<Cancion> canciones = (List<Cancion>) dto.getCancionesFavoritas().stream().map(c -> {
                Cancion c__ = new Cancion();
                c__.setIdAlbum(c.getIdAlbum());
                c__.setImagenPortadaURL(c.getImagenPortadaURL());
                c__.setNombre(c.getNombre());

                return c__;
            }).collect(Collectors.toList());

            u.setCancionesFavoritas(canciones);
        }
        
        return u;
    }
}
