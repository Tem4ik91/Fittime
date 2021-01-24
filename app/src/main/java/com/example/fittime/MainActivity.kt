package com.example.fittime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.fittime.R.id.tab_calender
import com.example.fittime.databinding.ActivityMainBinding
import com.example.fittime.ui.Fragment.HomeFragment
import com.example.fittime.ui.Fragment.ProfileFragment
import com.example.fittime.ui.objects.AppDrawer
import com.roughike.bottombar.BottomBar


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        var bottomBar = findViewById<View>(R.id.bottomBar) as BottomBar
        bottomBar.setOnClickListener { tabId ->
                when (tabId.toString()) {
                    "tab_calender" -> supportFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.dataContainer, ProfileFragment()).commit()
                }

      }
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