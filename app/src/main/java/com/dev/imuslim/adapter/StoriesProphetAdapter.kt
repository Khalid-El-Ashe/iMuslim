package com.dev.imuslim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dev.imuslim.databinding.StoreProphetItemBinding
import com.dev.imuslim.model.StoriesProphets

class StoriesProphetAdapter :
    RecyclerView.Adapter<StoriesProphetAdapter.StoriesProphetViewHolder>() {

    lateinit var onItemClick: ((StoriesProphets) -> Unit)

    inner class StoriesProphetViewHolder(val binding: StoreProphetItemBinding) :
        ViewHolder(binding.root)

    // i need to use this diffUtils to listen the changes in this list and more things in backend
    private val _diffUtil = object : DiffUtil.ItemCallback<StoriesProphets>() {
        override fun areItemsTheSame(oldItem: StoriesProphets, newItem: StoriesProphets): Boolean {
            return oldItem.storeTitle == newItem.storeTitle
        }

        override fun areContentsTheSame(
            oldItem: StoriesProphets, newItem: StoriesProphets
        ): Boolean {
            return oldItem == newItem
        }
    }

    var diffUtil = AsyncListDiffer(this, _diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesProphetViewHolder {
        return StoriesProphetViewHolder(
            StoreProphetItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = diffUtil.currentList.size

    override fun onBindViewHolder(holder: StoriesProphetViewHolder, position: Int) {
        val storiesProphets = diffUtil.currentList[position]

        holder.binding.tvStoreProphetTitle.text = storiesProphets.storeTitle
        holder.binding.tvStoreProphetDescription.text = storiesProphets.storeDescription

        holder.binding.storeProphetLayout.setOnClickListener {
            onItemClick.invoke(storiesProphets)
        }
    }
}