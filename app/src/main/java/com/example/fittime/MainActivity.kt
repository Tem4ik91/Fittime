package com.example.fittime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.fittime.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mHeader: AccountHeader
    private lateinit var mDrawer: Drawer
    private lateinit var mToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
       setSupportActionBar(mToolbar)
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(mToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                    PrimaryDrawerItem().withIdentifier(100)
                            .withName("Профиль")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_profile),

                    PrimaryDrawerItem().withIdentifier(101)
                            .withName("Расписание тренировки")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_calender),

                    PrimaryDrawerItem().withIdentifier(102)
                            .withName("Перерыв на обед")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_coffee),

                    PrimaryDrawerItem().withIdentifier(103)
                            .withName("Данные о тренировке")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_notepad),

                    PrimaryDrawerItem().withIdentifier(104)
                            .withName("Статистика")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_graph),

                    PrimaryDrawerItem().withIdentifier(105)
                            .withName("Полезная информация")
                            .withSelectable(false)
                            .withIcon(R.drawable.ic_info),
            ).build()
    }

    private fun createHeader() {
       mHeader = AccountHeaderBuilder()
           .withActivity(this)
           .withHeaderBackground(R.drawable.header)
           .addProfiles(
               ProfileDrawerItem().withName("вапаа").withEmail("+7111111")
           ).build()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
    }
}