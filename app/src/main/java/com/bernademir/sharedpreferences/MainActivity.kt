package com.bernademir.sharedpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var alinanKullaniciAdi : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.bernademir.sharedpreferences", MODE_PRIVATE)

        alinanKullaniciAdi = sharedPreferences.getString("kullanici", "")

        if (alinanKullaniciAdi != null){
            findViewById<TextView>(R.id.textView).text = "Kaydedilen ad: ${alinanKullaniciAdi}"
        }

    }

    fun kaydet(view : View){

       val kullaniciAdi = findViewById<EditText>(R.id.editText).text.toString()
        if (kullaniciAdi == ""){
            Toast.makeText(this, "Bir deger giriniz!", Toast.LENGTH_LONG).show()
        }else{
            sharedPreferences.edit().putString("kullanici", kullaniciAdi).apply()
            findViewById<TextView>(R.id.textView).text = "Kaydedilen ad: ${kullaniciAdi}"
        }
    }

    fun sil(view : View){
        alinanKullaniciAdi = sharedPreferences.getString("kullanici", "")
        if(alinanKullaniciAdi != null){
            findViewById<TextView>(R.id.textView).text = "Kaydedilen ad: "
            sharedPreferences.edit().remove("kullanici").apply()
        }
    }
}