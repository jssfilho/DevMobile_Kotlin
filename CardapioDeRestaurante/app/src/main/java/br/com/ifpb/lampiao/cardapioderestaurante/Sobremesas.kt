package br.com.ifpb.lampiao.cardapioderestaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class Sobremesas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobremesas)
        supportActionBar!!.hide()//esconder actionbar
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Sobremesas"
        toolbar.setNavigationIcon(getDrawable(R.drawable.icone_voltar))
        toolbar.setNavigationOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}