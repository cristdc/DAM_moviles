package movil.proyecto2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import movil.proyecto2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mochila: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.mochila = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mochila.root)
        this.inicializarEventos()
    }

    fun inicializarEventos(){
        mochila.btnSeleccionarCurso.setOnClickListener{
            val curso = mochila.spiCurso.selectedItem.toString()
            val asignaturas = this.getAsignaturas(curso)
            mochila.txtAsignatura.text = darFormato(asignaturas)
        }

        mochila.btnEnviar.setOnClickListener{
            Toast.makeText(
                this,
                getString(R.string.mensajeToast, mochila.txtObservaciones.text.toString()),
                Toast.LENGTH_LONG
            ).show()
        }

    }

    fun darFormato(lista:List<String>):String{
        return lista
            .map{ asignatura -> "- ${asignatura}\n"}
            .joinToString("")
    }

    fun getAsignaturas(curso:String):List<String> =
        when(curso){
            "1º DAM" -> listOf("Programación", "Sistemas","Base de datos", "Entornos", "Marcas")
            "2º DAM" -> listOf("Móviles", "Interfaces","Acceso a datos","Servicios","Sistemas Gestión Empresarial")
            else -> throw Exception("Curso no admitido")
        }


}