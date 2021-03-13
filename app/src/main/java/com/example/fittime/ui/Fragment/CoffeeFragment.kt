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
import com.mikepenz.iconics.utils.toIconicsSizeDp
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
      //  df()
    }

    private fun df() {
        alarm_list.setOnItemClickListener { _, _, position, _ ->
            arrayList.remove(arrayList[position])

        }
    }

    val intent = Intent(AlarmClock.ACTION_SET_ALARM)
    var arrayList = arrayListOf<String>()
    private fun startAlarm() {



        register_btn_add_coffee.setOnClickListener {
            
            val alarm = Calendar.getInstance()


            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                textt = SimpleDateFormat("HH:mm").format(alarm.time)


                arrayList.add(0, textt)
                listDinamikAlarm()

              //  val intent = Intent(AlarmClock.ACTION_SET_ALARM)
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "")
                intent.putExtra(AlarmClock.EXTRA_HOUR, hour )
                intent.putExtra(AlarmClock.EXTRA_MINUTES, minute)

                startActivity(intent)
            }
            TimePickerDialog(APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY),alarm.get(Calendar.MINUTE), true).show()



        }


    }




    private fun listDinamikAlarm() {

        val adapter =  ArrayAdapter<String>(APP_ACTIVITY, R.layout.list_item, R.id.setting_alarm, arrayList)
        alarm_list.adapter = adapter

        alarm_list.setOnItemClickListener { _, _, position, _ ->
            adapter.remove(arrayList[position])


        }


    }
}
