package com.sophos.myappr.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sophos.myappr.MainActivityViewModel
import com.sophos.myappr.NewDocument
import com.sophos.myappr.R
import com.sophos.myappr.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private val TAG2 = "Opciones"
    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.buttonEnviarDoc.setOnClickListener {
            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            val nId = binding.etDocumento.text.toString()
            val name = binding.etNombre.text.toString()
            val ape = binding.etApellido.text.toString()
            val ema = "jsuarezq1@gmail.com"
            val tID = binding.spTDocs.selectedItem.toString()
            val cit = binding.spCity.selectedItem.toString()
            val tAd = binding.spTipoA.selectedItem.toString()
            val adj = binding.etDocumento.text.toString()

            binding.tvEmail.text = ema


            val userX = NewDocument(tID,nId, name,ape,cit,ema,tAd,adj,false)
            println(userX)
            /*
            //texto7.text = correo
            if (true) {
                println("Paso por aca")
                viewModel.getNewDoc(userX)
                println("Paso por aca 2 ")
            }

            viewModel.myResponseNewDoc.observe(viewLifecycleOwner, Observer {
                println("Paso por aca 3")
                if (true) {
                    Log.d(TAG2, it.put.toString())
                    Log.d(TAG2, it.toString())
                    Log.d(TAG2, it.TipoAdjunto.toString())
                    //texto7.text = "Enviado Documento"
                }
            }
            )
        */
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}