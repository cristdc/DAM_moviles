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

        inicializarBinding()
        agregarListeners()
        inicializarBoton()
    }


    private fun agregarListeners() {
        añadirAdapter(binding.spinner1)
        añadirAdapter(binding.spinner2)
    }

    private fun añadirAdapter(sp: Spinner) {
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                actualizarBandera(sp)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    private fun actualizarBandera(sp: Spinner) {
        when (sp.selectedItem.toString()) {
            "yenes" -> sp.background = resources.getDrawable(R.drawable.jp, theme)
            "libras" -> sp.background = resources.getDrawable(R.drawable.ru, theme)
            "dólares" -> sp.background = resources.getDrawable(R.drawable.us, theme)
        }
    }

    private fun inicializarBoton() {
        binding.button.setOnClickListener {
            val cantidad = binding.txtDinero.text.toString().toDouble()

            val monedaOrigen = binding.spinner1.selectedItem.toString()
            val monedaDestino = binding.spinner2.selectedItem.toString()

            val tasasConversion = mapOf(
                "yenes" to mapOf(
                    "dólares" to 1.1 / 162.38,
                    "libras" to 0.84 / 162.38,
                    "yenes" to 1.0
                ),
                "libras" to mapOf(
                    "dólares" to 1.1 / 0.84,
                    "yenes" to 162.38 / 0.84,
                    "libras" to 1.0
                ),
                "dólares" to mapOf(
                    "yenes" to 162.38 / 1.1,
                    "libras" to 0.84 / 1.1,
                    "dólares" to 1.0
                )
            )

            val tasaDestino = tasasConversion[monedaOrigen]?.get(monedaDestino)

            val resultado = cantidad * tasaDestino!!

            Toast.makeText(this,"Resultado: $resultado", Toast.LENGTH_LONG).show()

        }
    }


    private fun inicializarBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
