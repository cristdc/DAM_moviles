package dam.moviles.ej3

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dam.moviles.ej3.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.inicializarViewModel()
        this.inicializarMochila()

        binding.btnCronometro.setOnClickListener {
            this.cuentaAtras()
            this.disableOptions()
        }
    }

    private fun cuentaAtras() {
        binding.chrn.isCountDown = true

        viewModel.segundos(binding.chrn, binding.segundos)
        binding.chrn.start()

        binding.chrn.onChronometerTickListener =
            Chronometer.OnChronometerTickListener { chronometer ->
                if (SystemClock.elapsedRealtime() >= binding.chrn.base) {
                    binding.chrn.stop()
                    enableOptions()
                }

            }

    }

    private fun disableOptions() {
        binding.chrn.isEnabled = true
        binding.segundos.isEnabled = false
        binding.btnCronometro.isEnabled = false
    }

    private fun enableOptions() {
        binding.chrn.isEnabled = false
        binding.segundos.isEnabled = true
        binding.btnCronometro.isEnabled = true
    }


    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun inicializarMochila() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}