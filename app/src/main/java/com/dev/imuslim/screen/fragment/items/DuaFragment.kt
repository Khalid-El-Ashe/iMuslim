package com.dev.imuslim.screen.fragment.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.imuslim.adapter.DuaAdapter
import com.dev.imuslim.databinding.FragmentDuaBinding
import com.dev.imuslim.viewModel.DuaViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DuaFragment : Fragment() {
    private lateinit var binding: FragmentDuaBinding
    private lateinit var duaAdapter: DuaAdapter
//    private val duaViewModel by viewModels<DuaViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDuaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.iconBack.setOnClickListener {
            findNavController().popBackStack()

            // i need to get the list from api and set in my adapter differ
//            lifecycleScope.launch {
//                duaViewModel.getDuas().collect {
//                    duaAdapter.diffUtil.submitList(it)
//                }
//            }

            // select the recycler view
            initRecyclerView()

            binding.etSearch.addTextChangedListener {
//                duaViewModel.searchDua(searchQuery = it.toString()) // you need to complete build fun search
            }
//            lifecycleScope.launch {
//                duaViewModel.searchQuery.collect {
//                    duaAdapter.diffUtil.submitList(it)
//                }
//            }
        }
    }

    private fun initRecyclerView() {
        duaAdapter = DuaAdapter()
        binding.rvDua.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = duaAdapter
        }
    }
}