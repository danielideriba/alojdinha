package alodjinha.com.br.data.remote

import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.remote.model.BannerResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface BannerWebService {
    @GET("/banner")
    fun getBanner(): Call<BannerResponse>
}