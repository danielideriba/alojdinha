package alodjinha.com.br.data

import alodjinha.com.br.data.local.dao.BannerDAO
import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.data.remote.BannerWebService
import alodjinha.com.br.data.remote.model.BannerResponse
import alodjinha.com.br.ui.main.MainFragment
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import io.reactivex.disposables.Disposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton
import timber.log.Timber

@Singleton
class BannerRepository @Inject
constructor(private val webservice: BannerWebService, private val bannerDAO: BannerDAO, private val executor: Executor) {

    private var subscription: Disposable? = null

    fun getAllBanners(mainFragment: MainFragment): LiveData<List<Banner>> {
        saveData(mainFragment)
        return bannerDAO.loadAll()
    }

    private fun saveData(mainFragment: MainFragment) {
        executor.execute {
            bannerDAO.loadAll().observe(mainFragment, Observer {
                if(it!!.isEmpty()){
                    webservice.getBanner().enqueue(object : Callback<BannerResponse> {
                        override fun onResponse(call: Call<BannerResponse>, response: Response<BannerResponse>) {
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

                        override fun onFailure(call: Call<BannerResponse>, t: Throwable) {}
                    })
                }
            })
        }
    }
}