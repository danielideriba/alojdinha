package alodjinha.com.br.di.module

import alodjinha.com.br.di.key.ViewModelKey
import alodjinha.com.br.ui.main.MainViewModel
import alodjinha.com.br.ui.productDetail.ProductDetailViewModel
import alodjinha.com.br.utils.FactoryViewModel
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(repoViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailViewModel::class)
    abstract fun bindProductDetailViewModel(repoViewModel: ProductDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: FactoryViewModel): ViewModelProvider.Factory
}