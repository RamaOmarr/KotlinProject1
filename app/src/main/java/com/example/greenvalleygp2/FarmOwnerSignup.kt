package com.example.greenvalleygp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.core.Constants
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FarmOwnerSignup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farm_owner_signup2)

        val btn: Button= findViewById(R.id.SignupBtn)
        var fOwnerEmail: EditText= findViewById(R.id.EmailSign)
        var fOwnerPass: EditText= findViewById(R.id.PasswordSign)
        var fOwnerFirstName:EditText= findViewById(R.id.FirstNameSign)
        var fOwnerLastName: EditText=findViewById(R.id.LastNameSign)
        var fOwnerPhone:EditText= findViewById(R.id.PhoneSign)

        btn.setOnClickListener {
            //Toast.makeText(this, "You were registered successfully", Toast.LENGTH_SHORT).show()
            Toast.makeText(this,fOwnerEmail.text.toString(), Toast.LENGTH_SHORT).show()

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(fOwnerEmail.text.toString(),fOwnerPass.text.toString())
                .addOnCompleteListener(
                    OnCompleteListener<AuthResult>
                    {
                            task ->
                        if(task.isSuccessful){
                            val firebaseUser = FirebaseFirestore.getInstance()
                            //val db = Firebase.firestore

                            val FarmOwnerUser= FarmOwnerInfo(getCurrentUserID(), fOwnerFirstName.text.toString(),fOwnerLastName.text.toString(),fOwnerEmail.text.toString(),fOwnerPass.text.toString(),fOwnerPhone.text.toString())
                            Toast.makeText(this, "You were registered successfully"+ FarmOwnerUser.id, Toast.LENGTH_SHORT).show()

                            val FarmFireStore = FirebaseFirestore.getInstance()
                            FarmFireStore.collection("FarmOwner")
                                .document(getCurrentUserID())
                                .set(FarmOwnerUser, SetOptions.merge())
                                .addOnSuccessListener {
                                    Toast.makeText(this, "account created", Toast.LENGTH_SHORT).show()

                                }.addOnFailureListener{
                                    Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
                                }

                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }

                        else{
                            Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                        }
                    })
        }
    }
}
fun getCurrentUserID(): String {
    val currentUser = FirebaseAuth.getInstance().currentUser
    var currentUserID = ""
    if (currentUser != null) {
        currentUserID = currentUser.uid
    }
    return currentUserID
}
