package dam.moviles.proyecto2practica

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dam.moviles.proyecto2practica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.inicializarBinding()
        inicializarViewModel()
        this.inicializarBotones()
    }

    @Override
    override fun onStart() {
        super.onStart()
        actualizarTexto()
    }

    private fun inicializarBotones() {
        this.inicializarBotonSeleccionarCurso()
        this.inicializarBotonEnviar()
    }

    private fun inicializarBotonSeleccionarCurso() {

        binding.btnSeleccionar.setOnClickListener {
            val seleccionado = binding.spnCurso.selectedItem.toString()
            val cursos = getListaCursos(seleccionado)
            viewModel.listaElegida = cursos
            actualizarTexto()
        }
    }

    private fun actualizarTexto(){
        val texto = getTextoAsignaturas(viewModel.listaElegida)
        binding.txtCurso.text = texto
    }


    fun getTextoAsignaturas(cursos: List<String>): String {
        var texto = ""
        for (a in cursos) {
            texto += a + "\n"
        }
        return texto
    }

    fun getListaCursos(seleccionado: String): List<String> {
        return when (seleccionado) {
            "1º DAM" -> viewModel.lista
            "2º DAM" -> viewModel.lista2
            else -> throw Exception("Curso no admitido")
        }
    }

    private fun inicializarBotonEnviar() {
        binding.btnEnviar.setOnClickListener {

            val texto = binding.txtObservaciones.text.toString()
            Toast.makeText(this, getString(R.string.mensaje, texto), Toast.LENGTH_LONG).show()

        }
    }

    private fun inicializarBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }
}