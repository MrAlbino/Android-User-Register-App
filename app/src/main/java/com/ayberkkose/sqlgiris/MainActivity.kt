package com.ayberkkose.sqlgiris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db=openOrCreateDatabase("Kullanicilar", MODE_PRIVATE,null)
        db.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar (id INTEGER PRIMARY KEY,username VARCHAR,password VARCHAR,age INT)")
    }
    fun giris(view: View){
        try {
            val db=openOrCreateDatabase("Kullanicilar", MODE_PRIVATE,null)
            //db.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY,isim VARCHAR,fiyat FLOAT)")
            val cursor=db.rawQuery("SELECT * FROM kullanicilar",null)

            val usernameColumnIndex=cursor.getColumnIndex("username")
            val passwordColumnIndex=cursor.getColumnIndex("password")
            var girisBasarili=false
            while(cursor.moveToNext()){

                val username=cursor.getString(usernameColumnIndex)
                val password=cursor.getString(passwordColumnIndex)

                if(username==userText.text.toString()&&password==passText.text.toString()){
                    val goTo=Intent(this,GirisBasariliActivity::class.java)
                    girisBasarili=true
                    goTo.putExtra("username",username)
                    startActivity(goTo)
                }

            }
            if(!girisBasarili){
                Toast.makeText(this,"Şifre veya Kullanıcı Adı Yanlış",Toast.LENGTH_LONG).show()
            }
        }catch (e:Exception){
            println(e.message)
        }

    }
    fun kayit(view: View){
        val intent=Intent(this,KayitActivity::class.java)
        startActivity(intent)
    }
}