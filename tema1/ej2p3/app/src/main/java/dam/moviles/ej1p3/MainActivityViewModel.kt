package dam.moviles.ej1p3

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel:ViewModel() {

    var vidasRestantes = 4
    var numRandom = getRandom()

    fun getRandom():Int{
        return Random.nextInt(1,11)
    }

    fun reiniciarJuego() {
        vidasRestantes = 4
        numRandom = getRandom()
    }

}