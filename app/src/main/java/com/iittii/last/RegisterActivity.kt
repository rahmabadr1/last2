package com.iittii.last

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.iittii.last.databinding.ActivityMainBinding
import com.iittii.last.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var mAuth:FirebaseAuth
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fireBse()
    }

    private fun fireBse() {
        mAuth=FirebaseAuth.getInstance()

    }

    fun signUp(view: View) {
        val email=binding.etemail.text.toString()
        val confirm=binding.etconfirmpassword.text.toString()
        val password=binding.etpassword.text.toString()
        if(email.isNotEmpty()&&password.isNotEmpty()&&password==confirm){
        mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            it?.let {
                startActivity(Intent(this,SecondActivity::class.java))
            }
        }.addOnFailureListener {
            Toast.makeText(this,"${it.message}", Toast.LENGTH_LONG).show()
        }
        }
    }
}