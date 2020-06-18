package com.numesa.android.simpeldesa.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.numesa.android.simpeldesa.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : Fragment() {
  private val homeViewModel: HomeViewModel by viewModel()
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val root = inflater.inflate(R.layout.fragment_home, container, false)
    val textView: TextView = root.findViewById(R.id.text_home)
    homeViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    initObserver()
    return root
  }

  private fun initObserver () {
//    homeViewModel.allUsers.observe(viewLifecycleOwner, Observer { listUser ->
//      if (listUser.isNotEmpty()) {
//        listUser.forEach {
//          Timber.i(it.name)
//        }
//      }
//    })
    homeViewModel.vmGetUserList()
    homeViewModel.userList.observe(viewLifecycleOwner, Observer { listUser ->
      listUser.forEach {
        Timber.i(it.name)
      }
    })
  }
}