package com.dev.imuslim.screen.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dev.imuslim.R
import com.dev.imuslim.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // if you need to make delay you can to use it but i need to use coroutine function
        lifecycleScope.launch {
            delay(1500)
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }

        // if you need to make handler you can to use it
//        Handler(Looper.getMainLooper()).postDelayed(Runnable {
//            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
//        }, 1500)
    }
}