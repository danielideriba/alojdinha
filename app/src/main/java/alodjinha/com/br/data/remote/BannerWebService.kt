package alodjinha.com.br.data.remote

import alodjinha.com.br.data.local.entity.Banner
import retrofit2.Call
import retrofit2.http.GET

interface BannerWebService {
    @GET("/banner")
    fun getBanner(): Call<Banner>
}