package dam.moviles.cifrador.modelo

import dam.moviles.cifrador.R
import kotlin.io.encoding.Base64

class CifradoBase64 : AlgoritmoCifrado {
    override val nombre: String = "Base64"
    override val idIcono: Int = R.drawable.base64

    override fun cifrar(mensaje: String): String {
        return android.util.Base64.encodeToString(
            mensaje.toByteArray(),
            android.util.Base64.DEFAULT
        )

    }
}