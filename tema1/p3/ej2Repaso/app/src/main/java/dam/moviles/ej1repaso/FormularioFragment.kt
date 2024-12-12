package dam.moviles.ej1repaso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dam.moviles.ej1repaso.databinding.FragmentFormularioBinding
import java.io.File
import java.io.FileWriter

class FormularioFragment : Fragment() {

    private lateinit var binding: FragmentFormularioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarBoton()

        return binding.root
    }

    private fun inicializarBoton() {
        binding.btnGuardar.setOnClickListener {
            val fileWriter = FileWriter(File(context?.getFilesDir(),"bloc_notas_txt"))
            fileWriter.write(binding.txtTexto.text.toString())
            fileWriter.close()
        }
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentFormularioBinding.inflate(inflater, container, false)
    }

}