package alodjinha.com.br.data.remote.model

import alodjinha.com.br.data.local.entity.Categoria

/**
 * Created by danielideriba on 18,March,2019
 */
data class ProdutoMaisVendidos(
    val id : Int,
    val nome : String,
    val urlImagem : String,
    val descricao : String,
    val precoDe : Int,
    val precoPor : Double
//    val categoria : Categoria
)