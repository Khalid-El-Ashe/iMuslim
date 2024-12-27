package com.dev.imuslim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dev.imuslim.databinding.DuaItemBinding
import com.dev.imuslim.model.Dua

class DuaAdapter : RecyclerView.Adapter<DuaAdapter.DuaViewHolder>() {
    lateinit var onItemClick: ((Dua) -> Unit)

    inner class DuaViewHolder(var binding: DuaItemBinding) : ViewHolder(binding.root)

    // i need to use this diffUtils to listen the changes in this list and more things in backend
    private val _diffUtil = object : DiffUtil.ItemCallback<Dua>() {
        override fun areItemsTheSame(oldItem: Dua, newItem: Dua): Boolean {
            return oldItem.duaTitleName == newItem.duaTitleName
        }

        override fun areContentsTheSame(oldItem: Dua, newItem: Dua): Boolean {
            return oldItem == newItem
        }
    }

    var diffUtil = AsyncListDiffer(this, _diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DuaViewHolder {
        return DuaViewHolder(
            DuaItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = diffUtil.currentList.size

    override fun onBindViewHolder(holder: DuaViewHolder, position: Int) {
        val dua = diffUtil.currentList[position]

        holder.binding.tvDuaTitle.text = dua.duaTitleName
        holder.binding.tvDuaDescription.text = dua.duaDescription

        holder.binding.duaLayout.setOnClickListener {
            onItemClick.invoke(dua)
        }
    }
}