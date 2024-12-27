package com.dev.imuslim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dev.imuslim.databinding.StoriesFriendsItemBinding
import com.dev.imuslim.model.StoriesFriends

class StoriesFriendsAdapter :
    RecyclerView.Adapter<StoriesFriendsAdapter.StoriesFriendsViewHolder>() {

    lateinit var onItemClick: ((StoriesFriends) -> Unit)

    inner class StoriesFriendsViewHolder(val binding: StoriesFriendsItemBinding) :
        ViewHolder(binding.root)

    // i need to use this diffUtils to listen the changes in this list and more things in backend
    private val _diffUtil = object : DiffUtil.ItemCallback<StoriesFriends>() {
        override fun areItemsTheSame(oldItem: StoriesFriends, newItem: StoriesFriends): Boolean {
            return oldItem.storeName == newItem.storeName
        }

        override fun areContentsTheSame(oldItem: StoriesFriends, newItem: StoriesFriends): Boolean {
            return oldItem == newItem
        }
    }

    var diffUtil = AsyncListDiffer(this, _diffUtil)


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): StoriesFriendsViewHolder {
        return StoriesFriendsViewHolder(
            StoriesFriendsItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = diffUtil.currentList.size

    override fun onBindViewHolder(
        holder: StoriesFriendsAdapter.StoriesFriendsViewHolder, position: Int
    ) {
        val storiesFriends = diffUtil.currentList[position]
        holder.binding.tvStoreName.text = storiesFriends.storeName
        holder.binding.tvStoreDescription.text = storiesFriends.storeDescription

        holder.binding.storiesFriendsLayout.setOnClickListener {
            onItemClick.invoke(storiesFriends)
        }
    }


}