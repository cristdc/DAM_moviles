package dam.moviles.ejercicioclase.viewModel

import androidx.lifecycle.ViewModel

class TablaMultiplicarFragmentViewModel: ViewModel() {

    var multiplicaciones:Int = 0

    fun setMultiplicacion(num:Int){
        multiplicaciones = num
    }

}