package alodjinha.com.br.data

import alodjinha.com.br.data.local.dao.ProdutoDAO
import alodjinha.com.br.data.local.entity.Produto
import alodjinha.com.br.data.remote.ProdutoWebService
import android.arch.lifecycle.LiveData
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by danielideriba on 12,March,2019
 */

@Singleton
class ProdutoRepository
@Inject constructor(private val webservice: ProdutoWebService, private val produtoDAO: ProdutoDAO, private val executor: Executor) {

    fun getLog(id: Int): LiveData<Produto> {
        return produtoDAO.load(id)
    }

    fun saveLog(produto: Produto): Long {
        return produtoDAO.save(produto)
    }
}