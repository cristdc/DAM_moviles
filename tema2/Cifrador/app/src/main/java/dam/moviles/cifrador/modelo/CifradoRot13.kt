package dam.moviles.cifrador.modelo

import dam.moviles.cifrador.R

class CifradoRot13:CifradoDesplazamiento(13) {
    override val nombre = "Cifrado ROT13"
    override val idIcono: Int = R.drawable.rot13
}