package com.example.mybinarsharedpreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sp = getSharedPreferences("coba", Context.MODE_PRIVATE)
        val esp = sp.edit()

        btn_login.setOnClickListener {
            if (sp.getString("name", "") == et_usernameLogin.text.toString()
                && sp.getString("password", "") == et_passwordLogin.text.toString()){

                esp.putBoolean("isLogin", true)
                esp.commit()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username dan Password salah !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
