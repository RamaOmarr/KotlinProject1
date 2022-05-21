package com.example.greenvalleygp2

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.NonNull
import com.google.android.gms.tasks.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.auth.*

//import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    /*
          db.collection("Farms")
          .get()
          .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
              override fun public void onComplete(@NonNull (Task<QuerySnapshot>) task) {
                  if (task.isSuccessful()) {
                      for (QueryDocumentSnapshot document : task.getResult()) {
                          Log.d(TAG, document.getId() + " => " + document.getData());
                      }
                  } else {
                      Log.w(TAG, "Error getting documents.", task.getException());
                  }*/

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater= menuInflater
        inflater.inflate(R.menu.farm_home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //var farm_dialog= FarmProfileDialogFragment()
        val intent = Intent(this, EditProfileFarmOwner::class.java)
        val SignupIntent= Intent(this, FarmOwnerSignup::class.java)
        val LoginIntent= Intent(this, LoginPage::class.java)

        when(item.itemId){
            R.id.FarmSignup -> startActivity(SignupIntent)
            R.id.editProfile -> startActivity(intent)
            R.id.FarmLogout -> startActivity(LoginIntent)
        }
        return true;
    }




}