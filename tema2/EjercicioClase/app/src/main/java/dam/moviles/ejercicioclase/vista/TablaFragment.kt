package dam.moviles.ejercicioclase.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dam.moviles.ejercicioclase.R
import dam.moviles.ejercicioclase.databinding.FragmentTablaBinding
import dam.moviles.ejercicioclase.viewModel.TablaFragmentViewModel

class TablaFragment : Fragment() {

    private lateinit var binding: FragmentTablaBinding
    private lateinit var viewModel: TablaFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarViewModel()
        inicializarEventos()
        return binding.root
    }

    private fun inicializarEventos() {
        binding.btnCalcular.setOnClickListener {
            if(!binding.txtNumero.text.isEmpty()) {
                val navigatorController = findNavController()
                val accion = TablaFragmentDirections.actionTablaFragmentToTablaMultiplicarFragment(binding.txtNumero.text.toString().toInt())
                navigatorController.navigate(accion)
            }else{
                Toast.makeText(context, "Debe ingresar un número", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentTablaBinding.inflate(inflater, container, false)
    }

    fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(TablaFragmentViewModel::class.java)
    }

}