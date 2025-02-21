package com.dev.imuslim.screen.fragment.items

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dev.imuslim.databinding.FragmentMorningSaysBinding
import com.dev.imuslim.viewModel.AthckarViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MorningSaysFragment : Fragment() {
    private lateinit var binding: FragmentMorningSaysBinding
//    private val athckarViewModel by viewModels<AthckarViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMorningSaysBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.iconBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // i need to make the test is scrolling
        binding.tvMorning.movementMethod = ScrollingMovementMethod()

        // i need to get the athckar from api
//        lifecycleScope.launch {
//            athckarViewModel.getMorningAthckar().collect {
//                binding.tvMorning.text = it
//            }
//        }
    }
}