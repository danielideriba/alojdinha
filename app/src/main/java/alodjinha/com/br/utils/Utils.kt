package alodjinha.com.br.utils

import java.text.NumberFormat
import java.util.*

/**
 * Created by danielideriba on 17,March,2019
 */
object Utils{
    fun currency(number: Number): String? {
        val format = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        return format.format(number)
    }
}