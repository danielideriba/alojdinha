package alodjinha.com.br.ui.adapters

import alodjinha.com.br.R
import alodjinha.com.br.data.local.entity.Produto
import alodjinha.com.br.data.remote.model.ProdutoMaisVendidos
import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_best_sellers_item.view.*
import timber.log.Timber

/**
 * Created by danielideriba on 17,March,2019
 */

class BestSellersAdapter(val context: Context, val items : List<Produto>) : RecyclerView.Adapter<ViewHolderBestSellers>() {
    override fun onBindViewHolder(holder: ViewHolderBestSellers, position: Int) {
        holder?.ivTitulo?.text = items.get(position).nome
        holder?.tvPrecoDe?.text = "De: ${items.get(position).precoDe.toString()}"
        holder?.tvPrecoPor?.text = "Por: ${items.get(position).precoPor.toString()}"
        Picasso.get().load(items.get(position).urlImagem).into(holder?.ivFoto)
        holder?.tvPrecoDe.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBestSellers {
        return ViewHolderBestSellers(LayoutInflater.from(context).inflate(R.layout.product_best_sellers_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolderBestSellers (view: View) : RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            Timber.d("LOL")
        }
    }

    val ivFoto = view.ivFoto!!
    val ivTitulo = view.tvTitulo!!
    var tvPrecoDe = view.tvPrecoDe!!
    var tvPrecoPor = view.tvPrecoPor!!


}