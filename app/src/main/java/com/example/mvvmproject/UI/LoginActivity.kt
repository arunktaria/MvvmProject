package com.example.mvvmproject.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.BaseApplication.ApplicationMain
import com.example.mvvmproject.DataModels.LoginRequestModel
import com.example.mvvmproject.R
import com.example.mvvmproject.ViewModels.Factories.ViewModelFactoryClass
import com.example.mvvmproject.ViewModels.ViewModelClass

class LoginActivity : AppCompatActivity() {

    var context = this
    var TAG = "TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emaileditxt = findViewById<EditText>(R.id.emailedittext)
        val passwordeditxt = findViewById<EditText>(R.id.passwordedittext)
        val btnlogin = findViewById<Button>(R.id.btnlogin)

        val repository = (application as ApplicationMain).repository
        val viewmodel = ViewModelProvider(
            this,
            ViewModelFactoryClass(repository, context)
        ).get(ViewModelClass::class.java)

        viewmodel.userLiveData.observe(this, Observer {
            Log.d(TAG, "onCreate: " + it?.data?.dob)
        })


        btnlogin.setOnClickListener {
            val ob = LoginRequestModel(
                "piyush18@gmail.com",
                "12345678", "patient", "dsfsd54",
                "android",
                "1.1",
                "android"
            )

            viewmodel.getUserLogin(ob)
            startActivity(Intent(context, Users_Address::class.java))
        }

    }
}


/* ob.email="piyush18@gmail.com"
           ob.password="12345678"
           ob.device_token="sdf4sd5"
           ob.device_type="android"
           ob.handset="android"
           ob.version="1.1"
           ob.user_type="patient"
*/