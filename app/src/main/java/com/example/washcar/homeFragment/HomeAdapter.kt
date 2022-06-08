package com.example.washcar.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.washcar.R
import com.example.washcar.data.model.Lavagem
import com.example.washcar.databinding.LavagemRowBinding

class HomeAdapter : androidx.recyclerview.widget.ListAdapter<Lavagem, HomeAdapter.ListViewHolder>(LavagemDiffCallBack()) {


    class ListViewHolder private constructor(var binding: LavagemRowBinding ) : RecyclerView.ViewHolder(binding.root) {
        companion object{
            fun from (parent: ViewGroup): ListViewHolder{
                val binding : LavagemRowBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.lavagem_row,
                    parent,
                    false
                )
                return ListViewHolder(binding)
            }
        }
        fun bind(currentIntem: Lavagem){
            binding.lavagem
        }
    }
    class LavagemDiffCallBack : DiffUtil.ItemCallback<Lavagem>(){
        override fun areItemsTheSame(oldItem: Lavagem, newItem: Lavagem): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: Lavagem, newItem: Lavagem): Boolean {
            TODO("Not yet implemented")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}