package com.dev.imuslim.screen.fragment.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dev.imuslim.R
import com.dev.imuslim.databinding.FragmentMoreBinding


class MoreFragment : Fragment() {
    private lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.iconBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.prophetLinear.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_prophetMohammedFragment)
        }
        binding.aqsaLinear.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_blank12Fragment2)
        }
        binding.opensLinear.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_islamicOpensFragment)
        }
        binding.sonaLinear.setOnClickListener {
            findNavController().navigate(R.id.action_moreFragment_to_sonaFragment)
        }
    }
}