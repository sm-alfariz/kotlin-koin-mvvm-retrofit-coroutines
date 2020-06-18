/*************************************************
 * Created by Efendi Hariyadi on 5/15/20 3:01 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/15/20 3:01 AM
 ************************************************/

package com.numesa.android.simpeldesa.di

import com.numesa.android.simpeldesa.api.requests.UserServices
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(UserServices::class.java) }
}