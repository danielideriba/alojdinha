package alodjinha.com.br.ui.productDetail

import alodjinha.com.br.data.ProdutoRepository
import alodjinha.com.br.data.local.entity.Produto
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by danielideriba on 19,March,2019
 */

class ProductDetailViewModel @Inject constructor(var produtoRepository: ProdutoRepository) : ViewModel() {

    fun getProduto(idProduto: Int): LiveData<Produto> {
        return produtoRepository.getProduto(idProduto)
    }
}