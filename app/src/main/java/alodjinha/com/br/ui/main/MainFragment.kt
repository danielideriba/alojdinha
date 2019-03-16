package alodjinha.com.br.ui.main

import alodjinha.com.br.R
import alodjinha.com.br.data.local.entity.Banner
import alodjinha.com.br.ui.BaseFragment
import alodjinha.com.br.ui.adapters.ImageAdapter
import alodjinha.com.br.utils.SLIDE_TIME_DELAY
import alodjinha.com.br.utils.SLIDE_TIME_PERIOD
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*
import javax.inject.Inject

class MainFragment: BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    private  var swipeTimer = Timer()
    private var isTimerRunning = true
    private var nextPage = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.configureViewModel()
        this.getBannerData()

    }

    private fun getBannerData(){
        var banners = viewModel.getAllBanners()
        banners.observe(this, Observer {listBanner->
            if(listBanner != null){
                val imageAdapter = ImageAdapter(view!!.context, listBanner)
                banner.adapter = imageAdapter
            }
            setUpAutoSlider(listBanner)
            indicator.setupWithViewPager(banner, true)
        })
    }

    private fun setUpAutoSlider(listBanner: List<Banner>?) {
        val handler = Handler()
        val update = Runnable {
            nextPage = banner.currentItem +1
            if (nextPage == listBanner?.size) {
                nextPage = 0
            }
            banner.setCurrentItem(nextPage, true)
        }

        swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, 5000, 5000)
    }

    private fun configureViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

}