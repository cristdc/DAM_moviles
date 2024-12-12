package dam.moviles.agenda.modelo

import android.content.Context
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import dam.moviles.agenda.vista.TareaAdapter
import java.io.File

@JsonClass(generateAdapter = true)
data class Agenda(val tareas: MutableList<Tarea>) {

    fun guardarTareas(context: Context) {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Agenda::class.java)
        val agenda = Agenda(tareas)
        val json = adapter.toJson(agenda)
        val file = File(context.filesDir, "tareas.json")
        file.writeText(json)
    }

    companion object {
        fun cargarTareas(context: Context): MutableList<Tarea> {
            val moshi = Moshi.Builder().build()
            val adapter = moshi.adapter(Agenda::class.java)

            val file = File(context.filesDir, "tareas.json")
            if (!file.exists()) {
                return mutableListOf()
            }

            val json = file.readText()
            val agenda = adapter.fromJson(json)

            return agenda?.tareas ?: mutableListOf()
        }
    }
}
