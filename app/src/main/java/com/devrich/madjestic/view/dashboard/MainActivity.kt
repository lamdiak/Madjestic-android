package com.devrich.madjestic.view.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.devrich.madjestic.R
import com.devrich.madjestic.baseController.ApplicationController
import com.devrich.madjestic.view.onboarding.OnboardingScreen1
import timber.log.Timber


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ApplicationController.isDebug) {
            Timber.d("Coucou je suis en mode debug")
        }

        // add fragment programmaticaly
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<OnboardingScreen1>(R.id.fragment_container_view)
            }
        }


    }


}