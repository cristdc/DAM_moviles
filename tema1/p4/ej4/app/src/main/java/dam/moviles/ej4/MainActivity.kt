package dam.moviles.ej4

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dam.moviles.ej4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.inicializarBinding()
        inicializarBoton()
    }

    private fun inicializarBoton() {
        binding.button.setOnClickListener {
            val cantidad = binding.txtDinero.text.toString().toDouble()
            val monedaOrigen = binding.spinner1.selectedItem.toString()

            val mapDolares = mapOf("yenes" to 152.14*cantidad,"libras" to 0.77*cantidad,"dólares" to 1.0*cantidad)
            val mapLibras = mapOf("yenes" to 197.09*cantidad,"libras" to 1.0*cantidad,"dólares" to 1.30*cantidad)
            val mapYenes = mapOf("yenes" to 1.0*cantidad,"libras" to 0.0051*cantidad,"dólares" to 0.0066*cantidad)

            val resultado = when(monedaOrigen){
                "dólares" -> getConversion(mapDolares)
                "yenes" -> getConversion(mapYenes)
                "libras" -> getConversion(mapLibras)
                else -> {0}
            }

            Toast.makeText(this,"Resultado: $resultado", Toast.LENGTH_LONG).show()

        }
    }

    private fun getConversion(map:Map<String,Double>): Double? {
        val monedaDestino = binding.spinner2.selectedItem.toString()
        return map.get(monedaDestino)
    }

    private fun inicializarBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
