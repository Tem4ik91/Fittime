package com.example.fittime.ui.Fragment

import android.app.ActionBar
import android.app.TimePickerDialog
import android.os.Bundle
import android.provider.AlarmClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fittime.R
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.fittime.utlits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_coffee.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.list_item.*
import java.text.NumberFormat.getInstance
import java.text.SimpleDateFormat
import java.time.Clock
import java.util.*


class CoffeeFragment : BaseFragment(R.layout.fragment_coffee) {

lateinit var textt : String

    override fun onResume() {
        super.onResume()

        startAlarm()

    }

    var arrayList = arrayListOf<String>()
    private fun startAlarm() {



        register_btn_add_coffee.setOnClickListener {
            
            val alarm = Calendar.getInstance()


            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                textt = SimpleDateFormat("HH:mm").format(alarm.time)

                listDinamikAlarm()
                arrayList.add(0, textt)
            }

            TimePickerDialog(APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY),alarm.get(Calendar.MINUTE), true).show()



        }

    }


    private fun listDinamikAlarm() {

        val adapter =  ArrayAdapter<String>(APP_ACTIVITY, R.layout.list_item, arrayList)
        alarm_list.adapter = adapter


    }
}



/*  val now = Calendar.getInstance()

             if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {                        // если дроид выше 7
                val datePickerDialog =  DatePickerDialog( this.activity!! , DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(Calendar.YEAR, year)
                    selectedDate.set(Calendar.MONTH, month)
                    selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val date = fomate.format(selectedDate.time)
                    showToast(date)
                    setting_birthday.text = date.toString()
                },
                    now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
                )
                 datePickerDialog.show()
            } else {

            }*/