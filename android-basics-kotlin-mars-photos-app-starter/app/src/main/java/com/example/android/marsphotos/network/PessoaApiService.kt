package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://servicodados.ibge.gov.br/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PessoaApiService {
    @GET("/api/v2/censos/nomes/")
    suspend fun getPessoas(): List<Pessoa>
}

object PessoaApi {

    val retrofitService : PessoaApiService by lazy {

        retrofit.create(PessoaApiService::class.java)
    }
}
