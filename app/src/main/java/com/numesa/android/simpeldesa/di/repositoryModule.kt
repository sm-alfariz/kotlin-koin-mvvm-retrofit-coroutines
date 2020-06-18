/*************************************************
 * Created by Efendi Hariyadi on 5/15/20 2:06 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/15/20 2:06 AM
 ************************************************/

package com.numesa.android.simpeldesa.di

import com.numesa.android.simpeldesa.repository.UsersRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { UsersRepository(get()) }
}