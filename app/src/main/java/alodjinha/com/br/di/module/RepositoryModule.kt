package alodjinha.com.br.di.module

import alodjinha.com.br.data.BannerRepository
import alodjinha.com.br.data.CategoriaRepository
import alodjinha.com.br.data.ProdutoRepository
import alodjinha.com.br.data.local.dao.BannerDAO
import alodjinha.com.br.data.local.dao.CategoriaDAO
import alodjinha.com.br.data.local.dao.ProdutoDAO
import alodjinha.com.br.data.remote.BannerWebService
import alodjinha.com.br.data.remote.CategoriaWebService
import alodjinha.com.br.data.remote.ProdutoWebService
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module(includes = [
    DatabaseModule::class,
    NetModule::class,
    AppModule::class
])

class RepositoryModule {
    @Provides
    @Singleton
    fun provideBannerRepository(
        bannerWebservice: BannerWebService,
        bannerDAO: BannerDAO,
        executor: Executor
    ): BannerRepository {
        return BannerRepository(bannerWebservice, bannerDAO, executor)
    }

    @Provides
    @Singleton
    fun provideCategoriaRepository(
        categoriaWebservice: CategoriaWebService,
        categoriaDAO: CategoriaDAO,
        executor: Executor
    ): CategoriaRepository {
        return CategoriaRepository(categoriaWebservice, categoriaDAO, executor)
    }

    @Provides
    @Singleton
    fun provideProdutoRepository(
        produtoWebService: ProdutoWebService,
        produtoDAO: ProdutoDAO,
        executor: Executor
    ): ProdutoRepository {
        return ProdutoRepository(produtoWebService, produtoDAO, executor)
    }
}