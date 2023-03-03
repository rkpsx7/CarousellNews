package com.dev_akash.carousellnews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev_akash.carousellnews.repo.NewsHomeRepo
import javax.inject.Inject

class NewsViewModelFactory @Inject constructor(val repo:NewsHomeRepo):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(repo) as T
    }
}