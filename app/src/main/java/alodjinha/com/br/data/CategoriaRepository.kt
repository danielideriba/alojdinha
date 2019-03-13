package alodjinha.com.br.data

import alodjinha.com.br.data.local.dao.CategoriaDAO
import alodjinha.com.br.data.local.entity.Categoria
import alodjinha.com.br.data.remote.CategoriaWebService
import android.arch.lifecycle.LiveData
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by danielideriba on 12,March,2019
 */

@Singleton
class CategoriaRepository
@Inject constructor(private val webservice: CategoriaWebService, private val categoriaDAO: CategoriaDAO, private val executor: Executor) {

    fun getLog(id: Int): LiveData<Categoria> {
        return categoriaDAO.load(id)
    }

    fun saveLog(categoria: Categoria): Long {
        return categoriaDAO.save(categoria)
    }
}