package com.dev.imuslim.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.imuslim.model.Dua
import com.dev.imuslim.network.IMuslimApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DuaViewModel @Inject constructor(private val iMuslimApi: IMuslimApi) : ViewModel() {

    // i need to get this list from api
    val duas = MutableStateFlow<List<Dua>>(emptyList())

    private val _searchQuery = MutableStateFlow<List<Dua>>(emptyList())
    val searchQuery = _searchQuery.asStateFlow()

//    fun searchDua(searchQuery: String): Flow<String> = flow {
//    }

    fun getDua() {
        viewModelScope.launch {
            iMuslimApi.getDua().let {
                duas.emit(it)
            }
        }
    }
}