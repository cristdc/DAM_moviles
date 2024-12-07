package moviles.proyecto5.modelo

import android.content.Context
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import moviles.proyecto5.R

@JsonClass(generateAdapter = true)
data class Tienda(@Json(name="productos") val productos: List<Producto>){
    companion object{
        fun inicializar(context:Context):Tienda =
            convertirJsonEnTienda(cargarDatosJson(context))
    }
}



