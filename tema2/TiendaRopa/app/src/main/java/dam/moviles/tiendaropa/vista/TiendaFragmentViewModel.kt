package dam.moviles.tiendaropa.vista

import android.content.Context
import androidx.lifecycle.ViewModel
import dam.moviles.tiendaropa.modelo.Producto
import dam.moviles.tiendaropa.modelo.Tienda

class TiendaFragmentViewModel():ViewModel() {

    var productos:List<Producto> = emptyList()

    fun cargarProductos(context: Context){
        if(productos.isEmpty()){
            productos= Tienda.inicializar(context).productos

        }
    }
}