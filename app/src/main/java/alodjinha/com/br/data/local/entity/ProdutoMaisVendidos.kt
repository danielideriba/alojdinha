package alodjinha.com.br.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by danielideriba on 17,March,2019
 */

@Entity
class ProdutoMaisVendidos (
    var descricao: String = "",
    var nome: String = "",
    var precoDe: Number = 0.0,
    var precoPor: Number = 0.0,
    var urlImagem: String = "",
    @PrimaryKey(autoGenerate = true) var id: Long?
)