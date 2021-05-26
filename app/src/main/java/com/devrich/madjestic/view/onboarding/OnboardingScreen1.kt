package com.devrich.madjestic.view.onboarding

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import com.devrich.madjestic.R
import timber.log.Timber


class OnboardingScreen1 : Fragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_onboarding_screen_1, container, false)
        setupImageBtn(view)
        return view
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupImageBtn(view: View) {
        val btnNext = view.findViewById<ImageButton>(R.id.img_btn_next)
        btnNext?.apply {
            setOnClickListener {
                touchUpInside(view)
            }
            focusable
            isFocusableInTouchMode = true
            requestFocus()
        }
    }


    private fun touchUpInside(v: View){
        Timber.d("C'est moi euh hhhh ^_^")
    }

}