package com.example.sharedviewmodelnavigationdemo.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel: ViewModel() {

    private var _sharedStateFlow = MutableStateFlow("")
    val sharedStateFlow = _sharedStateFlow.asStateFlow()

    fun updateFlow(name: String){
        _sharedStateFlow.value=name
    }
}