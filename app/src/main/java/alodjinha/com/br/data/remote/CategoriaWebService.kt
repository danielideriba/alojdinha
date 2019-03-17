package alodjinha.com.br.data.remote

import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.local.entity.Categoria
import alodjinha.com.br.data.remote.model.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by danielideriba on 12,March,2019
 */

interface CategoriaWebService {
    @GET("/categoria")
    fun getCategory(): Call<CategoryResponse>
}