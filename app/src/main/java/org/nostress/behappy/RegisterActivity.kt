package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    var dataReference : DatabaseReference? = null
    var database : FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        dataReference = database?.reference!!.child("profile")

        register_button_register.setOnClickListener {
            Register()
        }

        already_have_account_text_view.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }

    private fun Register(){
        val username = username_edittext_register.text.toString()
        val email = email_edittext_register.text.toString()
        val password = password_edittext_register.text.toString()

        if(username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
            return
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (!it.isSuccessful) return@addOnCompleteListener

                Log.d("Registerakun","Successfully create user with uid : ${it.result?.user?.uid}")
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
            .addOnFailureListener{
                Log.d("Registerakun","Failed to create user : ${it.message}")
                if(it.message.equals("The email address is badly formatted.")){
                    Toast.makeText(this, "Format email salah", Toast.LENGTH_SHORT).show()
                }
                else if (it.message.equals("The given password is invalid. [ Password should be at least 6 characters ]")){
                    Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
                }
                else if(it.message.equals("The email address is already in use by another account.")){
                    Toast.makeText(this, "Email sudah pernah digunakan", Toast.LENGTH_SHORT).show()
                }
            }
    }

    }
