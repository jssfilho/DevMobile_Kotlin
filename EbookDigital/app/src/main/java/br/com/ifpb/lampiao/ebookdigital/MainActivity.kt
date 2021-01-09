package br.com.ifpb.lampiao.ebookdigital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var botao = findViewById<Button>(R.id.bt_leitura)
        botao.setOnClickListener {
            var intent = Intent(this,LeituraDoEbook::class.java)
            startActivity(intent)
        }
    }
}