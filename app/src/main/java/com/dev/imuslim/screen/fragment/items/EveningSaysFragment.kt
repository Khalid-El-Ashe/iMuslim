package com.dev.imuslim.screen.fragment.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dev.imuslim.databinding.FragmentEveningSaysBinding
import com.dev.imuslim.viewModel.AthckarViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EveningSaysFragment : Fragment() {
    private lateinit var binding: FragmentEveningSaysBinding
    private val athckarViewModel by viewModels<AthckarViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentEveningSaysBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.iconBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // i need to get the athckar from api
        lifecycleScope.launch {
            binding.tvEvening.text = athckarViewModel.getEveningAthckarData()
        }
    }

    companion object {
        private const val TAG = "Blank3Fragment"
    }
}