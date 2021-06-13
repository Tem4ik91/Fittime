package com.example.fittime.ui.Fragment

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.fittime.MainActivity
import com.example.fittime.R
import com.example.fittime.utlits.APP_ACTIVITY
import com.example.fittime.utlits.USER
import com.example.fittime.utlits.downloadAndSetImage
import com.example.fittime.utlits.showToast
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.settings_full_name
import kotlinx.android.synthetic.main.fragment_profile.settings_profile_image

class HomeFragment : Fragment(R.layout.fragment_home), SensorEventListener {

    private var sensorManager:SensorManager? = null

    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f

    override fun onStart() {
        super.onStart()
        loadData()
        resetSteps()
        sensorManager = context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        //  setHasOptionsMenu(true)
        initFields()


        running = true

        val stepSensor: Sensor? = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor != null){
            sensorManager?.registerListener(this,stepSensor,SensorManager.SENSOR_DELAY_UI)
        }else{
            showToast("Нет датчика на девайсе")
        }


    }


    private fun initFields() {
        settings_full_name.text = USER.fullname
        settings_profile_image.downloadAndSetImage(USER.photoUrl)}

    override fun onSensorChanged(event: SensorEvent?) {
        if(running){
            totalSteps = event!!.values[0]
            showToast("eeeeeeeeeeeee")
            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
            home_text_step.text = currentSteps.toString()

            progress_circular.apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }




   private fun saveData() {
        val sharedPreferences = APP_ACTIVITY.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("key1", previousTotalSteps)
        editor.apply()
   }

    private fun loadData(){
        val sharedPreferences = APP_ACTIVITY.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat("key1",0f)
        Log.d("MainActyvity", "$savedNumber")
        previousTotalSteps = savedNumber
    }

    private fun resetSteps() {
        progress_circular.setOnClickListener {
            showToast("Длинное нажатие, обнулит шаги")
        }
        progress_circular.setOnLongClickListener {
            previousTotalSteps = totalSteps
            home_text_step.text = 0.toString()
            saveData()
            true
        }

    }
}








