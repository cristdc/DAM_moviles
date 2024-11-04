package dam.moviles.proyecto2practica

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dam.moviles.proyecto2practica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.inicializarBinding()
        this.inicializarBotones()
    }

    private fun inicializarBotones() {
        this.inicializarBotonSeleccionarCurso()
        this.inicializarBotonEnviar()
    }

    private fun inicializarBotonSeleccionarCurso() {

        binding.btnSeleccionar.setOnClickListener {
            val seleccionado = binding.spnCurso.selectedItem.toString()
            val cursos = getListaCursos(seleccionado)
            val texto = getTextoAsignaturas(cursos)
            binding.txtCurso.text = texto
        }
    }

    private fun getTextoAsignaturas(cursos: List<String>): String {
        var texto = ""
        for (a in cursos) {
            texto += a + "\n"
        }
        return texto
    }

    private fun getListaCursos(seleccionado: String): List<String> {
        return when (seleccionado) {
            "1º DAM" -> listOf("p", "bd", "s", "fol", "e")
            "2º DAM" -> listOf("m", "i", "s", "e", "a", "h")
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
}