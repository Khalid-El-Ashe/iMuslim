package com.dev.imuslim.screen.fragment.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.imuslim.adapter.StoriesFriendsAdapter
import com.dev.imuslim.databinding.FragmentStoriesFrindsBinding
import com.dev.imuslim.viewModel.StoriesFriendsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoriesFriendsFragment : Fragment() {
    private lateinit var binding: FragmentStoriesFrindsBinding
    private lateinit var adapter: StoriesFriendsAdapter
    private val storiesFriendsViewModel by viewModels<StoriesFriendsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentStoriesFrindsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.iconBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // in here i need to get the data from api and i need to set it in the differ adapter
//        lifecycleScope.launch {
//            storiesFriendsViewModel.getStoriesFriendsData().collect {
//                adapter.diffUtil.submitList(it)
//            }
//        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = StoriesFriendsAdapter()
        binding.rvStoriesFriends.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}