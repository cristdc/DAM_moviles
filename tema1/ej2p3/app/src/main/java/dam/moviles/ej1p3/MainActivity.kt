package dam.moviles.ej1p3

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dam.moviles.ej1p3.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    var random = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        inicializarViewModel()
        inicializarMochila()
        inicializarBotonJugar()
    }

    @Override
    override fun onStart() {
        super.onStart()
        reiniciarJuego()

    }

    private fun inicializarBotonJugar() {
        binding.btnJugar.setOnClickListener {
            val numIntroducido = binding.txtNumero.text.toString().toIntOrNull()
            if (numIntroducido != null) {
                manejarIntento(numIntroducido)
            } else {
                makeToast(getString(R.string.toastGanar))
            }
        }
    }

    private fun manejarIntento(numIntroducido: Int) {
        if (numIntroducido == random) {
            manejarAcierto()
        } else {
            manejarError(numIntroducido)
        }
    }

    private fun manejarAcierto() {
        makeToast(getString(R.string.toastGanar))
        reiniciarJuego() // Reinicia el juego después de un acierto
    }

    private fun manejarError(numIntroducido: Int) {
        restarVidas()
        actualizarTextoVidas()

        if (viewModel.vidasRestantes == 0) {
            makeToast(getString(R.string.toastPerderDefinitivo))
            reiniciarJuego() // Reinicia el juego cuando se acaban las vidas
        } else {
            makeToast(getString(R.string.toastPerder, obtenerTextoToast(numIntroducido)))
        }
    }



    private fun reiniciarJuego() {
        viewModel.reiniciarJuego()
        random = viewModel.getRandom()
        actualizarTextoVidas()
    }


    private fun actualizarTextoVidas() {
        binding.txtVidas.text = viewModel.vidasRestantes.toString()
    }

    private fun obtenerTextoToast(numIntroducido: Int): String {
        return if (numIntroducido > random) "mayor" else "menor"
    }

    private fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    private fun restarVidas() {
        viewModel.vidasRestantes--
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun inicializarMochila() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}