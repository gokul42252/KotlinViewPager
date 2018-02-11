package com.cretlabs.viewpager

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager
        viewPager.adapter = CustomPagerAdapter(this)
    }
}
