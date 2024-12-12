package dam.moviles.tiendaropa.modelo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Producto(
    val id:Int,
    val nombre:String,
    val precio:Double,
    val disponible:Boolean,
    val detalles:Detalle
)