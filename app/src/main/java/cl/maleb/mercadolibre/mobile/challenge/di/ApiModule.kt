package cl.maleb.mercadolibre.mobile.challenge.di

import androidx.viewbinding.BuildConfig
import cl.maleb.mercadolibre.mobile.challenge.data.api.ApiService
import cl.maleb.mercadolibre.mobile.challenge.data.api.RemoteDataSource
import cl.maleb.mercadolibre.mobile.challenge.data.api.RemoteDataSourceImpl
import cl.maleb.mercadolibre.mobile.challenge.utils.BASE_URL
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService) =
        RemoteDataSourceImpl(apiService) as RemoteDataSource

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    private fun getHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        // Use the logging interceptor for API response log
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            // If you need to know headers, please uncomment the following line
            // httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.HEADERS);
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }
}