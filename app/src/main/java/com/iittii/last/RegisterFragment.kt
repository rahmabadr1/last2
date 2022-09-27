package com.iittii.last

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.iittii.last.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private var sherdprf:SharedPreferences?=null
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var mAuth: FirebaseAuth
    private var emaill=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        sherdprf=activity?.getSharedPreferences("last",Context.MODE_PRIVATE)
        fireBse()
        binding.btnsignup.setOnClickListener() {
            signup()
        }
        return binding.root

    }

    private fun signup() {
        val email = binding.etemail.text.toString()
        val confirm = binding.etconfirmpassword.text.toString()
        val password = binding.etpassword.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty() && password == confirm) {
            emaill=email
            sherd()
            mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                it?.let {
                    Toast.makeText(context, "Account created", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(context, HomeActivity::class.java))
                }
            }.addOnFailureListener {
                Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun sherd() {
        sherdprf?.let {
            var editor:SharedPreferences.Editor=it.edit()
            editor.putString("email",emaill).apply()
        }
    }


    private fun fireBse() {
        mAuth = FirebaseAuth.getInstance()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}