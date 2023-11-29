package com.example.kotlinclass

interface UnsplashResult {
    fun onDataFetchedSuccess(images: List<UnsplashItem>)

    fun onDetailsFetchedSuccess(image: UnsplashItem)

    fun onDataFetchedFailed()
}