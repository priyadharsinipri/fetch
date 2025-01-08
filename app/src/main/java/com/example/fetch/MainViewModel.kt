package com.example.fetch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetch.Repository.ListRepository
import com.example.fetch.data.details
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ListRepository) :ViewModel(){
    val myResponse:MutableLiveData<List<details>> = MutableLiveData()
    fun getList(){
        viewModelScope.launch {
            val response = repository.getList()
            val filteredItems = response
                .filter { !it.name.isNullOrBlank() }
                .sortedWith(compareBy({ it.listId }, { it.name }))
            myResponse.value = filteredItems
        }
    }
}