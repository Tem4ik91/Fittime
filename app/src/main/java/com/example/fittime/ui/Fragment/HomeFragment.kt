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
import kotlinx.android.synthetic.main.fragment_coffee.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.settings_full_name
import kotlinx.android.synthetic.main.fragment_profile.settings_profile_image
import kotlin.random.Random
import com.db.williamchart.ExperimentalFeature
import com.db.williamchart.slidertooltip.SliderTooltip

class HomeFragment : Fragment(R.layout.fragment_home), SensorEventListener {

    private var sensorManager:SensorManager? = null

    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f

    private val animationDuration = 1000L


    override fun onStart() {
        super.onStart()
        loadData()
        resetSteps()
        graf()
        sensorManager = context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    }




    override fun onResume() {
        super.onResume()
        //  setHasOptionsMenu(true)
        initFields()
        loadData()
        graf()
        running = true

        val stepSensor: Sensor? = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor != null){
            sensorManager?.registerListener(this,stepSensor,SensorManager.SENSOR_DELAY_UI)
        }else{
            showToast("Нет датчика на девайсе")
        }


        activity?.setTitle("Fittime").toString()
    }

    override fun onPause() {
        super.onPause()
        saveData()
        running = false
    }


    private fun initFields() {
        settings_full_name.text = USER.fullname
        settings_profile_image.downloadAndSetImage(USER.photoUrl)
        //graf()


    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(running){
            totalSteps = event!!.values[0]
          //  showToast("eeeeeeeeeeeee")
            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
            home_text_step.text = currentSteps.toString()

            val r = currentSteps * 0.04
            val ccal = String.format("%.2f", r )
            home_text_calories.text = ("Сожжено $ccal ккал")

            val consider = ((7.9 * currentSteps)/100000)
            val t = String.format("%.2f", consider)
            home_text_distance.text= ("Пройдено $t км")


            val cell = 8000 - currentSteps
            setting_steps_target.text = ("Еще $cell шаг. до цели")

            progress_circular.apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }






    private fun graf(){

        val we = listOf(
            "Mo".format("%.1f") to USER.weight.toFloat(),
            "Tu".format("%.1f") to 4f,
            "We".format("%.1f") to 4f,
            "Th".format("%.1f") to 3f,
            "Fr".format("%.1f") to 3f,
            "Sa".format("%.1f") to 7f,
            "Su".format("%.1f") to 7f,

        )

        barChart.animation.duration = animationDuration
       // barChart.animate(barSet)
        barChart.animate(we)

    }


   private fun saveData() {
        val sharedPreferences = APP_ACTIVITY.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("key1", previousTotalSteps)
        editor.apply()

       val insText0 = home_text_calories.text.toString()
       val sharedPreferences0 = APP_ACTIVITY.getSharedPreferences("myPrefs0", Context.MODE_PRIVATE)
       val editor0 = sharedPreferences0.edit()
       editor0.apply() { putString("myPrefs0", insText0) }.apply()

       val insText1 = home_text_distance.text.toString()
       val sharedPreferences1 = APP_ACTIVITY.getSharedPreferences("myPrefs1", Context.MODE_PRIVATE)
       val editor1 = sharedPreferences1.edit()
       editor1.apply() { putString("myPrefs1", insText1) }.apply()

       val insText2 = setting_steps_target.text.toString()
       val sharedPreferences2 = APP_ACTIVITY.getSharedPreferences("myPrefs2", Context.MODE_PRIVATE)
       val editor2 = sharedPreferences2.edit()
       editor2.apply() { putString("myPrefs2", insText2) }.apply()

       val insText3 = home_text_step.text.toString()
       val sharedPreferences3 = APP_ACTIVITY.getSharedPreferences("myPrefs3", Context.MODE_PRIVATE)
       val editor3 = sharedPreferences3.edit()
       editor3.apply() { putString("myPrefs3", insText3) }.apply()

   }

    private fun loadData(){
        val sharedPreferences = APP_ACTIVITY.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat("key1",0f)
        Log.d("MainActyvity", "$savedNumber")
        previousTotalSteps = savedNumber

        val sharedPreferences0 = APP_ACTIVITY.getSharedPreferences("myPrefs0", Context.MODE_PRIVATE)
        val sharedPreferences1 = APP_ACTIVITY.getSharedPreferences("myPrefs1", Context.MODE_PRIVATE)
        val sharedPreferences2 = APP_ACTIVITY.getSharedPreferences("myPrefs2", Context.MODE_PRIVATE)
        val sharedPreferences3 = APP_ACTIVITY.getSharedPreferences("myPrefs3", Context.MODE_PRIVATE)

        val saveString0 = sharedPreferences0.getString("myPrefs0", null)
        val saveString1 = sharedPreferences1.getString("myPrefs1", null)
        val saveString2 = sharedPreferences2.getString("myPrefs2", null)
        val saveString3 = sharedPreferences3.getString("myPrefs3", null)

        home_text_calories.text = saveString0
        home_text_distance.text = saveString1
        setting_steps_target.text = saveString2
        home_text_step.text = saveString3

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








