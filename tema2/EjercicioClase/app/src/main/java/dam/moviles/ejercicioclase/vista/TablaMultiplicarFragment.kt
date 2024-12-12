package dam.moviles.ejercicioclase.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dam.moviles.ejercicioclase.databinding.FragmentTablaMultiplicarBinding
import dam.moviles.ejercicioclase.viewModel.TablaMultiplicarFragmentViewModel

class TablaMultiplicarFragment : Fragment() {

    private lateinit var binding: FragmentTablaMultiplicarBinding
    private lateinit var viewModel: TablaMultiplicarFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarViewModel()
        inicializarRecyclerView()
        return binding.root
    }

    fun inicializarRecyclerView() {
        viewModel.setMultiplicacion(TablaMultiplicarFragmentArgs.fromBundle(requireArguments()).mensaje)
        val adapter = MultiplicacionAdapter(viewModel.multiplicaciones)

        binding.recyclerView.adapter = adapter
    }

    fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentTablaMultiplicarBinding.inflate(inflater, container, false)
    }

    fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(TablaMultiplicarFragmentViewModel::class.java)
    }

}