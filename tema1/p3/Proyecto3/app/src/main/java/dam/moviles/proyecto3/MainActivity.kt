package dam.moviles.proyecto3

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dam.moviles.proyecto3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.inicializarMochila()
        this.inicializarViewModel()
        this.inicializarEventos()
    }

    //la app deja de estar en primer plano
    override fun onStop() {
        super.onStop()
        if(viewModel.situacion == Situacion.FUNCIONANDO){
            viewModel.actualizarTiempoTranscurrido()
            binding.chrReloj.stop()
        }

    }

    override fun onRestart() {
        super.onRestart()
        if(viewModel.situacion == Situacion.FUNCIONANDO){
            viewModel.actualizarTiempoTranscurrido()
            binding.chrReloj.stop()
        }
    }

    override fun onStart() {
        super.onStart()
        //restauramos el estado de la app
        when(viewModel.situacion){
            Situacion.PARADO -> {}
            Situacion.FUNCIONANDO -> {
                habilitarStart(false)
                binding.chrReloj.base = viewModel.base
                binding.chrReloj.start()
            }
            Situacion.PAUSA -> {
                habilitarStart(true)
                viewModel.reiniciarConTiempoTranscurrido(binding.chrReloj)
            }
        }
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun inicializarEventos() {
        binding.apply {
            btnInicio.setOnClickListener { iniciar() }
            btnStop.setOnClickListener { detener() }
            btnPausa.setOnClickListener { pausar() }
            btnReiniciar.setOnClickListener { viewModel.reiniciar(binding.chrReloj) }
        }
    }

    private fun iniciar() {
        habilitarStart(false)
        when (viewModel.situacion) {
            Situacion.PARADO -> viewModel.reiniciar(binding.chrReloj)
            Situacion.PAUSA -> viewModel.reiniciarConTiempoTranscurrido(binding.chrReloj)
            Situacion.FUNCIONANDO -> {}
        }
        binding.chrReloj.start()
        viewModel.situacion = Situacion.FUNCIONANDO
    }

    private fun detener() {
        binding.chrReloj.stop()
        viewModel.reiniciar(binding.chrReloj)
        habilitarStart(true)
        viewModel.situacion=Situacion.PARADO
    }
    private fun pausar() {
        viewModel.actualizarTiempoTranscurrido()
        binding.chrReloj.stop()
        viewModel.situacion = Situacion.PAUSA
        habilitarStart(true)
    }

    private fun inicializarMochila() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun habilitarStart(b: Boolean) {
        binding.btnInicio.isEnabled = b
        binding.btnStop.isEnabled = !b
        binding.btnReiniciar.isEnabled = !b
        binding.btnPausa.isEnabled = !b
    }
}