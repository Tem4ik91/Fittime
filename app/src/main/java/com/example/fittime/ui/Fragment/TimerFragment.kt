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
import androidx.annotation.RequiresApi
import com.example.fittime.R
import com.example.fittime.utlits.APP_ACTIVITY
import com.example.fittime.utlits.showToast
import kotlinx.android.synthetic.main.fragment_change_name.*
import kotlinx.android.synthetic.main.fragment_timer.*


class TimerFragment : BaseFragment(R.layout.fragment_timer) {



    override fun onResume() {
        super.onResume()

        thirty_sec.setOnClickListener {

            val timer = object: CountDownTimer(30000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    showToast( "${millisUntilFinished/1000}")
                }

                override fun onFinish() {
                    showToast("end")
                }
            }
            timer.start()
        }
        sixty_sec.setOnClickListener {

            val timer = object: CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    showToast( "${millisUntilFinished/1000}")
                }

                override fun onFinish() {
                    showToast("end")
                }
            }
            timer.start()

        }
        two_minutes.setOnClickListener {

            val timer = object: CountDownTimer(120000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    showToast( "${millisUntilFinished/1000}")
                }

                override fun onFinish() {
                    showToast("end")
                }
            }
            timer.start()
        }

    }


     override fun change() {



    }


}