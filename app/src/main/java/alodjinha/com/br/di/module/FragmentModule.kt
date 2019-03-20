package alodjinha.com.br.di.module

import alodjinha.com.br.ui.about.AboutFragment
import alodjinha.com.br.ui.main.MainFragment
import alodjinha.com.br.ui.productDetail.ProductDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeProductDetailFragment(): ProductDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeAboutFragment(): AboutFragment
}
