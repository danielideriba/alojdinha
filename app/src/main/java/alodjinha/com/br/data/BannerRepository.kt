package alodjinha.com.br.data

import alodjinha.com.br.data.local.dao.BannerDAO
import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.remote.BannerWebService
import alodjinha.com.br.data.remote.model.BannerResponse
import android.arch.lifecycle.LiveData
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

@Singleton
class BannerRepository @Inject
constructor(private val webservice: BannerWebService, private val bannerDAO: BannerDAO, private val executor: Executor) {

    fun getAllBanners(): LiveData<List<Banner>> {
        saveData()
        return bannerDAO.loadAll()
    }

    private fun saveData() {
        executor.execute {
            val hasBanners = bannerDAO.loadAll() != null

            if(hasBanners) {
                webservice.getBanner().enqueue(object : Callback<BannerResponse> {
                    override fun onResponse(call: Call<BannerResponse>, response: Response<BannerResponse>) {
                        executor.execute {
                            if(response.isSuccessful) {
                                val resp = response.body()
                                if(resp?.data != null){
                                    val dataResp = resp?.data
                                    for(i in dataResp.indices){
                                        bannerDAO.save(dataResp.get(i))
                                    }
                                }
                            } else {
                                Timber.d("--resp--" + response.errorBody())
                            }
                        }
                    }

                    override fun onFailure(call: Call<BannerResponse>, t: Throwable) {}
                })
            }
        }
    }
}