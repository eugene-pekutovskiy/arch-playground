package com.eugene.pekutovskyi.data

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideTheMoviesDbApi(
        retrofit: Retrofit
    ): TheMoviesDbApi = retrofit.create(TheMoviesDbApi::class.java)

    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
        val apiKeyInterceptor = TmdbApiKeyInterceptor()
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)

    @Provides
    fun provideRetrofitClient(
        builder: Retrofit.Builder
    ): Retrofit = builder
        .baseUrl(BuildConfig.THE_MOVIES_DB_BASE_URL)
        .build()
}
