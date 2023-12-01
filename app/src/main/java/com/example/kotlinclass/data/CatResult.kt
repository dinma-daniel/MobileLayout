package com.example.kotlinclass.data

interface CatResult {

    fun onDataFetchSuccess(cats : List<CatItem>)

    fun onDataFetchFailed()
}