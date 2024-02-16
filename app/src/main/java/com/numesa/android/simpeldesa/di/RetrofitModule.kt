/*************************************************
 * Created by Efendi Hariyadi on 5/15/20 12:50 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/15/20 12:50 AM
 ************************************************/

package com.numesa.android.simpeldesa.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.numesa.android.simpeldesa.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L
private val contentType = "application/json"
val RetrofitModule = module {
    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }
    single { GsonBuilder().create() }
    single { retrofitHttpClient() }
    single { retrofitBuilder() }
    single {
        Interceptor { chain ->
            chain.proceed(chain.request().newBuilder().apply {
                header("Accept", "application/json")
            }.build())
        }
    }
}

private fun Scope.retrofitBuilder(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(Json {
            coerceInputValues = true
            ignoreUnknownKeys = true
            useAlternativeNames = false
        }.asConverterFactory(contentType.toMediaType()))
        .addConverterFactory(GsonConverterFactory.create(get()))
        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create()) krn sudah pakai --> Coroutines
        .client(get())
        .build()
}


private fun Scope.retrofitHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        cache(get())
        connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
//        addInterceptor(get())
        addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.HEADERS
            }
            else {
                HttpLoggingInterceptor.Level.NONE
            }
        })
    }.build()
}