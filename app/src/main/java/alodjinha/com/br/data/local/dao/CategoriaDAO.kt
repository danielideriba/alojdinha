package alodjinha.com.br.data.local.dao

import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.local.entity.Categoria
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
interface CategoriaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(categoria: Categoria): Long

    @Query("SELECT * FROM categoria")
    fun loadAll(): LiveData<List<Categoria>>

    @Query("SELECT * FROM categoria WHERE id = :id LIMIT 1")
    fun hasUser(id: Int): Categoria
}