package com.example.stringapp.UI.Intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.stringapp.R
import com.example.stringapp.UI.MobileFeed.MobileFeedActivity
import kotlinx.android.synthetic.main.notification_push.*

class NotificationPush: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_push)

        no_push_okay.setOnClickListener(this)
        no_push_later.setOnClickListener(this)
    }

    private fun okay(){
        val intent = Intent(this@NotificationPush, NotificationLocation::class.java)
        startActivity(intent)
    }

    private fun later(){
        val intent = Intent(this@NotificationPush, MobileFeedActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.no_push_okay -> okay()
            R.id.no_push_later -> later()
        }
    }
}