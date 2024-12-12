package dam.moviles.cifrador.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dam.moviles.cifrador.R
import dam.moviles.cifrador.databinding.FragmentBienvenidaBinding
import dam.moviles.cifrador.databinding.FragmentMensajeBinding
import dam.moviles.cifrador.viewmodel.MensajeFragmentViewModel

class MensajeFragment : Fragment() {

    private lateinit var viewModel: MensajeFragmentViewModel
    private lateinit var binding: FragmentMensajeBinding

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
        binding.btnCifrar.setOnClickListener {
            val mensaje = binding.txtMensaje.text.toString()
            val cifradosSeleccionados = getCasillasSeleccionadas()
            val navigationController = findNavController()
            val action = MensajeFragmentDirections
                .actionMensajeFragmentToResultadoFragment(mensaje,cifradosSeleccionados)
            navigationController.navigate(action)
        }
    }

    private fun getNumero(c: CheckBox):Int = binding.linearLayout.indexOfChild(c)
    private fun getCasillasSeleccionadas():IntArray =
        listOf(binding.chkCifrado1,binding.chkCifrado2,binding.chkCifrado3)
            .filter { casilla -> casilla.isChecked }
            .map { casilla -> getNumero(casilla) }
            .toIntArray()

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentMensajeBinding.inflate(inflater, container, false)
    }
    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(MensajeFragmentViewModel::class.java)
    }

}