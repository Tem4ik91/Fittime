package com.example.fittime.utlits

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fittime.R
import com.example.fittime.activites.RegisterActivity
import com.example.fittime.ui.Fragment.HomeFragment

fun Fragment.showToast(message: String){    //функция тост вызывается во фрагменте
    Toast.makeText(this.context, message,Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity){  //переключение активити
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment){
    supportFragmentManager.beginTransaction()
        .addToBackStack(null)
        .replace(R.id.dataContainer,
            fragment)
        .commit()
}

fun Fragment.replaceFragment(fragment: Fragment){       //переключение фрагментов
    this.fragmentManager?.beginTransaction()
        ?.addToBackStack(null)
        ?.replace(R.id.dataContainer,
            fragment)
        ?.commit()
}