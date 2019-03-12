package alodjinha.com.br.data.local

import alodjinha.com.br.data.local.converter.DateConverter
import alodjinha.com.br.data.local.dao.BannerDAO
import alodjinha.com.br.data.local.dao.CategoriaDAO
import alodjinha.com.br.data.local.dao.ProdutoDAO
import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.local.entity.Categoria
import alodjinha.com.br.data.local.entity.Produto
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

/**
 * Created by danielideriba on 12,March,2019
 */

@Database(entities = [Banner::class, Categoria::class, Produto::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class DatabaseALodjinha: RoomDatabase(){

    abstract fun bannerDAO(): BannerDAO
    abstract fun categoriaDAO(): CategoriaDAO
    abstract fun produtoDAO(): ProdutoDAO

    companion object {
        val INSTANCE: DatabaseALodjinha? = null
    }
}