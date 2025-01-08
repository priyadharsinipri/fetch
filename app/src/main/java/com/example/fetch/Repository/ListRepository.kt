package com.example.fetch.Repository

import android.telecom.Call.Details
import com.example.fetch.Network.RetrofitInstance
import com.example.fetch.data.details
import retrofit2.Response

class ListRepository {
    suspend fun getList(): List<details> {
        return RetrofitInstance.api.getList()
//        return try {
//            val items =  RetrofitInstance.api.getList()
//            // Filter out items with null or empty name
//            val filteredItems = items.filter { !it.name.isNullOrBlank() }
//            // Sort by listId, then by name
//            filteredItems.sortedWith(compareBy({ it.listId }, { it.name }))
//        } catch (e: Exception) {
//            emptyList() // Return an empty list if there's an error
//        }
//    }
    }
}