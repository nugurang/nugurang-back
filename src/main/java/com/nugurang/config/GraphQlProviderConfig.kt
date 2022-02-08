package com.nugurang.config

import com.google.common.base.Charsets
import com.google.common.io.Resources
import graphql.GraphQL
import graphql.scalars.ExtendedScalars
import graphql.schema.GraphQLScalarType
import graphql.schema.GraphQLSchema
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.IOException
import javax.annotation.PostConstruct

@Configuration
class GraphQlProviderConfig {
    private lateinit var graphQLObject: GraphQL

    @PostConstruct
    @Throws(IOException::class)
    fun init() {
        val url = Resources.getResource("schema.graphqls")
        val sdl = Resources.toString(url, Charsets.UTF_8)
        val graphQLSchema = buildSchema(sdl)
        graphQLObject = GraphQL.newGraphQL(graphQLSchema).build()
    }

    private fun buildSchema(sdl: String): GraphQLSchema {
        val typeRegistry = SchemaParser().parse(sdl)
        val runtimeWiring = buildWiring()
        val schemaGenerator = SchemaGenerator()
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring)
    }

    private fun buildWiring(): RuntimeWiring {
        return RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.DateTime).build()
    }

    @Bean
    fun graphQL(): GraphQL {
        return graphQLObject
    }

    @Bean
    fun dateTime(): GraphQLScalarType {
        return ExtendedScalars.DateTime
    }
}