package alodjinha.com.br.ui.main

import alodjinha.com.br.data.BannerRepository
import alodjinha.com.br.data.local.entity.Banner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(var bannerRepository: BannerRepository) : ViewModel() {
    fun getAllBanners(): LiveData<List<Banner>> {
        return bannerRepository.getAllBanners()
    }
}