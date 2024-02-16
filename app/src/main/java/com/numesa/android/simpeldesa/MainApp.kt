/*************************************************
 * Created by Efendi Hariyadi on 6/18/20 10:05 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/18/20 10:05 PM
 ************************************************/

package com.numesa.android.simpeldesa

import android.app.Application
import com.numesa.android.simpeldesa.di.RetrofitModule
import com.numesa.android.simpeldesa.di.apiModule
import com.numesa.android.simpeldesa.di.repositoryModule
import com.numesa.android.simpeldesa.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MainApp : Application() {
    companion object {
        lateinit var instance: MainApp
            private set
    }
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger(Level.DEBUG)//FIXME if upgrade AGP to over 7 use koin 2.x.x will get error "No virtual method elapsedNow()D in class Lkotlin/time/TimeMark " https://github.com/InsertKoinIO/koin/issues/1076
            androidContext(this@MainApp)
            modules(listOf(
                //databaseModule,
                viewModelModule,
                apiModule,
                repositoryModule,
                RetrofitModule
            ))

        }
        instance = this
    }
}