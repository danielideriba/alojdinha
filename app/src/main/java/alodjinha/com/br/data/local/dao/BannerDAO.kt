package alodjinha.com.br.data.local.dao

import alodjinha.com.br.data.local.entity.Banner
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
interface BannerDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(banner: Banner): Long

    @Query("SELECT * FROM banner WHERE id = :id")
    fun load(id: Int): LiveData<Banner>

    @Query("SELECT * FROM banner WHERE id = :id AND lastRefresh = :lastRefresh LIMIT 1")
    fun hasUser(id: Int, lastRefresh: Date): Banner
}