package dam.moviles.tiendaropa.vista

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import dam.moviles.tiendaropa.databinding.ItemProductoBinding
import dam.moviles.tiendaropa.modelo.Producto

class ProductoHolder (val binding:ItemProductoBinding): RecyclerView.ViewHolder(binding.root) {
    lateinit var producto:Producto
    fun mostrarProducto(p:Producto){
        producto = p
        binding.txtNombre.text = p.nombre
        binding.txtPrecio.text = if (p.disponible) p.precio.toString() else "No disponible"
        binding.txtInfo.text =
            "Color: ${p.detalles.color} Tallas: ${p.detalles.tallas.joinToString(",")}"
        binding.imageView.setImageDrawable(cargarFoto("p_${p.id.toString()}"))
    }
    private fun cargarFoto(nombre:String): Drawable {
        val context = binding.root.context
        val carpetaRes = context.resources
        val idFoto = carpetaRes.getIdentifier(nombre, "drawable", "dam.moviles.tiendaropa")
        val imagen = carpetaRes.getDrawable(idFoto,null)
        return imagen
    }

}