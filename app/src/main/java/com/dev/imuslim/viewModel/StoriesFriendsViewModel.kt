package com.dev.imuslim.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.imuslim.network.IMuslimApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoriesFriendsViewModel @Inject constructor(private val iMuslimApi: IMuslimApi) :
    ViewModel() {

    fun getStoriesFriendsData() {
        viewModelScope.launch {
            iMuslimApi.getStoriesFriends().let {  }
        }
    }
}