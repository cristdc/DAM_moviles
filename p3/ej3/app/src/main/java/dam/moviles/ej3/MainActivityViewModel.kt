package dam.moviles.ej3

import android.os.SystemClock
import android.widget.Chronometer
import android.widget.EditText
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    fun segundos(chronometer:Chronometer, editText: EditText){
        val seg: Long = Integer.parseInt(editText.text.toString()).toLong()

        chronometer.base = SystemClock.elapsedRealtime() + ((seg + 1) * 1000)
    }

}