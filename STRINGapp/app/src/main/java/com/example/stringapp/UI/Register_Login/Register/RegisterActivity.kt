package com.example.stringapp.UI.Register_Login.Register

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.stringapp.ApiService.ApiService
import com.example.stringapp.Model.Register.MobileRegister
import com.example.stringapp.R
import com.example.stringapp.StringApi
import com.example.stringapp.UI.Register_Login.Login.LogInActivity
import com.example.stringapp.UI.Register_Login.RegisterLoginActivity
import com.example.stringapp.ViewModel.Repository
import com.example.stringapp.ViewModel.StringViewModel
import com.example.stringapp.ViewModel.StringViewModelFactory
import kotlinx.android.synthetic.main.register_email_activity.*
import java.util.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var avm : StringViewModel
    private var mobileRegister: MobileRegister = MobileRegister()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_email_activity)

        addEvent()
        avm = viewModel()
        bindViewModel()

        register_back.setOnClickListener(this)
        register_account_checkbox.setOnClickListener(this)
        register_sign_up.setOnClickListener(this)
        register_log_in.setOnClickListener(this)
        register_email_dateOfBirth_edittext.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id){
                R.id.register_back -> backToRegisterLoginActivity()
                R.id.register_account_checkbox -> changeSignUpBackground()
                R.id.register_sign_up -> goToLogInForSignUp()
                R.id.register_log_in -> goToLogIn()
                R.id.register_email_dateOfBirth_edittext -> showDatePickerDialog()
            }
        }
    }

    private fun backToRegisterLoginActivity(){
        val intent = Intent(this@RegisterActivity, RegisterLoginActivity::class.java)
        startActivity(intent)
    }

    private fun changeSignUpBackground(){
        if (register_account_checkbox.isChecked){
            register_sign_up.setBackgroundResource(R.drawable.rectangle_sign_in_1)
        } else {
            register_sign_up.setBackgroundResource(R.drawable.rectangle_sign_in_0)
        }
    }

    private fun goToLogInForSignUp(){
        register()
        if ((register_account_checkbox.isChecked) && ( allFilled() )){
            val intent = Intent(this@RegisterActivity, VerifyActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goToLogIn(){
        val intent = Intent(this@RegisterActivity, LogInActivity::class.java)
        startActivity(intent)
    }

    private fun viewModel() : StringViewModel {
        val viewModelFactory = StringViewModelFactory(Repository(ApiService(StringApi.create())))
        return ViewModelProvider(this, viewModelFactory)[StringViewModel::class.java]
    }

    private fun bindViewModel(){
        avm.registerInfo.observe(this, {
            mobileRegister.apply{mobileRegister = it}
            mobileRegister.message?.let { it1 -> Log.d("check in register", it1) }
        })
    }

    private fun allFilled(): Boolean{
        if ((register_email_emailname_edittext.text == null)
            || (register_email_name_edittext.text == null)
            || (register_email_dateOfBirth_edittext.text == null)
            || (register_email_username_edittext.text == null)
            || (register_email_password_edittext.text == null)
            || (register_email_confirmPassword_edittext.text == null)){
            return false
        }
        return true
    }

    private fun addEvent(){
        register_email_password_edittext.transformationMethod = PasswordTransformationMethod.getInstance()
        register_email_confirmPassword_edittext.transformationMethod = PasswordTransformationMethod.getInstance()
    }

    private fun register(){
        addEvent()
        if (allFilled() && (register_account_checkbox.isChecked) && (register_email_password_edittext.text.toString() == register_email_confirmPassword_edittext.text.toString())){
            avm.getRegisterInfo(register_email_username_edittext.text.toString()
                , register_email_name_edittext.text.toString()
                , register_email_dateOfBirth_edittext.text.toString()
                , register_email_emailname_edittext.text.toString()
                , register_email_password_edittext.text.toString()
                , register_email_confirmPassword_edittext.text.toString())
        }
    }

    private val c: Calendar = Calendar.getInstance()
    private val year = c.get(Calendar.YEAR)
    private val month = c.get(Calendar.MONTH)
    private val day = c.get(Calendar.DAY_OF_MONTH)

    private fun showDatePickerDialog() {
        val dpd = DatePickerDialog(this, { _: DatePicker, mYear: Int, mMonth: Int, mDay: Int ->
            var myday: String = mDay.toString()
            val month = mMonth + 1
            if (mDay < 10) myday = "0$mDay"
            if (mMonth < 10) {
                register_email_dateOfBirth_edittext.text = ("$myday/0$month/$mYear").toEditable()
            } else register_email_dateOfBirth_edittext.text = ("$myday/$month/$mYear").toEditable()
        }, year, month, day)
        dpd.show()
    }

    private fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)
}