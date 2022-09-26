package com.iittii.last

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.iittii.last.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fireBse()
    }

    private fun fireBse() {
        mAuth= FirebaseAuth.getInstance()

    }

    fun signIn(view: View) {
        val email=binding.etemail.text.toString()
        val password =binding.etpassword.text.toString()
        mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            it?.let {
                startActivity(Intent(this,SecondActivity::class.java))
            }
        }.addOnFailureListener {
            Toast.makeText(this,"${it.message}",Toast.LENGTH_LONG).show()
        }
    }

    fun signUp(view: View) {
        startActivity(Intent(this,RegisterActivity::class.java))
    }

}