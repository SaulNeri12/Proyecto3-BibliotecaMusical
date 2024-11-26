package com.equipo7.negocio.dtos.convertidor;


import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Saul Armando Neri Escarcega
 * @param <T> DTO
 * @param <U> Entidad
 */
public class Converter <T, U> {

    private final Function<T, U> fromDTO;
    private final Function<U, T> fromEntity;

    public Converter(final Function<T, U> fromDTO, final Function<U, T> fromEntity) {
        this.fromDTO = fromDTO;
        this.fromEntity = fromEntity;
    }

    public final U convertFromDTO(final T dto) {
        return fromDTO.apply(dto);
    }

    public final T convertFromEntity(final U entity) {
        return fromEntity.apply(entity);
    }

    public final List<U> createFromDTOS(final Collection<T> dtos) {
        return dtos.stream().map(this::convertFromDTO).collect(Collectors.toList());
    }

    public final List<T> createFromEntities(final Collection<U> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
}