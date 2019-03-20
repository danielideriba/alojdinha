package alodjinha.com.br.ui.productDetail

import alodjinha.com.br.R
import alodjinha.com.br.ui.BaseFragment
import alodjinha.com.br.ui.extensions.toSpanned
import alodjinha.com.br.ui.utils.AlertDialogs
import alodjinha.com.br.utils.PRODUCT_ID
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Paint
import android.os.Bundle
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_product_detail.*
import javax.inject.Inject

/**
 * Created by danielideriba on 19,March,2019
 */

class ProductDetailFragment: BaseFragment(){
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ProductDetailViewModel

    private var productId: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(arguments != null) {
            productId = arguments!!.getString(PRODUCT_ID)
        }
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.configureViewModel()
        this.setProductWithData()
        this.setButton()
    }

    private fun setButton() {
        addProd.setOnClickListener {
            AlertDialogs.dialog(view!!.context, getString(R.string.reservado))
        }
    }

    private fun setProductWithData() {
        var produto = viewModel.getProduto(productId!!.toInt())
        produto.observe(this, Observer {
            if(it != null){
                Picasso.get().load(it.urlImagem).into(imageProduct)
                nameProduct.text = it.nome
                precoDe.text = "De: ${it.precoDe}"
                precoPro.text = "Por: ${it.precoPor}"
                description.text = it.descricao.toSpanned()

                precoDe.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }
        })
    }



    private fun configureViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductDetailViewModel::class.java)
    }
}