package com.example.fittime.ui.Fragment

import androidx.fragment.app.Fragment
import com.example.fittime.R
import com.example.fittime.utlits.APP_ACTIVITY
import com.example.fittime.utlits.USER
import com.example.fittime.utlits.downloadAndSetImage
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.fragment_profile.*


class HomeFragment : Fragment(R.layout.fragment_home) {


    override fun onResume() {
        super.onResume()
      //  setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {

        settings_full_name.text = USER.fullname

        settings_profile_image.downloadAndSetImage(USER.photoUrl)

    }

}