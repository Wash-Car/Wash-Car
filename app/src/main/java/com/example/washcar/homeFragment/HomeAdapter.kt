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
        fun bind(currentItem: Lavagem){
            binding.lavagem
        }
    }
    class LavagemDiffCallBack : DiffUtil.ItemCallback<Lavagem>(){
        override fun areItemsTheSame(oldItem: Lavagem, newItem: Lavagem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Lavagem, newItem: Lavagem): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.bind(currentItem)
    }

    override fun getItemId(position: Int): Long {
        var id = currentList[position].id

        return id
    }
}