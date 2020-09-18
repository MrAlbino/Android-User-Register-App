package com.ayberkkose.sqlgiris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kayit.*
import java.lang.Exception

class KayitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kayit)
    }
    fun register(view: View){
        try {
            val db=openOrCreateDatabase("Kullanicilar", MODE_PRIVATE,null)

            val username1=userNameText.text.toString()
            val password1=passwordText.text.toString()
            val age1=ageText.text.toString().toIntOrNull()

            if(username1!=""&&password1!=""&&age1!=null){
                db.execSQL("INSERT INTO kullanicilar (username,password,age) VALUES ('$username1','$password1',$age1)")
                val intent= Intent(this,MainActivity::class.java)

                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Boş Bırakılan Alanları Doldurun.",Toast.LENGTH_LONG).show()
            }


        }catch (e:Exception){
            println(e.message)
        }

    }
}