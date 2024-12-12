package dam.moviles.cifrador.modelo

import dam.moviles.cifrador.R

class CifradoCesar:CifradoDesplazamiento(1) {
    override val nombre = "Cifrado César"
    override val idIcono: Int = R.drawable.cesar
}