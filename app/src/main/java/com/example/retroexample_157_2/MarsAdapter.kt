package com.example.retroexample_157_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retroexample_157_2.databinding.MarsItemListBinding
import com.example.retroexample_157_2.model.remote.MarsRealState
import javax.security.auth.callback.Callback

 class MarsAdapter:RecyclerView.Adapter<MarsAdapter.MarsViewHolder>(){
    private var marsList= emptyList<MarsRealState>()
     private val selectedMarsData = MutableLiveData<MarsRealState>()
     fun selectedItem():LiveData<MarsRealState> = selectedMarsData

     fun update(list: List<MarsRealState>) {
         marsList = list
         notifyDataSetChanged()
     }
    inner class MarsViewHolder( private val binding: MarsItemListBinding):RecyclerView.ViewHolder(binding.root),
     View.OnClickListener {
        fun bind(mars: MarsRealState) {
            Glide.with(binding.imageView).load(mars.imgSrc).into(binding.imageView)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            selectedMarsData.value= marsList[adapterPosition]
        }
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
         return MarsViewHolder(MarsItemListBinding.inflate(LayoutInflater.from(parent.context)))
     }

     override fun getItemCount(): Int =marsList.size


     override fun onBindViewHolder(holder: MarsAdapter.MarsViewHolder, position: Int) {
        val mars= marsList[position]
         holder.bind(mars)
     }
 }



