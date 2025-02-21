package com.dev.imuslim.screen.fragment.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dev.imuslim.databinding.FragmentBlank12Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Blank12Fragment : Fragment() {
    private lateinit var binding: FragmentBlank12Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank12Binding.inflate(inflater)
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