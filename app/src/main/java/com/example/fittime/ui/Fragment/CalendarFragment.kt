package com.example.fittime.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fittime.R


class CalendarFragment : BaseFragment(R.layout.fragment_calendar) {

    override fun onResume() {
        super.onResume()

        activity?.setTitle("Расписание").toString()

    }

}
