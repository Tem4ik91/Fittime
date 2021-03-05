package com.example.fittime.ui.Fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.fittime.MainActivity
import com.example.fittime.R
import com.example.fittime.activites.RegisterActivity
import com.example.fittime.utlits.AUTH
import com.example.fittime.utlits.USER
import com.example.fittime.utlits.replaceActivity
import com.example.fittime.utlits.replaceFragment
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : BaseFragment(R.layout.fragment_profile) {


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {
        settings_phone_number.text = USER.phone
        settings_full_name.text = USER.fullname
        setting_sex.text = USER.sex
        setting_birthday.text = USER.databirth
        setting_growth.text= USER.growth
        setting_weight.text = USER.weight

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
}
