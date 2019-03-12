package alodjinha.com.br.di.module

import alodjinha.com.br.data.local.DatabaseALodjinha
import alodjinha.com.br.data.local.dao.BannerDAO
import alodjinha.com.br.data.local.dao.CategoriaDAO
import alodjinha.com.br.data.local.dao.ProdutoDAO
import alodjinha.com.br.utils.DATABASE_NAME
import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): DatabaseALodjinha {
        return Room.databaseBuilder(
            application,
            DatabaseALodjinha::class.java,
            DATABASE_NAME
        )
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideBanner(database: DatabaseALodjinha): BannerDAO {
        return database.bannerDAO()
    }

    @Provides
    @Singleton
    fun provideCategoria(database: DatabaseALodjinha): CategoriaDAO {
        return database.categoriaDAO()
    }

    @Provides
    @Singleton
    fun provideProduto(database: DatabaseALodjinha): ProdutoDAO {
        return database.produtoDAO()
    }
}