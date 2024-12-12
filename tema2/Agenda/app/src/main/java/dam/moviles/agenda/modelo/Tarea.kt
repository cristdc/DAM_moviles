package dam.moviles.agenda.modelo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tarea(
    val nombre : String,
    val fechaEntrega : String,
    val realizado : Boolean = false
)
{

}