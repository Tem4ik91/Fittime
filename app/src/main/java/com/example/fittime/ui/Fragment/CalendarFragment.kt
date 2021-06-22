package com.example.fittime.ui.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.events.calendar.utils.EventsCalendarUtil.selectedDate
import com.events.calendar.utils.EventsCalendarUtil.today
import com.events.calendar.views.EventsCalendar
import com.example.fittime.R
import com.example.fittime.utlits.showToast
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.util.*


class CalendarFragment : BaseFragment(R.layout.fragment_calendar), EventsCalendar.Callback {


    override fun onResume() {
        super.onResume()

        activity?.setTitle("Расписание").toString()

        eventsCalendar.setSelectionMode (eventsCalendar. SINGLE_SELECTION ) // установить режим календаря
            .setToday (today) // установить сегодняшнюю дату [today: Calendar]
            //.setMonthRange (start, end) // установить начальный месяц [start: Calendar] и конечный месяц [ end: Calendar]
            //.setWeekStartDay ( Calendar.SUNDAY , false ) // установить начальный день недели по своему усмотрению [startday: Int, doReset: Boolean]
            // .setCurrentSelectedDate (today) // установить текущую дату и прокрутить календарь до соответствующего месяц выбранной даты [сегодня: Календарь]
            //.setDatesTypeface (typeface) // установить шрифт для дат
            // .setDateTextFontSize ( 16f ) // установить размер шрифта для дат
            //.setMonthTitleTypeface (typeface) // установить шрифт для заголовка календаря
            //.setMonthTitleFontSize ( 16f ) // установить размер шрифта для заголовка календарь
            //.setWeekHeaderTypeface (гарнитура) // установить шрифт для названий недель
            //.setWeekHeaderFontSize ( 16f ) // установить размер шрифта для названий недель
           // .setCallback () //установить обратный вызов для EventsCalendar
             //.addEvent (c) // установить события в EventsCalendar [c: Calendar]
            //.disableDate (dc) // отключить определенный день в EventsCalendar [c: Calendar]
            //.disableDaysInWeek ( Calendar . SATURDAY , Calendar.SUNDAY) // отключаем дни недели для всего EventsCalendar [varargs days: Int]
            .build()


    }




    override fun onDayLongPressed(selectedDate: Calendar? ) {
        Log.e("LONG", "CLICKED")


         showToast("2222")
    }

    override fun onMonthChanged(monthStartDate: Calendar?) {
        Log.e("MON", "CHANGED")
    }

    override fun onDaySelected(selectedDate: Calendar?) {
        Log.e("SHORT", "CLICKED")
        showToast("2222")

    }


}
