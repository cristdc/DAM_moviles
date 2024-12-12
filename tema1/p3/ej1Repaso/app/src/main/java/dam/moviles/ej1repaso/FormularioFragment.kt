package dam.moviles.ej1repaso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dam.moviles.ej1repaso.databinding.FragmentFormularioBinding

class FormularioFragment : Fragment() {

    private lateinit var binding: FragmentFormularioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarBotones()

        return binding.root
    }

    private fun inicializarBotones() {
        inicializarBotonSumar()
        inicializarBotonRestar()
        inicializarBotonDividir()
        inicializarBotonMultiplicar()
    }

    private fun inicializarBotonMultiplicar() {
        binding.btnMultiplicar.setOnClickListener {
            mostrarResultado(getResultado("x"))
        }
    }
    private fun inicializarBotonDividir() {
        binding.btnDividir.setOnClickListener {
            mostrarResultado(getResultado("/"))
        }
    }
    private fun inicializarBotonRestar() {
        binding.btnRestar.setOnClickListener {
            mostrarResultado(getResultado("-"))
        }
    }
    private fun inicializarBotonSumar() {
        binding.btnSumar.setOnClickListener {
            mostrarResultado(getResultado("+"))
        }
    }

    private fun getResultado(simbolo:String): Double {
        return when(simbolo){
            "+" -> sumar(getNum(),getNum2())
            "-" -> restar(getNum(),getNum2())
            "/" -> dividir(getNum(),getNum2())
            "x" -> multiplicar(getNum(),getNum2())
            else -> {0.0}
        }
    }

    private fun mostrarResultado(resultado:Double){
        binding.txtResultado.setText(resultado.toString())
    }

    private fun sumar(num: Double, num2: Double): Double {
        return num + num2
    }

    private fun restar(num: Double, num2: Double): Double {
        return num - num2
    }

    private fun dividir(num: Double, num2: Double): Double {
        return num / num2
    }

    private fun multiplicar(num: Double, num2: Double): Double {
        return num * num2
    }

    private fun getNum(): Double {
        return binding.txtNumero.text.toString().toDouble()
    }
    private fun getNum2(): Double {
        return binding.txtNumero2.text.toString().toDouble()
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentFormularioBinding.inflate(inflater, container, false)
    }

}