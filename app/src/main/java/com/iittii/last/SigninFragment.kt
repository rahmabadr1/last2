package com.iittii.last

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.iittii.last.databinding.FragmentSigninBinding



class SigninFragment : Fragment() {
    private lateinit var binding: FragmentSigninBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSigninBinding.inflate(inflater,container,false)
        fireBse()
        binding.btnsignin.setOnClickListener(){
            signin()
        }
        binding.btnsignup.setOnClickListener(){
            signup()
        }
        return binding.root
    }

    private fun signup() {

        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.containerA,RegisterFragment())
            ?.commit()
    }

    private fun signin() {
        val email=binding.etemail.text.toString()
        val password =binding.etpassword.text.toString()
        mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            it?.let {
                startActivity(Intent(context,SecondActivity::class.java))
            }
        }.addOnFailureListener {
            Toast.makeText(context,"${it.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun fireBse() {
        mAuth= FirebaseAuth.getInstance()
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