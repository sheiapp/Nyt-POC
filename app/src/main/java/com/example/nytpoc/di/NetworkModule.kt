package com.example.nytpoc.di

import com.example.nytpoc.BuildConfig
import com.example.nytpoc.network.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun loggingInterceptorProvider(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun interceptorProvider(): Interceptor = Interceptor {
        val originalRequest = it.request()
        val builder =
            originalRequest.newBuilder()
                .addHeader("Content-Type", "application/json")
        val newRequest = builder.build()
        it.proceed(newRequest)
    }

    @Singleton
    @Provides
    fun converterFactoryProvider(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun okHttpClientProvider(
        interceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor)
        addInterceptor(httpLoggingInterceptor)
    }.build()

    @Singleton
    @Provides
    fun retrofitProvider(
        converterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder().apply {
        baseUrl(BuildConfig.BASE_URL)
        addConverterFactory(converterFactory)
        client(okHttpClient)
    }.build()

    @Singleton
    @Provides
    fun appServiceProvider(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)

}