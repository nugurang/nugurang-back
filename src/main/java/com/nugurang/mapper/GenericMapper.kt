package com.nugurang.mapper

import org.mapstruct.BeanMapping
import org.mapstruct.MappingTarget
import org.mapstruct.NullValuePropertyMappingStrategy

interface GenericMapper<D, E> {
    fun toDto(e: E): D
    fun toEntity(d: D): E

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun updateFromDto(dto: D, @MappingTarget entity: E)
}