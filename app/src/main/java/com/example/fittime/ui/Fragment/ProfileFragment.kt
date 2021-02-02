package com.example.fittime.ui.Fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.fittime.MainActivity
import com.example.fittime.R
import com.example.fittime.activites.RegisterActivity
import com.example.fittime.utlits.AUTH
import com.example.fittime.utlits.replaceActivity


class ProfileFragment : BaseFragment(R.layout.fragment_profile) {


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.setting_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }
}
