package com.example.fittime.ui.Fragment

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.text.InputType
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.fittime.MainActivity
import com.example.fittime.R
import com.example.fittime.models.User
import com.example.fittime.utlits.*
import com.mikepenz.iconics.Iconics
import kotlinx.android.synthetic.main.fragment_change_name.*
import java.nio.file.attribute.AclEntry
import java.text.SimpleDateFormat
import java.util.*


class ChangeNameFragment : BaseChangeFragment(R.layout.fragment_change_name) {

    lateinit var mNewUsername: String
    lateinit var databirth: String
    lateinit var sex: String
    lateinit var growth: String
    lateinit var weight: String



    override fun onResume() {
        super.onResume()
        settings_input_username.setText(USER.username)
        setting_birthday.setText(USER.databirth)
        setting_sex.setText(USER.sex)
        setting_growth.setText(USER.growth)
        setting_weight.setText(USER.weight)


        initFullnameList()
        dateOfBirth()
        dialogSex()
        dialogGrowth()
        dialogweight()

    }

    private fun dialogweight() {
        settings_btn_change_weight.setOnClickListener {
            val weightDialog = AlertDialog.Builder(this.activity)

            val inflater = layoutInflater
            val editweight = inflater.inflate(R.layout.edit_text_layout, null)
            val editText = editweight.findViewById<EditText>(R.id.edit_text)

            with(weightDialog){
                setTitle("Введите ваш вес")
                setPositiveButton("Ok"){dialog, which ->
                    setting_weight.text = editText.text
                    dialog.dismiss()
                }
                setNegativeButton("Cancel"){dialog, which ->
                    dialog.dismiss()
                }
            }
            weightDialog.setView(editweight)
            weightDialog.show()
        }
    }

    private fun dialogGrowth() {
        settings_btn_change_growth.setOnClickListener {
            val growthDialog = AlertDialog.Builder(this.activity)

            val inflater = layoutInflater
            val editgrowth = inflater.inflate(R.layout.edit_text_layout, null)
            val editText = editgrowth.findViewById<EditText>(R.id.edit_text)

            with(growthDialog){
                setTitle("Введите ваш рост")
                setPositiveButton("Ok"){dialog, which ->
                    setting_growth.text = editText.text
                    dialog.dismiss()
                }
                setNegativeButton("Cancel"){dialog, which ->
                    dialog.dismiss()
                }
            }
            growthDialog.setView(editgrowth)
            growthDialog.show()

        }
    }

    private fun dialogSex() {
        settings_btn_change_sex.setOnClickListener {
            val sexDialog = AlertDialog.Builder(this.activity)

            val listSex = arrayOf("Муж", "Жен")

            sexDialog.setItems(listSex){dialog, item ->
                showToast(listSex[item])
                setting_sex.text = listSex[item]
                dialog.dismiss()
            }
            sexDialog.show()
        }
    }


    private fun dateOfBirth() {

        var fomate = SimpleDateFormat("dd.MM.yyyy")

        settings_btn_change_birthday.setOnClickListener {
            val now = Calendar.getInstance()

             if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {                        // если дроид выше 7
                val datePickerDialog =  DatePickerDialog( this.activity!! , DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(Calendar.YEAR, year)
                    selectedDate.set(Calendar.MONTH, month)
                    selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val date = fomate.format(selectedDate.time)
                    showToast(date)
                    setting_birthday.text = date.toString()
                },
                    now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
                )
                 datePickerDialog.show()
            } else {

            }

        }
    }


    private fun initFullnameList() {
        val fullnameList = USER.fullname.split(" ")
        if (fullnameList.size > 1) {
            settings_input_name.setText(fullnameList[0])
            settings_input_surname.setText(fullnameList[1])
        } else settings_input_name.setText(fullnameList[0])
    }


    override fun change() {

        mNewUsername = settings_input_username.text.toString().toLowerCase(Locale.getDefault())
        databirth = setting_birthday.text.toString()
        sex = setting_sex.text.toString()
        growth = setting_growth.text.toString()
        weight = setting_weight.text.toString()


        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty() || mNewUsername.isEmpty() ){
            showToast(getString(R.string.settings_toast_name_is_empty))
        } else {
            REF_DATABASE_ROOT.child(NODE_USERNAMES)
                .addListenerForSingleValueEvent(AppValueEventListener{
                    if (it.hasChild(mNewUsername)){
                        showToast("Такой пользователь уже существует")
                    } else {
                        changeUsername()
                    }
                })

            val fullname = "$name $surname"
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULLNAME)
                .setValue(fullname).addOnCompleteListener {
                    if (it.isSuccessful){
                        showToast(getString(R.string.toast_data_update))
                        USER.fullname = fullname
                       // fragmentManager?.popBackStack()
                    }
                }

            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_DATABIRTH)
                .setValue(databirth).addOnCompleteListener {
                    if (it.isSuccessful){
                        showToast(getString(R.string.toast_data_update))
                        USER.databirth = databirth
                    }
                }

            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_SEX)
                .setValue(sex).addOnCompleteListener {
                    if (it.isSuccessful){
                        USER.sex = sex
                    }
                }
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_GROWTH)
                .setValue(growth).addOnCompleteListener {
                    if(it.isSuccessful){
                        USER.growth = growth
                    }
                }
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_WEIGHT)
                .setValue(weight).addOnCompleteListener {
                    if (it.isSuccessful){
                        USER.weight = weight
                    }
                }

        }




    }

    private fun changeUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUsername).setValue(UID)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    updateCurrentUsername()
                }
            }
    }

    private fun updateCurrentUsername() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_USERNAME).setValue(mNewUsername)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    showToast(getString(R.string.toast_data_update))
                    deleteOldUsername()
                }else{
                    showToast(it.exception?.message.toString())
                }
            }
    }

    private fun deleteOldUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(USER.username).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful){
                    showToast(getString(R.string.toast_data_update))
                    USER.username = mNewUsername
                }else{
                    showToast(it.exception?.message.toString())
                }
            }
    }




}

