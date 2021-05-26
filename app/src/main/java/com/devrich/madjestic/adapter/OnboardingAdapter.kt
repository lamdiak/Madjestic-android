package com.devrich.madjestic.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devrich.madjestic.view.onboarding.*
import kotlin.properties.Delegates

/**
 * Onboarding adapter
 *
 * @constructor
 *
 * @param frag
 */
class OnboardingAdapter(frag: FragmentActivity): FragmentStateAdapter(frag) {

    companion object{
        /**
         * Nombre total de fragment
         */
        var mFragNumber by Delegates.notNull<Int>()
    }


    /**
     * Get item count
     *
     * @return nombre de fragment
     */
    override fun getItemCount(): Int  = mFragNumber

    /**
     * Cette méthode surchargée permet de renvoyer le nombre
     * de fragment en fonction de sa position.
     *
     * @param position
     * @return le fragment en fonction de sa position
     */
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OnboardingScreen1()
            1 -> OnboardingScreen2()
            2 -> OnboardingScreen3()
            3 -> OnboardingScreen4()
            4 -> OnBoardingScreen5()
            else -> OnboardingScreen1()
        }
    }
}