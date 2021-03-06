/*************************************************
 * Created by Efendi Hariyadi on 6/18/20 9:16 PM
 * Copyright (c) 2020 . All rights reserved. 
 * Last modified 6/18/20 9:16 PM
 ************************************************/

package com.numesa.android.simpeldesa.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.numesa.android.simpeldesa.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryFragment : Fragment() {

  private val galleryViewModel: GalleryViewModel by viewModel()
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val root = inflater.inflate(R.layout.fragment_gallery, container, false)
    val textView: TextView = root.findViewById(R.id.text_gallery)
    galleryViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}