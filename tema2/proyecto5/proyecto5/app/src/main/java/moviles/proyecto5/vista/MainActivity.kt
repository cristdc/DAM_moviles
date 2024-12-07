package moviles.proyecto5.vista

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import moviles.proyecto5.R
import moviles.proyecto5.modelo.Tienda

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_tag, TiendaFragment())
                .commit()
        }
    }
}