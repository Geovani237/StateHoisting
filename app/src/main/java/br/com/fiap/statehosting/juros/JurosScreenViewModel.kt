package br.com.fiap.statehosting.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JurosScreenViewModel: ViewModel() {
    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital


}