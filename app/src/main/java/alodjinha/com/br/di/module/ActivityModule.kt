package alodjinha.com.br.di.module

import alodjinha.com.br.ui.about.AboutActivity
import alodjinha.com.br.ui.main.MainActivity
import alodjinha.com.br.ui.productDetail.ProductDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by danielideriba on 12,March,2019
 */

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentModule::class))
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(FragmentModule::class))
    internal abstract fun contributeProductDetailActivity(): ProductDetailActivity

    @ContributesAndroidInjector(modules = arrayOf(FragmentModule::class))
    internal abstract fun contributeAboutActivity(): AboutActivity
}