package dam.moviles.tiendaropa.vista

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dam.moviles.tiendaropa.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // testJson()
    }

    /*private fun testJson() {
        val tienda = Tienda.inicializar(this)
        Log.d("testjsonTienda", tienda.productos.toString())
    }*/
}