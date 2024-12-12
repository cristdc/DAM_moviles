package dam.moviles.cifrador.modelo

interface AlgoritmoCifrado {
    val nombre:String
    val idIcono:Int
    fun cifrar(mensaje:String):String

}
fun getAlgoritmoCifrado(numero:Int):AlgoritmoCifrado =
    when(numero){
        0 -> CifradoCesar()
        1 -> CifradoRot13()
        2 -> CifradoBase64()
        else -> throw Exception("Opción no válida")
    }