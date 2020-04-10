package com.example.mybinarsharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("coba", Context.MODE_PRIVATE)
        show(sp)


        btn_remove_name.setOnClickListener {
            val esp = sp.edit()
            esp.remove("name")
            esp.commit()
            show(sp)
        }

        btn_remove_email.setOnClickListener {
            val esp = sp.edit()
            esp.remove("email")
            esp.commit()
            show(sp)
        }

        btn_remove_password.setOnClickListener {
            val esp = sp.edit()
            esp.remove("password")
            esp.commit()
            show(sp)
        }

        btn_logout.setOnClickListener {
            val esp = sp.edit()
            esp.putBoolean("isLogin", false)
            esp.commit()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun show(sp: SharedPreferences){
        tv_name.text = sp.getString("name", "")
        tv_email.text = sp.getString("email", "")
        tv_password.text = sp.getString("password", "")
    }
}
