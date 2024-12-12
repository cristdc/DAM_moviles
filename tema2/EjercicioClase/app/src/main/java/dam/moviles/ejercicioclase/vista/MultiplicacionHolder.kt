package dam.moviles.ejercicioclase.vista

import androidx.recyclerview.widget.RecyclerView
import dam.moviles.ejercicioclase.databinding.FragmentTablaBinding
import dam.moviles.ejercicioclase.databinding.MultiplicacionBinding

class MultiplicacionHolder(val binding: MultiplicacionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun mostrarMultiplicacion(numeroIntroducido: Int, num: Int) {
        binding.txtNumeroEscrito.text = numeroIntroducido.toString()
        binding.txtNumeroTabla.text = num.toString()
        binding.txtResultado.text = (numeroIntroducido*num).toString()
    }
}
