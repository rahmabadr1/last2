package com.iittii.last

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.iittii.last.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var sharedpref:SharedPreferences?=null
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAuth: FirebaseAuth
    private var emaill =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedpref=getSharedPreferences("last", MODE_PRIVATE)
        sharedpref?.let {
            emaill= it.getString("email","").toString()
        }
        fireBse()
        login()
    }

    private fun login() {
        if(emaill.isEmpty()){
            supportFragmentManager.beginTransaction().replace(R.id.containerA, SigninFragment()).commit()
        }else{
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }

    private fun fireBse() {
        mAuth = FirebaseAuth.getInstance()

    }


}