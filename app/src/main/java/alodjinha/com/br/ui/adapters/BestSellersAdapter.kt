package alodjinha.com.br.ui.adapters

import alodjinha.com.br.R
import alodjinha.com.br.data.local.entity.ProdutoMaisVendidos
import alodjinha.com.br.utils.Utils
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_best_sellers_item.view.*

/**
 * Created by danielideriba on 17,March,2019
 */

class BestSellersAdapter(val context: Context, val items : List<ProdutoMaisVendidos>) : RecyclerView.Adapter<ViewHolderBestSellers>() {
    override fun onBindViewHolder(holder: ViewHolderBestSellers, position: Int) {
        holder?.ivTitulo?.text = items.get(position).descricao
        holder?.tvPrecoDe?.text = Utils.currency(items.get(position).precoDe)
        holder?.tvPrecoPor?.text = Utils.currency(items.get(position).precoPor)
        Picasso.get().load(items.get(position).urlImagem).into(holder?.ivFoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBestSellers {
        return ViewHolderBestSellers(LayoutInflater.from(context).inflate(R.layout.product_best_sellers_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolderBestSellers (view: View) : RecyclerView.ViewHolder(view) {
    val ivFoto = view.ivFoto!!
    val ivTitulo = view.tvTitulo!!
    var tvPrecoDe = view.tvPrecoDe!!
    var tvPrecoPor = view.tvPrecoPor!!
}