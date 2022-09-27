package com.iittii.last

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.iittii.last.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var mAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
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