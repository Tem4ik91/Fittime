package com.example.fittime.ui.Fragment

import android.view.*
import androidx.fragment.app.Fragment
import com.example.fittime.MainActivity
import com.example.fittime.R
import com.example.fittime.models.User
import com.example.fittime.utlits.*
import kotlinx.android.synthetic.main.fragment_change_name.*
import java.util.*


class ChangeNameFragment : BaseChangeFragment(R.layout.fragment_change_name) {

    lateinit var mNewUsername: String

    override fun onResume() {
        super.onResume()

        settings_input_username.setText(USER.username)

        initFullnameList()

    }

    private fun initFullnameList() {
        val fullnameList = USER.fullname.split(" ")
        if (fullnameList.size > 1) {
            settings_input_name.setText(fullnameList[0])
            settings_input_surname.setText(fullnameList[1])
        } else settings_input_name.setText(fullnameList[0])
    }


    override fun change() {

        mNewUsername = settings_input_username.text.toString().toLowerCase(Locale.getDefault())



        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty() || mNewUsername.isEmpty() ){
            showToast(getString(R.string.settings_toast_name_is_empty))
        } else {
            REF_DATABASE_ROOT.child(NODE_USERNAMES)
                .addListenerForSingleValueEvent(AppValueEventListener{
                    if (it.hasChild(mNewUsername)){
                        showToast("Такой пользователь уже существует")
                    } else {
                        changeUsername()
                    }
                })


            val fullname = "$name $surname"
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULLNAME)
                .setValue(fullname).addOnCompleteListener {
                    if (it.isSuccessful){
                        showToast(getString(R.string.toast_data_update))
                        USER.fullname = fullname
                      //  fragmentManager?.popBackStack()
                    }
                }
        }

    }

    private fun changeUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUsername).setValue(UID)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    updateCurrentUsername()

                }
            }
    }

    private fun updateCurrentUsername() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_USERNAME).setValue(mNewUsername)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    showToast(getString(R.string.toast_data_update))
                    deleteOldUsername()
                }else{
                    showToast(it.exception?.message.toString())
                }

            }
    }

    private fun deleteOldUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(USER.username).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful){
                    showToast(getString(R.string.toast_data_update))
                    USER.username = mNewUsername
                }else{
                    showToast(it.exception?.message.toString())
                }
            }
    }
}

