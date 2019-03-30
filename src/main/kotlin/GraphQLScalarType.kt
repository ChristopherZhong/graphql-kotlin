@file:Suppress("unused")

import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType

@RuntimeWiringMarker
class GraphQLScalarTypeBuilder {
    private val builder = GraphQLScalarType.newScalar()

    var name: String? = null
    var description: String? = null
    var coercing: Coercing<Any, Any>? = null

    fun build(): GraphQLScalarType {
        builder.name(name)
        builder.description(description)
        builder.coercing(coercing)
        return builder.build()
    }
}
