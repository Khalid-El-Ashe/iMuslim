package com.dev.imuslim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dev.imuslim.databinding.QuranStoreItemBinding
import com.dev.imuslim.model.QuranStories

class QuranStoriesAdapter : RecyclerView.Adapter<QuranStoriesAdapter.QuranStoriesViewHolder>() {
    lateinit var onItemClick: ((QuranStories) -> Unit)

    inner class QuranStoriesViewHolder(var bindign: QuranStoreItemBinding) : ViewHolder(bindign.root)

    // i need to use this diffUtils to listen the changes in this list and more things in backend
    private val _diffUtil = object : DiffUtil.ItemCallback<QuranStories>() {
        override fun areItemsTheSame(oldItem: QuranStories, newItem: QuranStories): Boolean {
            return oldItem.titleQuranStore == newItem.titleQuranStore
        }

        override fun areContentsTheSame(oldItem: QuranStories, newItem: QuranStories): Boolean {
            return oldItem == newItem
        }
    }

    var diffUtil = AsyncListDiffer(this, _diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranStoriesViewHolder {
        return QuranStoriesViewHolder(
            QuranStoreItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = diffUtil.currentList.size

    override fun onBindViewHolder(holder: QuranStoriesViewHolder, position: Int) {
        val quranStories = diffUtil.currentList[position]

        holder.bindign.tvQuranStoreTitle.text = quranStories.titleQuranStore
        holder.bindign.tvQuranStoreDescription.text = quranStories.descriptionQuranStories

        holder.bindign.quranStoriesLayout.setOnClickListener {
            onItemClick.invoke(quranStories)
        }
    }
}