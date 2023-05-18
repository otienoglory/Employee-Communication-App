package com.example.borcellecommunicationapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var txtemail:EditText
    lateinit var txtpassword:EditText
    lateinit var txtnewuser:TextView
    lateinit var mbtnlogin:Button
    lateinit var mAuth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        txtemail = findViewById(R.id.inputemail)
        txtnewuser=findViewById(R.id.txtlogininstead)
        txtpassword =findViewById(R.id.inputPassword)
        mbtnlogin=findViewById(R.id.mBtnRegister)

        txtnewuser.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
        mAuth = FirebaseAuth.getInstance()
        mbtnlogin.setOnClickListener {
            var email = txtemail.text.toString().trim()
            var password = txtpassword.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Please fill in all details", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful){
                        //Toast a success message
                        Toast.makeText(this,"Login Successfull",Toast.LENGTH_SHORT).show()
                        //Redirect to dashboard/home
                        val intent = Intent(this,HomepageActivity::class.java)
                        startActivity(intent)

                    }else{
                       //Back to homepage or leave
                    }
                }
            }
        }
    }
}




