package moviles.proyecto5.modelo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Producto(
    val id:Int,
    val nombre:String,
    val precio:Double,
    val detalle:Detalle
)
