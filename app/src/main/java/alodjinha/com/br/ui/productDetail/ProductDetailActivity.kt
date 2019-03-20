package alodjinha.com.br.ui.productDetail

import alodjinha.com.br.R
import alodjinha.com.br.ui.BaseActivity
import alodjinha.com.br.utils.PRODUCT_ID
import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by danielideriba on 19,March,2019
 */

class ProductDetailActivity: BaseActivity(){
    private var productId: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar()
        setNavigationMenu(nav_view)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.backbtn)
        supportActionBar!!.title = ""

        if(intent.hasExtra(PRODUCT_ID)){
            productId = intent.getStringExtra(PRODUCT_ID)
        }

        this.showFragment(savedInstanceState)
    }

    private fun showFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            val fragment = ProductDetailFragment()
            val args = Bundle()
            args.putString(PRODUCT_ID, productId)
            fragment.arguments = args
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, null)
                .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProductDetailActivity::class.java)
            return intent
        }
    }
}