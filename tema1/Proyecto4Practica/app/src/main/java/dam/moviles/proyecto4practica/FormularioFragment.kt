package dam.moviles.proyecto4practica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import dam.moviles.proyecto4practica.databinding.FragmentFormularioBinding

class FormularioFragment : Fragment() {

    private var _binding: FragmentFormularioBinding? = null
    private val binding: FragmentFormularioBinding
        get() = checkNotNull(_binding) { "Debes usar binding entre onCreateView y onDestroyView" }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarBotones()
        inicializarToolbar()
        return _binding?.root
    }

    private fun inicializarToolbar() {
        val mainActivity:MainActivity = activity as MainActivity
        // mainActivity.setSupportActionBar(binding.toolbar)
    }

    private fun getListaBotones(): List<ImageView> = listOf(
        binding.btnBebida1,
        binding.btnBebida2,
        binding.btnBebida3
    )

    private fun desactivarBotones() {
        getListaBotones()
            .forEach { boton -> boton.alpha = 0.5F }
    }

    private fun pulsarBoton(boton: ImageView) {
        desactivarBotones()
        boton.alpha = 1F
    }

    private fun inicializarBotones() {
        desactivarBotones()
        getListaBotones().forEach { boton ->
            boton.setOnClickListener {
                pulsarBoton(boton)
            }
        }
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        _binding = FragmentFormularioBinding.inflate(inflater, container, false)
    }
}