package dam.moviles.tiendaropa.modelo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Detalle (
    val color:String,
    val tallas:List<String>
)