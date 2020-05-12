package com.games.hackandslash.mapper;

import org.modelmapper.ModelMapper;

public interface DtoMapper<T,E> {
    public T dtoToEntity(E entity);
    public E entityToDto(T dto);

    public static ModelMapper modelMapper() {
        return new ModelMapper();
    };
}
