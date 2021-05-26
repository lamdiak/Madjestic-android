package com.devrich.madjestic.view.onboarding

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.devrich.madjestic.R
import com.devrich.madjestic.adapter.OnboardingAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlin.properties.Delegates

class OnboardingActivity : AppCompatActivity() {


    init {
        OnboardingAdapter.mFragNumber = 5
    }

    var position by Delegates.notNull<Int>()
    // declare variable viewpager
    private lateinit var viewPager2: ViewPager2

    /**
     * On create
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // make activity on full screen

     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
         window.insetsController?.hide(WindowInsets.Type.statusBars())
     }else {
         window.setFlags(
             WindowManager.LayoutParams.FLAG_FULLSCREEN,
             WindowManager.LayoutParams.FLAG_FULLSCREEN
         )
     }
    }

    private fun setupAdapter() {
        // get widget from activity
        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager2 = findViewById(R.id.view_pager_onboarding)
        val pagerAdapter = OnboardingAdapter(this@OnboardingActivity)
        viewPager2.adapter = pagerAdapter
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        dotsIndicator.setViewPager2(viewPager2)

    }

    override fun onStart() {
        super.onStart()
        setupAdapter()
    }

    fun setupBtnNext(view: View) {
        position = viewPager2.currentItem
        if (position < OnboardingAdapter.mFragNumber){
            position ++
            viewPager2.currentItem = position
        }
    }
}