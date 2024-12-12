package dam.moviles.ej1p3

import android.graphics.Color
import android.os.Bundle
import android.util.Log
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicializarViewModel()
        inicializarMochila()
        setColor()
    }

    private fun setColor() {
        val random = viewModel.random
        val listaColores = listOf(
            R.color.rojo,
            R.color.amarillo,
            R.color.azul,
            R.color.naranja,
            R.color.verde
        )
        val listaNombres:List<String> = listOf(
            getString(R.string.rojo),
            getString(R.string.amarillo),
            getString(R.string.azul),
            getString(R.string.naranja),
            getString(R.string.verde)
        )

        binding.linearLayout.setBackgroundColor(getColor(listaColores[random]))
        binding.txtTexto.setText(listaNombres[random])
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun inicializarMochila() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}