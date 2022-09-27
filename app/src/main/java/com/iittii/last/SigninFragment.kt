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
import com.iittii.last.databinding.FragmentSigninBinding


class SigninFragment : Fragment() {
    private var sharedprefs:SharedPreferences?=null
    private lateinit var binding: FragmentSigninBinding
    private lateinit var mAuth: FirebaseAuth
    private var emaill=""
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(inflater, container, false)
       sharedprefs=activity?.getSharedPreferences("last",Context.MODE_PRIVATE)
        fireBse()
        binding.btnsignin.setOnClickListener() {
            signin()
        }
        binding.btnsignup.setOnClickListener() {
            signup()
        }
        return binding.root
    }

    private fun signup() {

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.containerA, RegisterFragment())
            ?.commit()
    }

    private fun signin() {
        val email = binding.etemail.text.toString()
        val password = binding.etpassword.text.toString()
        if (email.isEmpty()) {
            Toast.makeText(context, "please enter your email", Toast.LENGTH_LONG).show()
        } else if (password.isEmpty()) {
            Toast.makeText(context, "please enter your password", Toast.LENGTH_LONG).show()
        } else {
            emaill=email
            sherd()
            mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                it?.let {
                    startActivity(Intent(context, HomeActivity::class.java))
                }
            }.addOnFailureListener {
                Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun sherd() {
        sharedprefs?.let {
            val editor:SharedPreferences.Editor=it.edit()
            editor.putString("email",emaill).apply()
        }
    }
    private fun fireBse() {
        mAuth = FirebaseAuth.getInstance()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SigninFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}