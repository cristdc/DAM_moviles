package dam.moviles.cifrador.vista

import androidx.recyclerview.widget.RecyclerView
import dam.moviles.cifrador.databinding.ItemCifradoBinding
import dam.moviles.cifrador.modelo.AlgoritmoCifrado

class ResultadoViewHolder(val binding:ItemCifradoBinding):RecyclerView.ViewHolder(binding.root) {

    var cifrado:String=""
    var mensaje:String=""

    fun mostrarResultado(c:AlgoritmoCifrado,m:String){
        cifrado =c.nombre
        mensaje =m
        binding.txtNombreCifrado.text = c.nombre
        binding.imgCifrado.setImageResource(c.idIcono)
        binding.txtMensajeCifrado.text = mensaje
    }
}