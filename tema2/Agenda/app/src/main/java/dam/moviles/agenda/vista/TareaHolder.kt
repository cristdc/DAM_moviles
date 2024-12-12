package dam.moviles.agenda.vista

import androidx.recyclerview.widget.RecyclerView
import dam.moviles.agenda.databinding.TareaBinding
import dam.moviles.agenda.modelo.Tarea

class TareaHolder(val binding: TareaBinding):RecyclerView.ViewHolder(binding.root) {

    lateinit var tarea: Tarea

    fun mostrarTarea(tarea: Tarea){
        this.tarea = tarea
        binding.txtNombre.text = tarea.nombre
        binding.txtFecha.text = tarea.fechaEntrega
        binding.checkBox.isChecked = tarea.realizado
        inicializarBotonMarcar()
    }

    fun inicializarBotonMarcar(){
        binding.btnMarcar.setOnClickListener {
            binding.checkBox.isChecked = !binding.checkBox.isChecked
        }
    }
}