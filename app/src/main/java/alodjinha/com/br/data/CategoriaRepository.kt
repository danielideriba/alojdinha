package alodjinha.com.br.data

import alodjinha.com.br.data.local.dao.CategoriaDAO
import alodjinha.com.br.data.local.entity.Categoria
import alodjinha.com.br.data.remote.CategoriaWebService
import alodjinha.com.br.data.remote.model.CategoryResponse
import android.arch.lifecycle.LiveData
import timber.log.Timber
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by danielideriba on 12,March,2019
 */

@Singleton
class CategoriaRepository
@Inject constructor(private val webservice: CategoriaWebService, private val categoriaDAO: CategoriaDAO, private val executor: Executor) {

    fun getAllCategories(): LiveData<List<Categoria>> {
        saveData()
        return categoriaDAO.loadAll()
    }

    private fun saveData() {
        executor.execute {
            val hasBanners = categoriaDAO.loadAll() != null

            if(hasBanners) {
                webservice.getCategory().enqueue(object : Callback<CategoryResponse> {
                    override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                        executor.execute {
                            if(response.isSuccessful) {
                                val resp = response.body()
                                if(resp?.data != null){
                                    val dataResp = resp?.data
                                    for(i in dataResp.indices){
                                        categoriaDAO.save(dataResp.get(i))
                                    }
                                }
                            } else {
                                Timber.d("--resp--" + response.errorBody())
                            }
                        }
                    }

                    override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {}
                })
            }
        }
    }
}