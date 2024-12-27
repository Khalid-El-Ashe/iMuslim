package com.dev.imuslim.screen.fragment.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dev.imuslim.databinding.FragmentProphetMohammedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProphetMohammedFragment : Fragment() {
    private lateinit var binding: FragmentProphetMohammedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProphetMohammedBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.iconBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    companion object {
        private const val TAG = "Blank9Fragment"
    }
}