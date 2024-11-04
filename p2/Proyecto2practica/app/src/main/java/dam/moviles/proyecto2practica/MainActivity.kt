package dam.moviles.proyecto2practica

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var spnCursos: Spinner
    private lateinit var btnSeleccionarCurso: Button
    private lateinit var txtAsignaturas: TextView
    private lateinit var txtObservaciones: EditText
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.inicializarControles()
        btnSeleccionarCurso.setOnClickListener{
            val curso: String = spnCursos.selectedItem.toString()
            val asignaturas: List<String> = this.getListaAsignaturas(curso)
            txtAsignaturas.text=this.getAsignaturas(asignaturas)
        }
        btnEnviar.setOnClickListener{
            val observaciones:String = txtObservaciones.text.toString()
            Toast.makeText(this,getString(R.string.envio,observaciones), Toast.LENGTH_SHORT).show()
        }
    }
    private fun getAsignaturas(asignaturas:List<String>):String{
        var texto:String = ""
        for(a in asignaturas){
            texto += "-"+a+"\n"
        }
        return texto
    }
    private fun getListaAsignaturas(curso:String):List<String>{
        return when(curso){
            "1ºDAM" -> listOf("p","b","s","e","f")
            "2ºDAM" -> listOf("M","i","a","p","e")
            else -> throw Exception("Curso no admitido")
        }
    }

    private fun inicializarControles(){
        spnCursos=findViewById(R.id.spnCurso)
        btnSeleccionarCurso=findViewById(R.id.btnSeleccionarCurso)
        txtAsignaturas=findViewById(R.id.txtAsignaturas)
        txtObservaciones=findViewById(R.id.txtObservaciones)
        btnEnviar=findViewById(R.id.btnEnviar)
    }
}