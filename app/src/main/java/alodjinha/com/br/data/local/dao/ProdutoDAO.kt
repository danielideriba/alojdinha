package alodjinha.com.br.data.local.dao

import alodjinha.com.br.data.local.entity.Produto
import alodjinha.com.br.data.remote.model.ProdutoMaisVendidos
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by danielideriba on 12,March,2019
 */

@Dao
interface ProdutoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(produto: Produto): Long

    @Query("SELECT * FROM produto")
    fun loadAll(): LiveData<List<Produto>>

    @Query("SELECT * FROM produto")
    fun loadAllBestSellers(): LiveData<List<Produto>>

    @Query("SELECT * FROM produto WHERE id = :id  LIMIT 1")
    fun hasUser(id: Int): LiveData<Produto>
}