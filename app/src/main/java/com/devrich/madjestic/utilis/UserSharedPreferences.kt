package com.devrich.madjestic.utilis

import android.content.Context
import android.content.SharedPreferences
import com.devrich.madjestic.baseController.ApplicationController


private

class UserSharedPreferences {

    /**
     * Edit shared pref
     */
    val editSharedPref: SharedPreferences = ApplicationController.context()
            .getSharedPreferences(TAG, Context.MODE_PRIVATE)

    /**
     * Save onbaord data
     *
     * @param isVisible
     */
    fun saveOnboardData(isVisible: Boolean){
        with(editSharedPref.edit()) {
            putBoolean(ONBORDINGVALUE, isVisible)
            apply()
        }
    }

    fun retrieveOnboard() = editSharedPref.getBoolean(ONBORDINGVALUE, false)

}