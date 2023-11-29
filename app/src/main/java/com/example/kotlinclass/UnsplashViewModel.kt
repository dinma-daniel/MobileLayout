package com.example.kotlinclass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UnsplashViewModel() : ViewModel(), UnsplashResult {
    private val _item = MutableLiveData<UnsplashItem>()
    val item: LiveData<UnsplashItem> = _item


    private val provider by lazy {
        UnsplashProvider()
    }

    fun FetchPhotoDetails(id: String) {
        provider.getPhotoDetails(this, id)
    }

    override fun onDataFetchedSuccess(images: List<UnsplashItem>) {
        TODO("Not yet implemented")
    }

    override fun onDetailsFetchedSuccess(image: UnsplashItem) {
        _item.value = image
    }

    override fun onDataFetchedFailed() {
        TODO("Not yet implemented")
    }
}