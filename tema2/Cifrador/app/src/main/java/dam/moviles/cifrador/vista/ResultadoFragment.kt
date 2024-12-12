package dam.moviles.cifrador.vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dam.moviles.cifrador.R
import dam.moviles.cifrador.databinding.FragmentMensajeBinding
import dam.moviles.cifrador.databinding.FragmentResultadoBinding
import dam.moviles.cifrador.viewmodel.MensajeFragmentViewModel
import dam.moviles.cifrador.viewmodel.ResultadoFragmentViewModel

class ResultadoFragment : Fragment() {

    private lateinit var viewModel: ResultadoFragmentViewModel
    private lateinit var binding: FragmentResultadoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarViewModel()
        inicializarRecyclerView()
        return binding.root
    }

    private fun inicializarRecyclerView() {
        binding.recResultados.adapter =  CifradoAdapter(
            viewModel.listaCifrados,
            viewModel.listaResultados
        ) {
            Log.d("Cifrador", "Cifrado seleccionado: ${it.cifrado}")
        }
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentResultadoBinding.inflate(inflater, container, false)
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(ResultadoFragmentViewModel::class.java)
        val mensajeOriginal = ResultadoFragmentArgs.fromBundle(requireArguments()).mensaje
        val listaNumerosCifrados = ResultadoFragmentArgs.fromBundle(requireArguments()).cifradosSeleccionados
        viewModel.inicializarCifrados(listaNumerosCifrados)
        viewModel.cifrar(mensajeOriginal)
    }
}