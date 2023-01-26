package cl.maleb.mercadolibre.mobile.challenge.utils

/**
 * Interface for model mappers. It provides helper methods that helps
 * retrieving of models from outer data source layers
 *
 * @param <T> the cached model input type
 * @param <T> the remote model input type
 * @param <V> the model return type
 */
interface Mapper<Output, Input> {
    fun executeMapping(type: Input): Output
}