package com.nugurang.dto;

data class RestResponseDto(
    val data: Any? = null,
    val errors: List<Error> = listOf(),
    val extensions: Any? = null
) {
    data class Error(
        val message: String,
        val locations: List<Location> = listOf(),
        val path: List<String> = listOf(),
        val extensions: Any? = null
    ) {
        data class Location(
            val line: Long,
            val column: Long
        )

        data class Extension(
            val type: String
        )
    }
}