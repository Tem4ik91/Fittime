package com.example.fittime

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import com.example.fittime.activites.RegisterActivity
import com.example.fittime.databinding.ActivityMainBinding
import com.example.fittime.models.User
import com.example.fittime.ui.Fragment.HomeFragment
import com.example.fittime.ui.objects.AppDrawer
import com.example.fittime.utlits.*
import com.theartofdev.edmodo.cropper.CropImage


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater) //test c26586465
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        initFirebase()
        initUser{
            initFields()
            initFunc()
        }


    }

    private fun initFunc() {
        if(AUTH.currentUser!=null){                                                   //проверка на авторизацию
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
           replaceFragment(HomeFragment(), false)
        }
        else{
            replaceActivity(RegisterActivity())
        }
    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)

    }








}