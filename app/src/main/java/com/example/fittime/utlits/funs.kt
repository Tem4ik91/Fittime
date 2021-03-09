package com.example.fittime.utlits

import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fittime.R
import com.example.fittime.activites.RegisterActivity
import com.example.fittime.ui.Fragment.HomeFragment
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_profile.*
import java.net.URL

fun showToast(message: String){    //функция тост вызывается во фрагменте
    Toast.makeText(APP_ACTIVITY, message,Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity){  //переключение активити
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, addStack: Boolean = true){
    if(addStack){
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.dataContainer,
                fragment)
            .commit()
    } else{
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,
                fragment)
            .commit()
    }

}

fun Fragment.replaceFragment(fragment: Fragment){       //переключение фрагментов
    this.fragmentManager?.beginTransaction()
        ?.addToBackStack(null)
        ?.replace(R.id.dataContainer,
            fragment)
        ?.commit()
}

fun hideKeyboard(){
    val imm: InputMethodManager = APP_ACTIVITY.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(APP_ACTIVITY.window.decorView.windowToken,0)
}

fun CircleImageView.donwloadAndSetImage(url: String){
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.ic_add_account)
        .into(this)
}