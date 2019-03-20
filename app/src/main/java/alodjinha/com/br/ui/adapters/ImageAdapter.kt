package alodjinha.com.br.ui.adapters;

import alodjinha.com.br.R
import alodjinha.com.br.data.local.entity.Banner
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_image_page.view.*

class ImageAdapter (
    private var context: Context,
    private val photoSlide : List<Banner>?): PagerAdapter(){

    override fun destroyItem(container: ViewGroup, position:Int, `object` :Any){
            container.removeView(`object` as View)
        }

    override fun getCount():Int{
        return photoSlide!!.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view:View = LayoutInflater.from(context).inflate(R.layout.single_image_page, container,false)

        Picasso.get().load(photoSlide?.get(position)?.urlImagem).into(view.imageView)
        container?.addView(view,0)

        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view?.equals(`object`)!!
    }
}
