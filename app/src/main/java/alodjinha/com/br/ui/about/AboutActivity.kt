package alodjinha.com.br.ui.about

import alodjinha.com.br.R
import alodjinha.com.br.ui.BaseActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by danielideriba on 20,March,2019
 */

class AboutActivity: BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar()
        setNavigationMenu(nav_view)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.backbtn)
        supportActionBar!!.title = ""

        this.showFragment(savedInstanceState)
    }

    private fun showFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            val fragment = AboutFragment()
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
            val intent = Intent(context, AboutActivity::class.java)
            return intent
        }
    }
}