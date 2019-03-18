package alodjinha.com.br.ui.main

import alodjinha.com.br.data.BannerRepository
import alodjinha.com.br.data.CategoriaRepository
import alodjinha.com.br.data.ProdutoRepository
import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.local.entity.Categoria
import alodjinha.com.br.data.local.entity.Produto
import alodjinha.com.br.data.remote.model.ProdutoMaisVendidos
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(var bannerRepository: BannerRepository,
                                        var categoryRepository: CategoriaRepository,
                                        var produtoRepository: ProdutoRepository) : ViewModel() {
    fun getAllBanners(): LiveData<List<Banner>> {
        return bannerRepository.getAllBanners()
    }

    fun getAllCategories() : LiveData<List<Categoria>> {
        return categoryRepository.getAllCategories()
    }

    fun getAllProdutoMaisVendidos(): LiveData<List<Produto>>{
        return produtoRepository.getAllProdutoBestSellers()
    }
}