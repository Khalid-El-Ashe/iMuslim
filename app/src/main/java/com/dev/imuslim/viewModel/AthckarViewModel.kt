package com.dev.imuslim.viewModel

import androidx.lifecycle.ViewModel
import com.dev.imuslim.network.IMuslimApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class AthckarViewModel(private val iMuslimApi: IMuslimApi) : ViewModel() {

    private val _athckar = MutableStateFlow("")
    val athckar = _athckar.asStateFlow()

    fun getMorningAthckarData(): String { // can i use Flow<String>
        return "Morning Athckar"
    }

    fun getEveningAthckarData(): String { // can i use Flow<String>
        return "Evening Athckar"
    }
}
