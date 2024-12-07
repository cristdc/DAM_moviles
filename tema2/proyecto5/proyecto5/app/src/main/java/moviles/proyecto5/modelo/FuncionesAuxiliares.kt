package moviles.proyecto5.modelo

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import moviles.proyecto5.R
import java.io.BufferedReader
import java.io.InputStream

/* context es un objeto que nos permite acceder a recursos de la aplicación, como archivos, imágenes, etc. */
/* como conseguimos un context,
cuando estamos en una actividad, podemos usar this, cuando estamos en un fragmento, podemos usar requireContext()
*/

fun cargarDatosJson(context: Context):String{
    val carpetaRecursos = context.resources
    val archivo: InputStream = carpetaRecursos.openRawResource(R.raw.datos)
    val buffer:BufferedReader = archivo.bufferedReader()
    val texto:String = buffer.use { it.readText() }
    return texto
}
fun convertirJsonEnTienda(json:String):Tienda{
    val mochi:Moshi = Moshi.Builder().build()
    val adapter = mochi.adapter(Tienda::class.java)
    val tienda:Tienda? = adapter.fromJson(json)
    return checkNotNull(tienda) {"Error al convertir el JSON en Tienda"}
}
