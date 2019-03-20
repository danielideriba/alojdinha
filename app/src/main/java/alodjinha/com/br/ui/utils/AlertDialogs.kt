package alodjinha.com.br.ui.utils

import alodjinha.com.br.R
import android.content.Context
import android.content.DialogInterface

/**
 * Created by danielideriba on 20,March,2019
 */

object AlertDialogs {
    fun dialog(context: Context, msg: String) {
        val alertDialog = android.app.AlertDialog.Builder(context)
            .setMessage(msg)
            .setPositiveButton(context.resources.getString(R.string.ok),
                DialogInterface.OnClickListener { dialogInterface, i -> return@OnClickListener })
            .setCancelable(false)
            .show()
    }
}