package com.dev.imuslim.screen.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dev.imuslim.R
import com.dev.imuslim.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardDoaa.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_duaFragment)
        }
        binding.cardMorning.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_morningFragment)
        }
        binding.cardEvening.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_eveningFragment)
        }
        binding.cardSallaTimes.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_sallaTimesFragment)
        }
        binding.cardCompass.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_prayerCompassFragment)
        }
        binding.cardQuran.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_storiesQuranKareemFragment)
        }
        binding.cardStoriesProphets.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_storiesProphetsFragment)
        }
        binding.cardHadith.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_hadithFragment)
        }
        binding.tvMore.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_moreFragment)
        }
        binding.cardStoriesFrendis.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_storiesFrindsFragment)
        }
//        binding.card9.setOnClickListener {
//            findNavController().navigate(R.id.action_homeScreen_to_blank12Fragment)
//        }
    }
}