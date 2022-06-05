package com.example.greenvalleygp2

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.NonNull
import com.example.greenvalleygp2.databinding.ActivityMainBinding
import com.google.android.gms.tasks.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.auth.*
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.toObject
import org.w3c.dom.Document

//import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var farmsArray : ArrayList<FarmsInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        val addBtn: Button = findViewById(R.id.addAfarmButton)
        //Toast.makeText(this, getCurrentUserID(),Toast.LENGTH_SHORT).show()
        val li:ListView=findViewById(R.id.lv)
        var ar= mutableListOf<String>()
        var arrayAdapter: ArrayAdapter<*>
        arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,ar)

        farmsArray= ArrayList()

        val farmFireStore = FirebaseFirestore.getInstance()
        val userID= getCurrentUserID()
        farmFireStore.collection("Farm").whereEqualTo("farmOwnerId", getCurrentUserID())
            .get()
            .addOnSuccessListener { documents ->
                for(document in documents) {
                    val aFarm=document.toObject(FarmsInfo::class.java)
                    //Toast.makeText(this, aFarm.farmName, Toast.LENGTH_LONG).show()
//                    ar.add(aFarm.farmName+"   "  + aFarm.farmAddress)
//                    li.adapter=arrayAdapter
//                    Toast.makeText(this, aFarm.farmName, Toast.LENGTH_LONG).show()
                    farmsArray.add(aFarm)
                    binding.lv.adapter = MyAdapter(this, farmsArray)

                }
            }.addOnFailureListener{
                Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
            }


//        farmFireStore.collection("Farm")
//            .document("g3rGFrgK9OUwfLsUkrHpVwVcWvh1").get()
//                .addOnSuccessListener { document ->
//             //   var x=FarmsInfo();
//                val aFarm=document.toObject(FarmsInfo::class.java)!!
//               // val aFarm=document.toObject<FarmsInfo>()
//                Toast.makeText(this, aFarm.farmName,Toast.LENGTH_LONG).show()
//            }.addOnFailureListener{
//                Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
//            }


        addBtn.setOnClickListener{
            val AddFarmIntent = Intent(this, AddFarm::class.java)
            startActivity(AddFarmIntent)
        }
    }


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