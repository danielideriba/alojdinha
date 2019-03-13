package alodjinha.com.br.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by danielideriba on 12,March,2019
 */

@Entity
class Produto (
    var descricao: String = "",
    var nome: String = "",
    var precoDe: Int = 0,
    var precoPor: Int = 0,
    var urlImagem: String = "",
    var lastRefresh: Date? = null,
    @PrimaryKey(autoGenerate = true) var id: Long?
)