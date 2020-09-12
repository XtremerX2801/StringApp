package com.example.stringapp.UI.Intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.stringapp.R
import com.example.stringapp.UI.MobileFeed.MobileFeedActivity
import kotlinx.android.synthetic.main.notification_location.*

class NotificationLocation: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_location)

        no_location_okay.setOnClickListener(this)
    }

    private fun toFeed(){
        val intent = Intent(this@NotificationLocation, MobileFeedActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.no_location_okay -> toFeed()
            R.id.no_location_later -> toFeed()
        }
    }
}