package moviles.proyecto5.vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import moviles.proyecto5.R
import moviles.proyecto5.databinding.FragmentTiendaBinding
import moviles.proyecto5.modelo.cargarDatosJson
import moviles.proyecto5.modelo.convertirJsonEnTienda
import moviles.proyecto5.viewModel.TiendaFragmentViewModel


class TiendaFragment : Fragment(R.layout.fragment_tienda) {

    private lateinit var binding: FragmentTiendaBinding
    private lateinit var viewModel: TiendaFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initializeBinding()
        initializeViewModel()

        val jsonString = cargarDatosJson(requireContext())
        val tienda = convertirJsonEnTienda(jsonString)
        Log.d("testJson", tienda.productos.toString())

        return binding.root
    }

    private fun initializeBinding(){
        binding = FragmentTiendaBinding.inflate(layoutInflater)
    }
    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this).get(TiendaFragmentViewModel::class.java)
    }

}