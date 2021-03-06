package com.example.fittime.ui.Fragment

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fittime.MainActivity
import com.example.fittime.R


open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).mAppDrawer.disableDrawer()    //отключение бок меню
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).mAppDrawer.enableDrawer()       //вкл бок меню
    }
}