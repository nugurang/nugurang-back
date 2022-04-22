package com.nugurang.mapper

interface ReadOnlyMapper<D, E> {
    fun toDto(e: E): D
}