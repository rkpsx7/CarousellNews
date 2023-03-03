package com.dev_akash.carousellnews

import android.app.Application
import com.dev_akash.carousellnews.di.ApplicationComponent
import com.dev_akash.carousellnews.di.DaggerApplicationComponent

class NewsApplication : Application() {

    lateinit var daggerAppComponent:ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerApplicationComponent.builder().build()
    }
}