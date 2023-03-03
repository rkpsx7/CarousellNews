package com.dev_akash.carousellnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev_akash.carousellnews.model.NewsHomeResponse
import com.dev_akash.carousellnews.repo.NewsHomeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    val repo: NewsHomeRepo
) : ViewModel() {

    private val _newsList = MutableLiveData<List<NewsHomeResponse>>()
    val newsList: LiveData<List<NewsHomeResponse>>
        get() = _newsList

    fun getNewsForHomePage() = viewModelScope.launch(Dispatchers.IO) {
        val res = repo.getNews()

        if (res.isSuccessful && res.body() != null) {
            res.body()?.let { list ->
                _newsList.postValue(list.sortedByDescending { it.timeCreated })
            }
        }
    }

    fun sortNewsByRecent() = _newsList.postValue(getPostSortedByRecent())

    fun getPostSortedByRecent(value: List<NewsHomeResponse>? = _newsList.value): List<NewsHomeResponse>? {
        return value?.sortedByDescending { it.timeCreated }
    }


    fun sortNewsByPopular() = _newsList.postValue(getPostSortedByPopular())

    fun getPostSortedByPopular(value: List<NewsHomeResponse>? = _newsList.value): List<NewsHomeResponse>? {
        return value?.sortedWith(compareBy<NewsHomeResponse>{it.rank}.thenByDescending { it.timeCreated })
    }
}