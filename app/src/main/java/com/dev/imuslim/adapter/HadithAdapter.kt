package com.dev.imuslim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dev.imuslim.databinding.HadithItemBinding
import com.dev.imuslim.model.Hadith

class HadithAdapter : RecyclerView.Adapter<HadithAdapter.HadithViewHolder>() {
    lateinit var onItemClick: ((Hadith) -> Unit)

    inner class HadithViewHolder(val binding: HadithItemBinding) : ViewHolder(binding.root)

    // i need to use this diffUtils to listen the changes in this list and more things in backend
    private val _diffUtil = object : DiffUtil.ItemCallback<Hadith>() {
        override fun areItemsTheSame(oldItem: Hadith, newItem: Hadith): Boolean {
            return oldItem.hadithTitle == newItem.hadithTitle
        }

        override fun areContentsTheSame(oldItem: Hadith, newItem: Hadith): Boolean {
            return oldItem == newItem
        }
    }

    var diffUtil = AsyncListDiffer(this, _diffUtil)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithViewHolder {
        return HadithViewHolder(
            HadithItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = diffUtil.currentList.size

    override fun onBindViewHolder(holder: HadithViewHolder, position: Int) {
        val hadith = diffUtil.currentList[position]

        holder.binding.tvHadithTitle.text = hadith.hadithTitle
        holder.binding.tvHadithDescription.text = hadith.hadithDescription

        holder.binding.hadithLayout.setOnClickListener {
            onItemClick.invoke(hadith)
        }
    }

}