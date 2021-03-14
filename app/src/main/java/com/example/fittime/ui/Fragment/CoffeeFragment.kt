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
import java.text.NumberFormat.getInstance
import java.text.SimpleDateFormat
import java.time.Clock
import java.util.*


class CoffeeFragment : BaseFragment(R.layout.fragment_coffee) {

    lateinit var textt: String
    val alarm = Calendar.getInstance()

    override fun onResume() {
        super.onResume()
        startAlarm()
        startChangeListAlarm()
    }

    private fun startChangeListAlarm() {

        settings_btn_change_coffee0.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                textt = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm0.text = textt
            }
            TimePickerDialog(APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(Calendar.MINUTE), true).show()
        }
        settings_btn_change_coffee1.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                textt = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm1.text = textt
            }
            TimePickerDialog(APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(Calendar.MINUTE), true).show()
        }
        settings_btn_change_coffee2.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                textt = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm2.text = textt
            }
            TimePickerDialog(APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(Calendar.MINUTE), true).show()
        }
        settings_btn_change_coffee3.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                textt = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm3.text = textt
            }
            TimePickerDialog(APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(Calendar.MINUTE), true).show()
        }
        settings_btn_change_coffee4.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                textt = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm4.text = textt
            }
            TimePickerDialog(APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(Calendar.MINUTE), true).show()
        }
        settings_btn_change_coffee5.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                textt = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm5.text = textt
            }
            TimePickerDialog(APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(Calendar.MINUTE), true).show()
        }


    }


    private fun startAlarm() {
        register_btn_add_coffee.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)

                val intent = Intent(AlarmClock.ACTION_SET_ALARM)
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "")
                intent.putExtra(AlarmClock.EXTRA_HOUR, hour)
                intent.putExtra(AlarmClock.EXTRA_MINUTES, minute)
                startActivity(intent)
            }
            TimePickerDialog(APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(Calendar.MINUTE), true).show()
        }
    }
}
