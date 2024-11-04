package dam.moviles.ej1

import android.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {


    val listaNombres:List<String> = listOf("rojo","amarillo","verde","azul","negro","naranja")
    val listaColores:List<Int> = listOf(Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE,Color.BLACK,Color.rgb(255,165,0))

    var random:Int = Random.nextInt(0, listaNombres.size-1)

    fun getBackgroundColor() = listaColores.get(random)
    fun getText() = listaNombres.get(random)

}