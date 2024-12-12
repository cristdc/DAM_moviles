package dam.moviles.cifrador.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.moviles.cifrador.databinding.ItemCifradoBinding
import dam.moviles.cifrador.modelo.AlgoritmoCifrado

class CifradoAdapter (
    val listaCifrados:List<AlgoritmoCifrado>,
    val listaResultados:List<String>,
    val lamdba:(ResultadoViewHolder) -> Unit
):RecyclerView.Adapter<ResultadoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultadoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCifradoBinding.inflate(inflater,parent,false)
        return ResultadoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultadoViewHolder, position: Int) {
        val cifrado = listaCifrados[position]
        val mensajeCifrado = listaResultados.get(position)
        holder.mostrarResultado(cifrado,mensajeCifrado)
        holder.binding.root.setOnClickListener {
            lamdba(holder)
        }
    }

    override fun getItemCount(): Int = listaCifrados.size
}