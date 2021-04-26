package com.example.fittime.ui.Fragment

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Toast
import com.example.fittime.R
import com.example.fittime.utlits.APP_ACTIVITY
import com.example.fittime.utlits.showToast
import kotlinx.android.synthetic.main.fragment_coffee.*
import java.text.SimpleDateFormat
import java.util.*


class CoffeeFragment : BaseOkSaveFragment(R.layout.fragment_coffee) {

    lateinit var alarmNewTime: String
    val alarm = Calendar.getInstance()


    override fun onResume() {
        super.onResume()
        startAlarm()
        startChangeListAlarm()
        loadBD()

    }

    private fun loadBD() {

        val sharedPreferences0 = APP_ACTIVITY.getSharedPreferences("key0", Context.MODE_PRIVATE)
        val sharedPreferences1 = APP_ACTIVITY.getSharedPreferences("key1", Context.MODE_PRIVATE)
        val sharedPreferences2 = APP_ACTIVITY.getSharedPreferences("key2", Context.MODE_PRIVATE)
        val sharedPreferences3 = APP_ACTIVITY.getSharedPreferences("key3", Context.MODE_PRIVATE)
        val sharedPreferences4 = APP_ACTIVITY.getSharedPreferences("key4", Context.MODE_PRIVATE)
        val sharedPreferences5 = APP_ACTIVITY.getSharedPreferences("key5", Context.MODE_PRIVATE)

        val saveString0 = sharedPreferences0.getString("key0", null)
        val saveString1 = sharedPreferences1.getString("key1", null)
        val saveString2 = sharedPreferences2.getString("key2", null)
        val saveString3 = sharedPreferences3.getString("key3", null)
        val saveString4 = sharedPreferences4.getString("key4", null)
        val saveString5 = sharedPreferences5.getString("key5", null)

        setting_alarm0.text = saveString0
        setting_alarm1.text = saveString1
        setting_alarm2.text = saveString2
        setting_alarm3.text = saveString3
        setting_alarm4.text = saveString4
        setting_alarm5.text = saveString5
    }

    override fun change() {
        saveBD()
    }

    private fun saveBD() {
        val insText0 = setting_alarm0.text.toString()
        val insText1 = setting_alarm1.text.toString()
        val insText2 = setting_alarm2.text.toString()
        val insText3 = setting_alarm3.text.toString()
        val insText4 = setting_alarm4.text.toString()
        val insText5 = setting_alarm5.text.toString()

        val sharedPreferences0 = APP_ACTIVITY.getSharedPreferences("key0", Context.MODE_PRIVATE)
        val sharedPreferences1 = APP_ACTIVITY.getSharedPreferences("key1", Context.MODE_PRIVATE)
        val sharedPreferences2 = APP_ACTIVITY.getSharedPreferences("key2", Context.MODE_PRIVATE)
        val sharedPreferences3 = APP_ACTIVITY.getSharedPreferences("key3", Context.MODE_PRIVATE)
        val sharedPreferences4 = APP_ACTIVITY.getSharedPreferences("key4", Context.MODE_PRIVATE)
        val sharedPreferences5 = APP_ACTIVITY.getSharedPreferences("key5", Context.MODE_PRIVATE)

        val editor0 = sharedPreferences0.edit()
        val editor1 = sharedPreferences1.edit()
        val editor2 = sharedPreferences2.edit()
        val editor3 = sharedPreferences3.edit()
        val editor4 = sharedPreferences4.edit()
        val editor5 = sharedPreferences5.edit()

        editor0.apply() { putString("key0", insText0) }.apply()
        editor1.apply() { putString("key1", insText1) }.apply()
        editor2.apply() { putString("key2", insText2) }.apply()
        editor3.apply() { putString("key3", insText3) }.apply()
        editor4.apply() { putString("key4", insText4) }.apply()
        editor5.apply() { putString("key5", insText5) }.apply()

        showToast(getString(R.string.toast_data_update))

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
