/*************************************************
 * Created by Efendi Hariyadi on 5/13/20 2:15 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/13/20 2:15 AM
 ************************************************/

package com.numesa.android.simpeldesa.di

import com.numesa.android.simpeldesa.ui.gallery.GalleryViewModel
import com.numesa.android.simpeldesa.ui.home.HomeViewModel
import com.numesa.android.simpeldesa.ui.slideshow.SlideshowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GalleryViewModel() }
    viewModel { HomeViewModel(get()) }
    viewModel { SlideshowViewModel() }
}

