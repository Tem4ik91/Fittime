package com.example.fittime.ui.Fragment

import androidx.fragment.app.Fragment
import com.example.fittime.MainActivity
import com.example.fittime.R
import com.example.fittime.activites.RegisterActivity
import com.example.fittime.utlits.AUTH
import com.example.fittime.utlits.AppTextWatcher
import com.example.fittime.utlits.replaceActivity
import com.example.fittime.utlits.showToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*
import kotlinx.android.synthetic.main.fragment_profile.*

class EnterCodeFragment( val PhoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {


    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = PhoneNumber
        register_input_phone_code.addTextChangedListener(AppTextWatcher {

            val string = register_input_phone_code.text.toString()
            if (string.length >= 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val code = register_input_phone_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)

        AUTH.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                showToast("Добро пожаловать")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else showToast(it.exception?.message.toString())
        }
    }
}