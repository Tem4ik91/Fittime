package com.example.fittime.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AlertDialogLayout
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.fittime.R
import com.example.fittime.ui.Fragment.ProfileFragment
import com.example.fittime.utlits.replaceFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer ( val mainActivity: AppCompatActivity, val toolbar: Toolbar) {
    private lateinit var mHeader: AccountHeader
    private lateinit var mDrawer: Drawer
    private lateinit var mDrawerLayout: DrawerLayout

    fun create(){
        createHeader()
        createDrawer()
        mDrawerLayout = mDrawer.drawerLayout
    }

    fun disableDrawer(){                                                                    // отключить гамбургер
        mDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = false
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.setNavigationOnClickListener {
            mainActivity.supportFragmentManager.popBackStack()                              //возврат по стеку назад
        }
    }

    fun enableDrawer(){
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = true
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        toolbar.setNavigationOnClickListener {
            mDrawer.openDrawer()                             //открыть драйвер
        }
    }

    private fun createDrawer() { // бок меню наполнение
        mDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
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
                    .withName("Тренировка")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_go),

                PrimaryDrawerItem().withIdentifier(104)
                    .withName("Таймер тренировки")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_time),

                PrimaryDrawerItem().withIdentifier(105)
                    .withName("Данные о тренировке")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_notepad),

                PrimaryDrawerItem().withIdentifier(106)
                    .withName("Статистика")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_graph),

                PrimaryDrawerItem().withIdentifier(107)
                    .withName("Полезная информация")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_info),
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        1 -> mainActivity.replaceFragment(ProfileFragment())
                    }
                    return false
                }
            }).build()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("вапаа").withEmail("+7111111")
            ).build()
    }


}