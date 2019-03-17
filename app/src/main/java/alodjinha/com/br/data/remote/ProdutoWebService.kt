package alodjinha.com.br.data.remote

import alodjinha.com.br.data.local.entity.Produto
import alodjinha.com.br.data.remote.model.ProdutoResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by danielideriba on 12,March,2019
 */

interface ProdutoWebService {
    @GET("/produto")
    fun getBanner(): Call<Produto>

    @GET("/produto/maisvendidos")
    fun getMostSold(): Call<ProdutoResponse>

    @GET("/produto/{id}")
    fun getProduct(@Path("produtoId") produtoId: Int): Call<Produto>
}