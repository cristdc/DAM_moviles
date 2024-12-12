package dam.moviles.cifrador.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dam.moviles.cifrador.R
import dam.moviles.cifrador.databinding.FragmentBienvenidaBinding

class BienvenidaFragment : Fragment() {

    private lateinit var binding: FragmentBienvenidaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarEventos()
        return binding.root
    }

    private fun inicializarEventos() {
        binding.btnComenzar.setOnClickListener {
            val navigatonController = findNavController()
            val accion = BienvenidaFragmentDirections.actionBienvenidaFragmentToMensajeFragment()
            navigatonController.navigate(accion)
        }
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentBienvenidaBinding.inflate(inflater, container, false)
    }

}