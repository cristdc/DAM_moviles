package dam.moviles.agenda.vista

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.Moshi
import dam.moviles.agenda.databinding.FragmentAgendaBinding
import dam.moviles.agenda.modelo.Agenda
import dam.moviles.agenda.modelo.Tarea
import dam.moviles.agenda.viewModel.AgendaFragmentViewModel
import org.json.JSONObject
import java.io.File

class AgendaFragment : Fragment() {

    private lateinit var binding: FragmentAgendaBinding
    private lateinit var viewModel: AgendaFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarViewModel()
        inicializarRecyclerView()
        inicializarBotonAñadirTarea()
        return binding.root
    }

    private fun inicializarBotonAñadirTarea(){
        binding.btnCrearTarea.setOnClickListener {
            val tarea = Tarea(binding.txtNombreTarea.text.toString(), binding.txtFechaEntrega.text.toString())
            viewModel.crearTarea(tarea, requireContext())
            (binding.recyclerView.adapter as TareaAdapter).actualizarTareas(viewModel.tareas)
            Toast.makeText(requireContext(), "Tarea creada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inicializarRecyclerView(){
        val adapter = TareaAdapter(viewModel.tareas){
            Toast.makeText(requireContext(), "Tarea seleccionada", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.adapter = adapter
    }

    fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentAgendaBinding.inflate(inflater, container, false)
    }

    fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(AgendaFragmentViewModel::class.java)
        viewModel.cargarTareas(requireContext())
    }

}