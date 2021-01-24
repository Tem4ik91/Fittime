package com.example.fittime.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.fittime.R
import com.example.fittime.ui.Fragment.ProfileFragment
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

    fun create(){
        createHeader()
        createDrawer()
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
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        1 -> mainActivity.supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.dataContainer, ProfileFragment()).commit()
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