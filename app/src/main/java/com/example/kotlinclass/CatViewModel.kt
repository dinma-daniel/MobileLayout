package com.example.kotlinclass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinclass.api.CatProvider
import com.example.kotlinclass.data.CatItem
import com.example.kotlinclass.data.CatResult

class CatViewModel: ViewModel(), CatResult {
    private val _items = MutableLiveData<List<CatItem>>()
    val items: LiveData<List<CatItem>> = _items

    private val provider by lazy {
        CatProvider()
    }

    fun fetchCats() {
        provider.fetchCats(this)
    }

    override fun onDataFetchSuccess(cats: List<CatItem>) {
        _items.value = cats
    }

    override fun onDataFetchFailed() {
        // do nothing
    }

}