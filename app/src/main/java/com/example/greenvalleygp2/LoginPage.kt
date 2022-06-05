package com.example.greenvalleygp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        var CreatFarmAcc : TextView= findViewById(R.id.CreateAcc)
        val LoginButton : Button = findViewById(R.id.LoginBtn)
        var email:EditText=findViewById(R.id.LoginEmail)
        var password:EditText=findViewById(R.id.LoginPass)
        var forget:TextView=findViewById(R.id.textView9)


        forget.setOnClickListener {
            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email.text.toString())
                .addOnSuccessListener { Toast.makeText(this,"a reset password had been sent to this email ",Toast.LENGTH_LONG).show() }
        }
        LoginButton.setOnClickListener{
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email.text.toString(),password.text.toString())
                .addOnCompleteListener(
                    OnCompleteListener<AuthResult>
                    {
                            task ->
                        if (task.isSuccessful){


                            val HomeIntent= Intent(this, MainActivity::class.java)
                            startActivity(HomeIntent)
                        }
                        else{

                            Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()


                        }

                    })

        }

        CreatFarmAcc.setOnClickListener{
            val SignupIntent= Intent(this, FarmOwnerSignup::class.java)
            startActivity(SignupIntent)
        }
    }
}

