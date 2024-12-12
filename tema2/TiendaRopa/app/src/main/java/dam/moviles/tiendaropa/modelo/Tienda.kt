package dam.moviles.tiendaropa.modelo

import android.content.Context
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import dam.moviles.tiendaropa.R

@JsonClass(generateAdapter = true)
class Tienda(val productos:List<Producto>){
    companion object{
        fun inicializar(context: Context):Tienda =
            crearTienda(cargarJson(context))
    }
}

fun cargarJson(context:Context) =
    context.
    resources.
    openRawResource(R.raw.datos).
    bufferedReader().
    readText()

fun crearTienda(json:String):Tienda{
    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(Tienda::class.java)
    val tienda:Tienda = checkNotNull(adapter.fromJson(json))
    return tienda
}