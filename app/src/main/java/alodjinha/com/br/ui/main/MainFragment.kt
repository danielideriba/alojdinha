package alodjinha.com.br.ui.main

import alodjinha.com.br.R
import alodjinha.com.br.ui.BaseFragment
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

class MainFragment: BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.configureViewModel()
        this.setUpView()
    }

    private fun setUpView() {
        //Header fields
    }

    private fun configureViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

}