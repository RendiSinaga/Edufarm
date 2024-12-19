package com.example.edufarm.data.api

import com.example.edufarm.data.model.ApiKategoriResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    //Kategori
    @GET("api/v1/mobilekategori")
    suspend fun getKategori(): Response<ApiKategoriResponse>
}

//    // Endpoint untuk modul berdasarkan kategori_id
//    @GET("api/v1/mobilemodule")
//    suspend fun getMateriByCategory(
//        @Query("kategori_id") kategoriId: Int
//    ): Response<ApiMateriResponse>
//}