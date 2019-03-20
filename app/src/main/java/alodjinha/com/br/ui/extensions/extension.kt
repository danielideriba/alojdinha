package alodjinha.com.br.ui.extensions

import android.os.Build
import android.text.Html
import android.text.Spanned

/**
 * Created by danielideriba on 20,March,2019
 */

fun String.toSpanned() : Spanned {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        return Html.fromHtml(this)
    }
}