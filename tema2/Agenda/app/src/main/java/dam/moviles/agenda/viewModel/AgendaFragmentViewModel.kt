package dam.moviles.agenda.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import dam.moviles.agenda.modelo.Agenda
import dam.moviles.agenda.modelo.Tarea
import java.io.FileWriter

class AgendaFragmentViewModel: ViewModel() {

    var tareas: MutableList<Tarea> = mutableListOf()

    fun cargarTareas(context:Context){
        tareas = Agenda.cargarTareas(context)
    }

    fun crearTarea(tarea: Tarea, context: Context){
        tareas.add(tarea)
        Agenda(tareas).guardarTareas(context)
    }

}