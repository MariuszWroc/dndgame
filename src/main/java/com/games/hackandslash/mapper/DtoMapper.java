package com.games.hackandslash.mapper;

import org.modelmapper.ModelMapper;

public interface DtoMapper<T,E> {
    public T dtoToEntity(E dto);
    public E entityToDto(T entity);

    public static ModelMapper modelMapper() {
        return new ModelMapper();
    };
}
