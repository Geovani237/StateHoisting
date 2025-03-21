package br.com.fiap.statehosting.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.statehosting.calculos.calcularJuros
import br.com.fiap.statehosting.calculos.calcularMontante

class JurosScreenViewModel: ViewModel() {
    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital

    private val _juros = MutableLiveData<Double>()
    val juros: LiveData<Double> =_juros

    private val _montante = MutableLiveData<Double>()
    val montante: LiveData<Double> =_montante

    private val _taxa = MutableLiveData<String>()
    val taxa: LiveData<String> =_taxa

    private val _tempo = MutableLiveData<String>()
    val tempo: LiveData<String> =_tempo
    fun onCapitalChanged(novoCapital : String){
        _capital.value = novoCapital
    }

    fun onTaxaChanged(novoTaxa : String){
        _taxa.value = novoTaxa
    }

    fun onTempoChanged(novoTempo: String){
        _tempo.value = novoTempo
    }

    fun calcularJurosViewModel(){
        _juros.value = calcularJuros(
            capital = _capital.value!!.toDouble(),
            taxa = _taxa.value!!.toDouble(),
            tempo = _tempo.value!!.toDouble()
        )
    }

    fun calcularMontanteViewModel(){
        _montante.value = calcularMontante(
            capital = _capital.value!!.toDouble(),
            juros = _juros.value!!.toDouble()
        )
    }
}