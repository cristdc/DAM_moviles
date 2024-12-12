package dam.moviles.ejercicioclase.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import dam.moviles.ejercicioclase.databinding.FragmentTablaBinding
import dam.moviles.ejercicioclase.databinding.MultiplicacionBinding

class MultiplicacionAdapter(
    var multiplicaciones: Int,
):RecyclerView.Adapter<MultiplicacionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiplicacionHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MultiplicacionBinding.inflate(inflater,parent,false)
        return MultiplicacionHolder(binding)
    }

    override fun getItemCount(): Int {
        return 11
    }

    override fun onBindViewHolder(holder: MultiplicacionHolder, position: Int) {
        holder.mostrarMultiplicacion(multiplicaciones,position)
    }

    fun setListaMultiplicaciones(m:Int){
        multiplicaciones=m
        notifyDataSetChanged()
    }

}
