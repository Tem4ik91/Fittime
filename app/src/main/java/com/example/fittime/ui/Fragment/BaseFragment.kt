package com.example.fittime.ui.Fragment

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fittime.R


  open class BaseFragment( var layout:Int) : Fragment() {

    private lateinit var mRootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = inflater.inflate(layout, container, false)
        return mRootView
    }

      override fun onStart() {
          super.onStart()
      }
  }