package alodjinha.com.br.ui.about

import alodjinha.com.br.R
import alodjinha.com.br.ui.BaseFragment
import alodjinha.com.br.ui.productDetail.ProductDetailViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

/**
 * Created by danielideriba on 20,March,2019
 */

class AboutFragment: BaseFragment(){
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ProductDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.configureViewModel()
    }

    private fun configureViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductDetailViewModel::class.java)
    }
}