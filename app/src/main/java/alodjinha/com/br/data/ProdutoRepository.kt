package alodjinha.com.br.data

import alodjinha.com.br.data.local.dao.ProdutoDAO
import alodjinha.com.br.data.local.entity.Produto
import alodjinha.com.br.data.remote.ProdutoWebService
import alodjinha.com.br.data.remote.model.ProdutoResponse
import alodjinha.com.br.ui.main.MainFragment
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by danielideriba on 12,March,2019
 */

@Singleton
class ProdutoRepository
@Inject constructor(private val webservice: ProdutoWebService, private val produtoDAO: ProdutoDAO, private val executor: Executor) {

    fun getAllProdutoBestSellers(mainFragment: MainFragment): LiveData<List<Produto>> {
        saveData(mainFragment)
        return produtoDAO.loadAllBestSellers()
    }

    private fun saveData(mainFragment: MainFragment) {
        executor.execute {
            produtoDAO.loadAll().observe(mainFragment, Observer {
                if(it!!.isEmpty()){
                    webservice.getBestSellers().enqueue(object : Callback<ProdutoResponse> {
                        override fun onResponse(call: Call<ProdutoResponse>, response: Response<ProdutoResponse>) {
                            executor.execute {
                                if(response.isSuccessful) {
                                    val resp = response.body()
                                    if(resp?.data != null){
                                        val dataResp = resp?.data
                                        for(i in dataResp.indices){
                                            produtoDAO.save(dataResp.get(i))
                                        }
                                    }
                                } else {
                                    Timber.d("--resp--" + response.errorBody())
                                }
                            }
                        }

                        override fun onFailure(call: Call<ProdutoResponse>, t: Throwable) {}
                    })
                }
            })
        }
    }
}