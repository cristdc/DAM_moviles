package dam.moviles.ej1p3

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel:ViewModel() {

    val random = Random.nextInt(0,5)


}