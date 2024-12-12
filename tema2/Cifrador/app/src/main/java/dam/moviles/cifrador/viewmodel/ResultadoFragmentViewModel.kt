package dam.moviles.cifrador.viewmodel

import androidx.lifecycle.ViewModel
import dam.moviles.cifrador.modelo.AlgoritmoCifrado
import dam.moviles.cifrador.modelo.getAlgoritmoCifrado

class ResultadoFragmentViewModel:ViewModel() {
    lateinit var listaCifrados:List<AlgoritmoCifrado>
    lateinit var listaResultados:List<String>

    fun inicializarCifrados(listaResultados:IntArray){
        listaCifrados = listaResultados.map { numero -> getAlgoritmoCifrado(numero) }
    }
    fun cifrar(mensaje:String){
        listaResultados = listaCifrados.map { cifrador -> cifrador.cifrar(mensaje) }
    }
}