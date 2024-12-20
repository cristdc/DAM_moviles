package dam.moviles.tiendaropa.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.moviles.tiendaropa.databinding.ItemProductoBinding
import dam.moviles.tiendaropa.modelo.Producto

class ProductoAdapter(
    var productos: List<Producto>,
    val lambda: (ProductoHolder) -> Unit
) : RecyclerView.Adapter<ProductoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductoBinding.inflate(inflater, parent, false)
        return ProductoHolder(binding)
    }

    override fun getItemCount(): Int = productos.size


    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        val producto = productos.get(position)
        holder.mostrarProducto(producto)
        holder.binding.root.setOnClickListener {
            lambda(holder)
        }
    }

    fun setListaProductos(p:List<Producto>){
        productos=p
        notifyDataSetChanged()
    }

}