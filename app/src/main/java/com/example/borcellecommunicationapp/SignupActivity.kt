package com.example.borcellecommunicationapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.LoginFilter.UsernameFilterGMail
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.borcellecommunicationapp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
    lateinit var mtxtusername:EditText
    lateinit var mtxtage:EditText
    lateinit var mtxtcontact:EditText
    lateinit var mtxtemail:EditText
    lateinit var mtxtpostemployed:EditText
     lateinit var mtxtpassword:EditText
    lateinit var mtxtconfirmpassword:EditText
    lateinit var mtxtlogininstead:TextView
    lateinit var mbtnsignup:Button
    lateinit var binding: ActivitySignupBinding
    lateinit var database:DatabaseReference
    lateinit var mAuth:FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mbtnsignup=findViewById(R.id.mBtnRegister)
        mtxtusername=findViewById(R.id.inputUsername)
        mtxtage=findViewById(R.id.inputAge)
        mtxtcontact =findViewById(R.id.inputContact)
        mtxtemail =findViewById(R.id.inputemail)
        mtxtpostemployed =findViewById(R.id.inputPostemployed)
        mtxtpassword =findViewById(R.id.inputPassword)
        mtxtconfirmpassword =findViewById(R.id.inputconfirmpassword)
        mtxtlogininstead=findViewById(R.id.txtlogininstead)

        mtxtlogininstead.setOnClickListener {
            val tembea = Intent(this,LoginActivity::class.java)
            startActivity(tembea)
        }

        mAuth = FirebaseAuth.getInstance()
        binding.mBtnRegister.setOnClickListener {
            val username=binding.inputUsername.text.toString()
            val age=binding.inputAge.text.toString()
            val email=binding.inputemail.text.toString()
            val contact=binding.inputContact.text.toString()
            val post =binding.inputPostemployed.text.toString()
            val password =binding.inputPassword.text.toString()

            database=FirebaseDatabase.getInstance().getReference("Users")
            val users= Users(username,age,email,contact,post,password)
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful){
                    database.child(username).setValue(users).addOnSuccessListener {
                        binding.inputUsername.text.clear()
                        binding.inputAge.text.clear()
                        binding.inputemail.text.clear()
                        binding.inputContact.text.clear()
                        binding.inputPostemployed.text.clear()
                        binding.inputPassword.text.clear()

                        Toast.makeText(this,"Successfully Registered",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,HomepageActivity::class.java)
                        startActivity(intent)


                    }
                }else{
                    Toast.makeText(this,"User registration failed",Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}





