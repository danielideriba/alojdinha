package alodjinha.com.br.data

import alodjinha.com.br.data.local.dao.BannerDAO
import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.remote.BannerWebService
import android.arch.lifecycle.LiveData
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BannerRepository @Inject constructor(private val webservice: BannerWebService, private val bannerDAO: BannerDAO, private val executor: Executor) {

    fun getBanner(id: Int): LiveData<Banner> {
        return bannerDAO.load(id)
    }

    fun saveLog(banner: Banner): Long {
        return bannerDAO.save(banner)
    }

}