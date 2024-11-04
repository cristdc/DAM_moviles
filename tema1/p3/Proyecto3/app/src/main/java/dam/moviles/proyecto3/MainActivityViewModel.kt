package dam.moviles.proyecto3

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dam.moviles.proyecto3.databinding.ActivityMainBinding

class MainActivityViewModel: ViewModel() {
    var situacion:Situacion = Situacion.PARADO
    var base:Long = SystemClock.elapsedRealtime()
    var tiempoTranscurrido:Long = 0


     fun reiniciarConTiempoTranscurrido(reloj:Chronometer) {
        base = SystemClock.elapsedRealtime() - tiempoTranscurrido
        reloj.base = base
    }

     fun actualizarTiempoTranscurrido() {
        tiempoTranscurrido = SystemClock.elapsedRealtime() - base
    }

    fun reiniciar(reloj:Chronometer) {
        base = SystemClock.elapsedRealtime()
        reloj.base = base
    }
}