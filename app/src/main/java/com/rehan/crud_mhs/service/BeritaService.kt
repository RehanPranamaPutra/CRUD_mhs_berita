package com.rehan.crud_mhs.service

import com.rehan.crud_mhs.model.ResponseBerita
import retrofit2.Call
import retrofit2.http.GET

interface BeritaService {
    @GET("getBerita.php")
    fun getAllBerita() : Call<ResponseBerita>
}