package br.com.unifor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private var btnlogout: Button? = null
    private var preferenceHelper: PreferenceHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        preferenceHelper = PreferenceHelper(this)

        btnlogout = findViewById<View>(R.id.btn) as Button

        btnlogout!!.setOnClickListener {
            preferenceHelper!!.putIsLogin(false)
            val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            this@WelcomeActivity.finish()
        }

    }
}