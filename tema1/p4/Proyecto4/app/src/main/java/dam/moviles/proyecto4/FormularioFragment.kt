package dam.moviles.proyecto4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import dam.moviles.proyecto4.databinding.FragmentFormularioBinding


class FormularioFragment : Fragment() {

    private lateinit var binding: FragmentFormularioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        configurarMochilaBinding(inflater, container)
        desactivarBotones()
        iniciarEventosBotones()
        confirgurarBotonFlotante()
        configurarBarraTareas()
        return binding.root
    }

    private fun configurarBarraTareas(){
        val mainActivity:MainActivity = activity as MainActivity
        mainActivity.setSupportActionBar(binding.materialToolbar)
    }

    private fun confirgurarBotonFlotante(){
        binding.btnEnviar.setOnClickListener{
            if(binding.checkBox.isChecked){
                val indice = binding.grupoBotones.checkedRadioButtonId
                if(indice!=1){
                    val botonSeleccionado:RadioButton= binding.root.findViewById(indice)
                    Toast.makeText(context,"Has elegido pizza ${botonSeleccionado.text}", Toast.LENGTH_LONG).show()

                }else{
                    Snackbar.make(binding.btnEnviar,"Debes elegir una pisa",Toast.LENGTH_LONG).show()
                }
            }else{
                Snackbar.make(binding.btnEnviar,"Debes aceptar los términos",Toast.LENGTH_LONG).setAction("Aceptar"){
                    binding.nestedScrollView.fullScroll(View.FOCUS_DOWN)
                }.show()
            }
        }
    }

    private fun desactivarBotones() {
        getListaBotones().forEach { boton->
            boton.alpha = 0.6F
        }
    }
    private fun iniciarEventosBotones(){
        getListaBotones().forEach { boton->
            boton.setOnClickListener{
                desactivarBotones()
                boton.alpha=1F
            }
        }
    }

    private fun getListaBotones():List<ImageView> =
         listOf(
            binding.btnBebida1,
            binding.btnBebida2,
            binding.btnBebida3,
            binding.btnBebida4,
            binding.btnBebida5,
            binding.btnBebida6
        )


    private fun configurarMochilaBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentFormularioBinding.inflate(inflater, container, false)
    }

}