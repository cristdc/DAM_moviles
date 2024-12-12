package dam.moviles.cifrador.modelo

open abstract class CifradoDesplazamiento(val desplazamiento: Int):AlgoritmoCifrado {
    override fun cifrar(mensaje:String):String =
        mensaje.toCharArray()
            .map { letra -> letra.code }
            .map { numero -> numero + desplazamiento }
            .map { numero -> numero.toChar() }
            .joinToString("")

}