package dam.moviles.proyecto3practica

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dam.moviles.proyecto3practica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inicializarBinding()
        inicializarViewModel()
        inicializarBotones()
    }

    @Override
    override fun onStart() {
        super.onStart()
        binding.chrReloj.base = viewModel.base
        if(viewModel.isRunning){
            actualizarEstadoBotones(true)
            binding.chrReloj.start()
        }else{
            actualizarEstadoBotones(false)
        }
    }

    private fun actualizarEstadoBotones(b:Boolean){
        viewModel.actualizarEstadoBotones(binding.btnStart,binding.btnStop,binding.btnPausa,binding.btnReset,b)
    }

    private fun inicializarBotones() {
        inicializarBotonStart()
        inicializarBotonStop()
        inicializarBotonPause()
        inicializarBotonReset()
    }

    private fun inicializarBotonPause() {
        binding.btnPausa.setOnClickListener {
            actualizarEstadoBotones(binding.btnStart.isEnabled)
            binding.chrReloj.stop()
            viewModel.isRunning = false
        }
    }

    private fun inicializarBotonReset() {
        binding.btnReset.setOnClickListener {
            reset()
            viewModel.isRunning = false
        }
    }

    private fun inicializarBotonStop() {
        binding.btnStop.setOnClickListener {
            actualizarEstadoBotones(binding.btnStart.isEnabled)
            reset()
            binding.chrReloj.stop()
            viewModel.isRunning = false
        }
    }

    private fun inicializarBotonStart() {
        binding.btnStart.setOnClickListener{
            actualizarEstadoBotones(binding.btnStart.isEnabled)
            reset()
            binding.chrReloj.start()
            viewModel.isRunning = true
        }
    }

    private fun reset(){
        viewModel.base = SystemClock.elapsedRealtime()
        binding.chrReloj.base = viewModel.base
    }



    private fun inicializarBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

}