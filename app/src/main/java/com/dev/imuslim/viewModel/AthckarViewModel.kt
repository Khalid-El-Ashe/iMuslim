package com.dev.imuslim.viewModel

import androidx.lifecycle.ViewModel
import com.dev.imuslim.network.IMuslimApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class AthckarViewModel @Inject constructor(private val iMuslimApi: IMuslimApi) : ViewModel() {

//    private val _athckar = MutableStateFlow("")
//    val athckar = _athckar.asStateFlow()

//    fun getMorningAthckar(): String {
//        viewModelScope.launch {
//            iMuslimApi.readMorning().let {
//                _athckar.value = it
//            }
//        }
//        return _athckar.value
//    }

//    fun getEveningAthckar(): String {
//        viewModelScope.launch {
//            iMuslimApi.readEvening().let {
//                _athckar.value = it
//            }
//        }
//        return _athckar.value
//    }

    fun getMorningAthckar(): Flow<String> {
        return flow {
            emit(iMuslimApi.readMorning())
        }
    }

    fun getEveningAthckar(): Flow<String> {
        return flow {
            emit(iMuslimApi.readEvening())
        }
    }
}
