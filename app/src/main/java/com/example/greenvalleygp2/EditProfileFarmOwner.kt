package com.example.greenvalleygp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class EditProfileFarmOwner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile_farm_owner)

        var editFirstName: EditText= findViewById(R.id.FirstNameEdit)
        var editLastName: EditText= findViewById(R.id.LastNameEdit)
        var editPhoneNum: EditText= findViewById(R.id.PhoneNumEdit)
        var editEmail: EditText= findViewById(R.id.emailEdit)
        var editAddress: EditText= findViewById(R.id.addressEdit)
        val EditBtn : Button = findViewById(R.id.EditBtn)
        val FireStore =  FirebaseFirestore.getInstance()
        Toast.makeText(this,"an Email"+ editEmail.text.toString(), Toast.LENGTH_LONG).show()

        EditBtn.setOnClickListener{

            if(editEmail.text.toString().length > 3){

                FirebaseAuth.getInstance().currentUser?.updateEmail(editEmail.text.toString())
                    ?.addOnSuccessListener {
                        Toast.makeText(this, "Email Updated", Toast.LENGTH_LONG).show()
                    }
                FireStore.collection("FarmOwner").document("g3rGFrgK9OUwfLsUkrHpVwVcWvh1").update("foemail", editEmail.text.toString())
            }

            if(editFirstName.text.toString().length > 3){
                FireStore.collection("FarmOwner").document("g3rGFrgK9OUwfLsUkrHpVwVcWvh1").update("firstname", editFirstName.text.toString())
            }

            if(editPhoneNum.text.toString().length > 3){
                FireStore.collection("FarmOwner").document("g3rGFrgK9OUwfLsUkrHpVwVcWvh1").update("fophone", editPhoneNum.text.toString())
            }

            if(editLastName.text.toString().length > 3){
                FireStore.collection("FarmOwner").document("g3rGFrgK9OUwfLsUkrHpVwVcWvh1").update("lastname", editLastName.text.toString())
            }

        }

    }
}