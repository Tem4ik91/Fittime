package com.example.fittime.ui.Fragment

import android.view.Menu
import android.view.MenuInflater
import com.example.fittime.R


class ProfileFragment : BaseFragment(R.layout.fragment_profile) {


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }
}
