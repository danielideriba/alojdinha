package alodjinha.com.br.ui.adapters

import alodjinha.com.br.R
import alodjinha.com.br.data.local.entity.Categoria
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_category_item.view.*

/**
 * Created by danielideriba on 17,March,2019
 */

class CategoryProductAdapter(val context: Context, val items : List<Categoria>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.ivTitulo?.text = items.get(position).descricao
        Picasso.get().load(items.get(position).urlImagem).into(holder?.ivFoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_category_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val ivFoto = view.ivFoto!!
    val ivTitulo = view.tvTitulo!!
}