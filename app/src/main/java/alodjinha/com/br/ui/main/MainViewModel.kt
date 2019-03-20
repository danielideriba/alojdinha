package alodjinha.com.br.ui.main

import alodjinha.com.br.data.BannerRepository
import alodjinha.com.br.data.CategoriaRepository
import alodjinha.com.br.data.ProdutoRepository
import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.local.entity.Categoria
import alodjinha.com.br.data.local.entity.Produto
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.database.Observable
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor(var bannerRepository: BannerRepository,
                                        var categoryRepository: CategoriaRepository,
                                        var produtoRepository: ProdutoRepository) : ViewModel() {
    fun getAllBanners(mainFragment: MainFragment): LiveData<List<Banner>> {
        return bannerRepository.getAllBanners(mainFragment)
    }

    fun getAllCategories(mainFragment: MainFragment): LiveData<List<Categoria>> {
        return categoryRepository.getAllCategories(mainFragment)
    }

    fun getAllProdutoMaisVendidos(mainFragment: MainFragment): LiveData<List<Produto>>{
        return produtoRepository.getAllProdutoBestSellers(mainFragment)
    }
}