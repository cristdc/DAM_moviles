package dam.moviles.ej1repaso

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dam.moviles.ej1repaso.databinding.FragmentFormularioBinding
import java.io.File
import java.io.FileWriter
import kotlin.random.Random

class FormularioFragment : Fragment() {

    private lateinit var binding: FragmentFormularioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarBotonJugar()
        return binding.root

    }

    private fun inicializarBotonJugar() {
        val random = getRandom()
        binding.btnJugar.setOnClickListener {
            val diferencia:Int = valorAbsolutoDiferencia(getRandom(),random)

            if(getNum()<random){
                setText(R.string.corto)
            }else if(getNum()>random){
                setText(R.string.pasado)
            }else{

            }

        }
    }

    private fun setText(mensaje:Int){
        binding.txtTexto.setText(mensaje)
    }

    private fun valorAbsolutoDiferencia(random:Int, num:Int):Int{
        return Math.abs(random)-Math.abs(num)
    }

    private fun getNum():Int{
        return binding.txtNumero.text.toString().toInt()
    }

    private fun getRandom():Int{
        return Random.nextInt(1,101)
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentFormularioBinding.inflate(inflater, container, false)
    }

}