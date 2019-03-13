package alodjinha.com.br.data

import alodjinha.com.br.data.local.dao.BannerDAO
import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.remote.BannerWebService
import android.arch.lifecycle.LiveData
import java.util.*
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Singleton
class BannerRepository @Inject constructor(private val webservice: BannerWebService, private val bannerDAO: BannerDAO, private val executor: Executor) {

    fun getBanner(id: Int): LiveData<Banner> {
        refreshUser(id)
        return bannerDAO.load(id)
    }

    fun saveLog(banner: Banner): Long {
        return bannerDAO.save(banner)
    }

    private fun refreshUser(id: Int) {
        executor.execute {

            val hasBanner = bannerDAO.hasUser(id, getMaxRefreshTime(Date())) != null

            if (!hasBanner) {
                webservice.getBanner().enqueue(object : Callback<Banner> {
                    override fun onResponse(call: Call<Banner>, response: Response<Banner>) {
                        executor.execute {
                            val user = response.body()
                            user?.lastRefresh = Date()
                            if (user != null)
                                bannerDAO.save(user)
                        }
                    }

                    override fun onFailure(call: Call<Banner>, t: Throwable) {}
                })
            }
        }
    }


    private fun getMaxRefreshTime(currentDate: Date): Date {
        val cal = Calendar.getInstance()
        cal.time = currentDate
        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES)
        return cal.time
    }

    companion object {

        private const val FRESH_TIMEOUT_IN_MINUTES = 3
    }
}