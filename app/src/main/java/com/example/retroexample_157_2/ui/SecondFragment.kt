package com.example.retroexample_157_2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.retroexample_157_2.databinding.FragmentSecondBinding
import com.example.retroexample_157_2.model.MarsRepository
import com.example.retroexample_157_2.model.remote.MarsRealState
import com.example.retroexample_157_2.viemodel.MarsViewModel


class SecondFragment : Fragment() {
    private lateinit var binding : FragmentSecondBinding
    private val viewModel : MarsViewModel by activityViewModels()
    private var idMars: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idMars = it.getString("id", "")
            var precio = it.getLong("price", -1)
        }
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e( "segundo",idMars)
        viewModel.getMarsById(idMars).observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.e( "segundo","$it")
                Glide.with(binding.imageView2).load(it.imgSrc).into(binding.imageView2)
                binding.tvEstado.text=it.type
                binding.tvValor.text= it.price.toString()
            }
        })

    }
}
