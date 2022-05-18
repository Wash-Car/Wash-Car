package com.example.washcar

import android.app.Application
import com.example.washcar.repository.RemoteRepository
import dagger.hilt.android.HiltAndroidApp


class WashCarApplication : Application() {
    val remoteRepository by lazy {
        RemoteRepository()
    }
}