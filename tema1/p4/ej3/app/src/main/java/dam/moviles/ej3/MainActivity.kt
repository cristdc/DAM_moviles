package dam.moviles.ej3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dam.moviles.ej3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initialiazeViewModel()
        initializeBinding()
        inicializarBotonFlotante()
    }

    private fun getCamposVacios():String{
        val lista = listOf(binding.txtName,binding.txtLastName,binding.txtMiddleName,binding.txtPhoneNumber,binding.txtBusiness)
        var texto = ""
        for(i in lista){
            if(i.text.toString().isEmpty()){
                texto += "El campo: "+i.hint.toString()+" está vacío. "
            }
        }
        return texto
    }

    private fun inicializarBotonFlotante(){
        binding.floatingActionButton.setOnClickListener {
            Toast.makeText(this, getCamposVacios(),Toast.LENGTH_LONG).show()
        }
    }

    private fun initialiazeViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}