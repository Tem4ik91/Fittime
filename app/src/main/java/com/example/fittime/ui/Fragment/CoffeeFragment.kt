package com.example.fittime.ui.Fragment

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import com.example.fittime.R
import com.example.fittime.utlits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_coffee.*
import java.text.SimpleDateFormat
import java.util.*


class CoffeeFragment : BaseFragment(R.layout.fragment_coffee) {

    lateinit var alarmNewTime: String
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
                alarmNewTime = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm0.text = alarmNewTime
            }
            TimePickerDialog(
                APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(
                    Calendar.MINUTE
                ), true
            ).show()
        }
        settings_btn_change_coffee1.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                alarmNewTime = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm1.text = alarmNewTime
            }
            TimePickerDialog(
                APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(
                    Calendar.MINUTE
                ), true
            ).show()
        }
        settings_btn_change_coffee2.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                alarmNewTime = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm2.text = alarmNewTime
            }
            TimePickerDialog(
                APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(
                    Calendar.MINUTE
                ), true
            ).show()
        }
        settings_btn_change_coffee3.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                alarmNewTime = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm3.text = alarmNewTime
            }
            TimePickerDialog(
                APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(
                    Calendar.MINUTE
                ), true
            ).show()
        }
        settings_btn_change_coffee4.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                alarmNewTime = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm4.text = alarmNewTime
            }
            TimePickerDialog(
                APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(
                    Calendar.MINUTE
                ), true
            ).show()
        }
        settings_btn_change_coffee5.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                alarm.set(Calendar.HOUR_OF_DAY, hour)
                alarm.set(Calendar.MINUTE, minute)
                alarmNewTime = SimpleDateFormat("HH:mm").format(alarm.time)
                setting_alarm5.text = alarmNewTime
            }
            TimePickerDialog(
                APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(
                    Calendar.MINUTE
                ), true
            ).show()
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
            TimePickerDialog(
                APP_ACTIVITY, timeSetListener, alarm.get(Calendar.HOUR_OF_DAY), alarm.get(
                    Calendar.MINUTE
                ), true
            ).show()
        }
    }

}
