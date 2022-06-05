package com.example.greenvalleygp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class AddFarm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_farm)

        val addBtn: Button= findViewById(R.id.addFarmbtn)
        var farmsName: EditText= findViewById(R.id.farmNametxt)
        var farmsAddress: EditText= findViewById(R.id.farmAddresstxt)
        var farmsPhone: EditText= findViewById(R.id.farmPhonetxt)

        addBtn.setOnClickListener{
            val newFarm= FarmsInfo(farmsName.text.toString(), farmsAddress.text.toString(),
                getCurrentUserID(),
                arrayListOf(), arrayListOf(), arrayListOf(), farmsPhone.text.toString(),0," ","true")

            val farmsFireStore = FirebaseFirestore.getInstance()
            farmsFireStore.collection("Farm")
                .add(newFarm)
                .addOnSuccessListener {
                Toast.makeText(this, " Farm Added Successfully", Toast.LENGTH_LONG).show()
                    val farmAddedIntent = Intent(this, MainActivity::class.java)
                    startActivity(farmAddedIntent)
            }.addOnFailureListener{
                Toast.makeText(this, " Farm Failed to be added!!", Toast.LENGTH_LONG).show()
                }


        }
    }
}
