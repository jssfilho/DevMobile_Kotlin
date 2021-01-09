package br.com.ifpb.lampiao.cardapioderestaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class Lanches : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lanches)

        supportActionBar!!.hide()//esconder actionbar
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Lanches"
        toolbar.setNavigationIcon(getDrawable(R.drawable.icone_voltar))
        toolbar.setNavigationOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}