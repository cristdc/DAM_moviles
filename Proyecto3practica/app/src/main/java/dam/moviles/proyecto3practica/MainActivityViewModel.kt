package dam.moviles.proyecto3practica

import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var base: Long = SystemClock.elapsedRealtime()
    var isRunning: Boolean = false

    fun actualizarEstadoBotones(b1: Button, b2: Button, b3: Button, b4: Button, b: Boolean) {
        b1.isEnabled = !b
        b2.isEnabled = b
        b3.isEnabled = b
        b4.isEnabled = b
    }
}