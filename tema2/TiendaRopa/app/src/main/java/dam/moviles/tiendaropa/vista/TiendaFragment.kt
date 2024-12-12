package dam.moviles.tiendaropa.vista

import android.app.SearchManager
import android.database.Cursor
import android.database.MatrixCursor
import android.os.Bundle
import android.provider.BaseColumns
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView.OnSuggestionListener
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dam.moviles.tiendaropa.R
import dam.moviles.tiendaropa.databinding.FragmentTiendaBinding
import dam.moviles.tiendaropa.modelo.Producto

class TiendaFragment : Fragment() {

    private lateinit var binding: FragmentTiendaBinding
    private lateinit var viewModel: TiendaFragmentViewModel
    private val productos = mutableListOf<Producto>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initializeBinding()
        initializeViewModel()
        inicializarToolbar()
        inicializarRecycleView()

        return binding.root
    }

    private fun inicializarToolbar() {
        val a = activity as MainActivity
        a.setSupportActionBar(binding.materialToolbar)
        a.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_toolbar, menu)
                val txtBuscador:SearchView = menu.findItem(R.id.txtBuscadpr).actionView as SearchView
                inicializarBuscador(txtBuscador)
            }

            override fun onMenuItemSelected(menuItem: MenuItem):Boolean {
                return true
            }
        })
    }

    private fun inicializarBuscador(buscador: SearchView) {
        buscador.suggestionsAdapter = getCursorAdapter()
        buscador.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(texto: String?): Boolean {
                consultar(texto)
                cerrarBuscador(buscador)
                return true
            }

            override fun onQueryTextChange(texto: String?): Boolean {
                if (texto != null) {
                    val sugerencias: Cursor = getSugerencias(texto)
                    buscador.suggestionsAdapter.changeCursor(sugerencias)
                }
                return true
            }
        })

        buscador.setOnSuggestionListener(object : SearchView.OnSuggestionListener {
            override fun onSuggestionSelect(position: Int): Boolean {
                val cursor = buscador.suggestionsAdapter.getItem(position) as Cursor
                val sugerencia = cursor.getString(1)
                consultar(sugerencia)
                cerrarBuscador(buscador)
                return true
            }

            override fun onSuggestionClick(position: Int): Boolean {
                val cursor = buscador.suggestionsAdapter.getItem(position) as Cursor
                val sugerencia = cursor.getString(1)
                consultar(sugerencia)
                cerrarBuscador(buscador)
                return true
            }
        })

    }

    private fun cerrarBuscador(buscador: SearchView) {
        buscador.setQuery("", false)
        buscador.isIconified = true
    }

    private fun consultar(texto:String?){
        var lista = viewModel.productos
        if(texto!=null){
            lista = viewModel.productos
                .filter { p -> p.nombre.contains(texto, ignoreCase = true) }
        }
        val adapter = binding.lstResultados.adapter as ProductoAdapter
        adapter.setListaProductos(lista)
    }

    fun getSugerencias(texto:String): Cursor {
        val cursor = MatrixCursor(arrayOf(BaseColumns._ID,SearchManager.SUGGEST_COLUMN_TEXT_1))
        viewModel.productos
            .map { p -> p.nombre }
            .filter { n -> n.contains(texto, ignoreCase = true) }
            .distinct()
            .forEachIndexed{i,n -> cursor.addRow(arrayOf(i,n))}
        return cursor
    }
    fun getCursorAdapter(): CursorAdapter {
        SimpleCursorAdapter(
            requireContext(),
            R.layout.sugerencia,
            null,
            arrayOf(SearchManager.SUGGEST_COLUMN_TEXT_1),
            intArrayOf(R.id.txtSugerencia),
            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        )
    }

    private fun inicializarRecycleView(){
        val adapter=ProductoAdapter(productos){ holder ->
            Toast.makeText(
                requireContext(),
                "Seleccionado ${holder.producto.nombre}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.lstResultados.adapter=adapter
    }

    private fun initializeBinding() {
        binding = FragmentTiendaBinding.inflate(layoutInflater)
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this).get(TiendaFragmentViewModel::class.java)
        viewModel.cargarProductos(requireContext())
    }

}