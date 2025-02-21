package com.dev.imuslim.screen.fragment.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dev.imuslim.adapter.StoriesProphetAdapter
import com.dev.imuslim.databinding.FragmentStoriesProphetsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoriesProphetsFragment : Fragment() {
    private lateinit var binding: FragmentStoriesProphetsBinding
    private lateinit var storiesProphetsAdapter: StoriesProphetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoriesProphetsBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.iconBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}