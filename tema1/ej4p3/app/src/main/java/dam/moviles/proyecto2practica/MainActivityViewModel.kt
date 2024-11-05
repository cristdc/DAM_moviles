package dam.moviles.proyecto2practica

import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {

    val lista = listOf("p", "bd", "s", "fol", "e")
    val lista2 = listOf("m", "i", "s", "e", "a", "h")
    var listaElegida = listOf<String>()

}