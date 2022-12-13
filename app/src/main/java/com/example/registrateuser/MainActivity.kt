package com.example.registrateuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener{

            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "შეიყვანეთ მონაცემი", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "წარმატებით შეინახა", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "ERRORR", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }


}