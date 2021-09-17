package com.cuty.datosconqr.ui.viewmodels

import androidx.lifecycle.*
import com.cuty.datosconqr.connectivity.ConnectivityLiveData
import com.cuty.datosconqr.datasource.LocalDataSource
import com.cuty.datosconqr.models.Persona
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainViewModel(private val localDataSource: LocalDataSource) : ViewModel() {


    val personaItems: LiveData<List<Persona>> = localDataSource.allPersonById.asLiveData()
    fun insert(persona: Persona) = viewModelScope.launch {
        localDataSource.insert(persona)
    }

    fun deletePerson(id: Int) = viewModelScope.launch {
        localDataSource.deleteItem(id)
    }

    fun getperson(id: Int) = localDataSource.getPersona(id)




}