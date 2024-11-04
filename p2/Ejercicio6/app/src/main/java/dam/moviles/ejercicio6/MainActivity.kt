 package dam.moviles.ejercicio6

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dam.moviles.ejercicio6.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

    lateinit var mochila: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.mochila = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mochila.root)

        this.inicilizarEventos();
    }

     fun inicilizarEventos(){
         mochila.hello.setOnClickListener{
             val textHello = mochila.hello.text.toString()
             Toast.makeText(
                 this,
                 textHello,
                 Toast.LENGTH_LONG
             ).show()
         }
         mochila.goodbye.setOnClickListener{
             val textGoodBye = mochila.goodbye.text.toString()
             Toast.makeText(
                 this,
                 textGoodBye,
                 Toast.LENGTH_LONG
             ).show()
         }
     }
}