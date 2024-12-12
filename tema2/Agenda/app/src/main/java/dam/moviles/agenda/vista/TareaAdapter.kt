package dam.moviles.agenda.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.moviles.agenda.databinding.TareaBinding
import dam.moviles.agenda.modelo.Tarea

class TareaAdapter (
    var tareas: MutableList<Tarea> = mutableListOf(),
    val lambda : (TareaHolder) -> Unit
):RecyclerView.Adapter<TareaHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TareaBinding.inflate(inflater, parent, false)
        return TareaHolder(binding)
    }

    override fun getItemCount(): Int {
        return tareas.size
    }

    override fun onBindViewHolder(holder: TareaHolder, position: Int) {
        val agenda = tareas[position]
        holder.mostrarTarea(agenda)
        holder.binding.root.setOnClickListener {
            lambda(holder)
        }
    }

    fun actualizarTareas(tarea: MutableList<Tarea>){
        tareas = tarea
        notifyDataSetChanged()
    }
}

