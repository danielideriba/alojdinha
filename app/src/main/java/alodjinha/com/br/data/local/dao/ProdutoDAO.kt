package alodjinha.com.br.data.local.dao

import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.local.entity.Produto
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import java.util.*

/**
 * Created by danielideriba on 12,March,2019
 */

@Dao
interface ProdutoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(produto: Produto): Long

    @Query("SELECT * FROM produto WHERE id = :id")
    fun load(id: Int): LiveData<Produto>

    @Query("SELECT * FROM produto WHERE id = :id AND lastRefresh = :lastRefresh LIMIT 1")
    fun hasUser(id: Int, lastRefresh: Date): Produto
}