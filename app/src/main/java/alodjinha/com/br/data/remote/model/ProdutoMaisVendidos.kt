package alodjinha.com.br.data.remote.model

/**
 * Created by danielideriba on 18,March,2019
 */
data class ProdutoMaisVendidos(
    val id : Int,
    val nome : String,
    val urlImagem : String,
    val descricao : String,
    var precoDe: Float,
    var precoPor: Float
//    val categoria : Categoria
)