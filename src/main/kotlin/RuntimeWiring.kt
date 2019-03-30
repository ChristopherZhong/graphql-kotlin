import graphql.schema.idl.RuntimeWiring

@DslMarker
annotation class RuntimeWiringMarker

@RuntimeWiringMarker
class RuntimeWiringBuilder {
    // unable to directly extend RuntimeWiring.Builder because the constructor is private
    // instead, an instance of RuntimeWiring.Builder is encapsulated in this class
    private val builder = RuntimeWiring.newRuntimeWiring()

    fun scalar(init: GraphQLScalarTypeBuilder.() -> Unit): RuntimeWiringBuilder {
        val builder = GraphQLScalarTypeBuilder()
        builder.init()
        this.builder.scalar(builder.build())
        return this
    }

    fun type(typeName: String, init: TypeRuntimeWiringBuilder.() -> Unit): RuntimeWiringBuilder {
        val builder = TypeRuntimeWiringBuilder(typeName)
        builder.init()
        this.builder.type(builder.build())
        return this
    }

    internal fun build(): RuntimeWiring = builder.build()
}

@Suppress("FunctionName")
fun RuntimeWiring(init: RuntimeWiringBuilder.() -> Unit): RuntimeWiring {
    val builder = RuntimeWiringBuilder()
    builder.init()
    return builder.build()
}
