package com.example.fittime.ui.Fragment

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock.elapsedRealtime
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.example.fittime.R
import com.example.fittime.utlits.APP_ACTIVITY
import com.example.fittime.utlits.showToast
import kotlinx.android.synthetic.main.fragment_change_name.*
import kotlinx.android.synthetic.main.fragment_timer.*
import kotlin.concurrent.timer


class TimerFragment : BaseFragment(R.layout.fragment_timer) {


    override fun onResume() {
        super.onResume()

        thirty_sec.setOnClickListener {
            val timerDialog = AlertDialog.Builder(APP_ACTIVITY).create()
            val timer = object : CountDownTimer(30000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timerDialog.setTitle("Время отдыха")
                    timerDialog.setMessage(
                        "${millisUntilFinished / 1000}"
                    )
                    timerDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cansel") { dialog, which ->
                        dialog.dismiss()
                        onFinish()
                    }
                    timerDialog.setCanceledOnTouchOutside(false)
                    timerDialog.show()
                }

                override fun onFinish() {
                    timerDialog.dismiss()
                    showToast("end")
                    cancel()
                }
            }
            timer.start()
        }

        sixty_sec.setOnClickListener {
            val timerDialog = AlertDialog.Builder(APP_ACTIVITY).create()
            val timer = object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timerDialog.setTitle("Время отдыха")
                    timerDialog.setMessage(
                        "${millisUntilFinished / 1000}"
                    )
                    timerDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cansel") { dialog, which ->
                        dialog.dismiss()
                        onFinish()
                    }
                    timerDialog.setCanceledOnTouchOutside(false)
                    timerDialog.show()
                }

                override fun onFinish() {
                    timerDialog.dismiss()
                    showToast("end")
                    cancel()
                }
            }
            timer.start()
        }

        two_minutes.setOnClickListener {
            val timerDialog = AlertDialog.Builder(APP_ACTIVITY).create()
            val timer = object : CountDownTimer(120000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timerDialog.setTitle("Время отдыха")
                    timerDialog.setMessage(
                        "${millisUntilFinished / 1000}"
                    )
                    timerDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cansel") { dialog, which ->
                        dialog.dismiss()
                        onFinish()
                    }
                    timerDialog.setCanceledOnTouchOutside(false)
                    timerDialog.show()
                }

                override fun onFinish() {
                    timerDialog.dismiss()
                    showToast("end")
                    cancel()
                }
            }
            timer.start()
        }
    }


    override fun change() {


    }


}