package alodjinha.com.br.di.module

import alodjinha.com.br.BuildConfig
import alodjinha.com.br.data.remote.BannerWebService
import alodjinha.com.br.data.remote.CategoriaWebService
import alodjinha.com.br.data.remote.ProdutoWebService
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson,
                        @Named("apiurl") githubURL: String,
                        okhttp: OkHttpClient
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl(githubURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okhttp)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    @Provides
    @Singleton
    @Named("apiurl")
    fun provideGithubURL(): String {
        return BuildConfig.API_URL
    }

    @Provides
    @Singleton
    fun provideApiBannerWebservice(restAdapter: Retrofit): BannerWebService {
        return restAdapter.create(BannerWebService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiCategoriaWebservice(restAdapter: Retrofit): CategoriaWebService {
        return restAdapter.create(CategoriaWebService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiProdutoWebservice(restAdapter: Retrofit): ProdutoWebService {
        return restAdapter.create(ProdutoWebService::class.java)
    }
}