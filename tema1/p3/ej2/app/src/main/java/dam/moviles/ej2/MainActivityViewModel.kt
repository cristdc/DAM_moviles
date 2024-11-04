package dam.moviles.ej2

import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel:ViewModel() {

    var vidasRestantes = 4
    var random = Random.nextInt(0, 11)

    fun reiniciarJuego() {
        vidasRestantes = 4
        random = Random.nextInt(0, 11)
    }
    fun restarVidas(){
        vidasRestantes--
    }



}