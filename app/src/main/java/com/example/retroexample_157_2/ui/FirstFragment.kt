package com.example.retroexample_157_2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retroexample_157_2.MarsAdapter
import com.example.retroexample_157_2.viemodel.MarsViewModel
import com.example.retroexample_157_2.R
import com.example.retroexample_157_2.databinding.FragmentFirstBinding
import kotlin.math.log


class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    private val viewModel : MarsViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val adapter = MarsAdapter()
        binding.rvMars.adapter=adapter
        binding.rvMars.layoutManager= GridLayoutManager(context,2)
        binding.rvMars.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))

        viewModel.allMars.observe(viewLifecycleOwner, Observer {
            it?.let{
                Log.d("base", "$it")
           adapter.update(it)
            }
        })
        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let{
                val bundle = Bundle()
                bundle.putString("id", it.id)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
            }
        })


        }
    }

