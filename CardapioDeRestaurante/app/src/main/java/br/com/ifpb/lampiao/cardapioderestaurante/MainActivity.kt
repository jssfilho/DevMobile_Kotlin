package br.com.ifpb.lampiao.cardapioderestaurante

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()//esconder actionbar

        var sucos = findViewById<ImageView>(R.id.sucos)
        var lanches = findViewById<ImageView>(R.id.lanches)
        var sobremesas = findViewById<ImageView>(R.id.sobremesas)
        var pratos = findViewById<ImageView>(R.id.pratos)
        sucos.setOnClickListener {
            var intent = Intent(this,Sucos::class.java)
            startActivity(intent)
            finish()
        }
        lanches.setOnClickListener {
            var intent = Intent(this,Lanches::class.java)
            startActivity(intent)
            finish()
        }
        sobremesas.setOnClickListener {
            var intent = Intent(this,Sobremesas::class.java)
            startActivity(intent)
            finish()
        }
        pratos.setOnClickListener {
            var intent = Intent(this,Pratos::class.java)
            startActivity(intent)
            finish()
        }
    }
}