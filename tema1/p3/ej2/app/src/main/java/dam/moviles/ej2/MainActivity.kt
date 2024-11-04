package dam.moviles.ej2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dam.moviles.ej2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.inicializarViewModel()
        this.inicializarMochila()

        this.updateVidas()

        binding.btnJugar.setOnClickListener{
            this.adivinar()
        }
    }


    private fun adivinar() {
        val numAdivinado = Integer.parseInt(binding.num.text.toString())

        if (numAdivinado != viewModel.random) {
            viewModel.restarVidas()

            if (numAdivinado < viewModel.random) {
                mostrarMensajeToast("El número introducido es menor que el número")
            } else {
                mostrarMensajeToast("El número introducido es mayor que el número")
            }

            if(viewModel.vidasRestantes==0){
                mostrarMensajeToast("Has perdido, te has quedado sin intentos")
                viewModel.reiniciarJuego()
            }

        } else {
            mostrarMensajeToast("Has ganado, el número era: "+viewModel.random)
            viewModel.reiniciarJuego()
        }
        updateVidas()

    }

    private fun updateVidas() {
        binding.vidas.text = viewModel.vidasRestantes.toString()
    }


    private fun mostrarMensajeToast(mensaje:String){
        Toast.makeText(this,mensaje, Toast.LENGTH_LONG).show()
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun inicializarMochila() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}