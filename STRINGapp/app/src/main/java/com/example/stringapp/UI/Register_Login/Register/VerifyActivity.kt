package com.example.stringapp.UI.Register_Login.Register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.stringapp.R
import com.example.stringapp.UI.Register_Login.Login.LogInActivity
import kotlinx.android.synthetic.main.verify_your_email.*

class VerifyActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verify_your_email)

        verify_back.setOnClickListener(this)
        verify_email.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.verify_back -> backToRegisterActivity()
            R.id.verify_email -> goToLogIn()
        }
    }

    private fun goToLogIn(){
        val intent = Intent(this@VerifyActivity, LogInActivity::class.java)
        startActivity(intent)
    }

    private fun backToRegisterActivity(){
        val intent = Intent(this@VerifyActivity, RegisterActivity::class.java)
        startActivity(intent)
    }
}