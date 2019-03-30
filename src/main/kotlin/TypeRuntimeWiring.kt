import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import graphql.schema.idl.TypeRuntimeWiring

@RuntimeWiringMarker
class TypeRuntimeWiringBuilder(typeName: String) {
    private val builder: TypeRuntimeWiring.Builder = TypeRuntimeWiring.newTypeWiring(typeName)

    fun <T : Any> dataFetcher(fieldName: String, dataFetcher: DataFetcher<T>): TypeRuntimeWiringBuilder {
        builder.dataFetcher(fieldName, dataFetcher)
        return this
    }

    fun <T : Any> dataFetcher(fieldName: String, dataFetcher: (DataFetchingEnvironment) -> T): TypeRuntimeWiringBuilder {
        builder.dataFetcher(fieldName, dataFetcher)
        return this
    }

    internal fun build(): TypeRuntimeWiring {
        return builder.build()
    }

}
