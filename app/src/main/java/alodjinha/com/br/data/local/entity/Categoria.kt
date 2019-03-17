package alodjinha.com.br.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by danielideriba on 12,March,2019
 */
@Entity
class Categoria (
    var descricao: String = "",
    var urlImagem: String = "",
    @PrimaryKey(autoGenerate = true) var id: Long?
)