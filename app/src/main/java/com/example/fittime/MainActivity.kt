package com.example.fittime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.fittime.databinding.ActivityMainBinding
import com.example.fittime.ui.Fragment.HomeFragment
import com.example.fittime.ui.objects.AppDrawer


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater) //test 234
        setContentView(mBinding.root)

    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }


    private fun initFunc() {
        setSupportActionBar(mToolbar)
        mAppDrawer.create()
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, HomeFragment()).commit()

    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
    }


}