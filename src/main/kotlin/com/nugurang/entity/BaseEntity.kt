package com.nugurang.entity

interface BaseEntity<T> {
    fun toDto(): T
}