/*************************************************
 * Created by Efendi Hariyadi on 6/18/20 9:16 PM
 * Copyright (c) 2020 . All rights reserved. 
 * Last modified 6/18/20 9:16 PM
 ************************************************/

package com.numesa.android.simpeldesa.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}