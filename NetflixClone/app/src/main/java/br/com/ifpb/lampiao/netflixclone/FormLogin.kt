package br.com.ifpb.lampiao.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)


        var cadastro = findViewById<TextView>(R.id.text_cadastrar)
        cadastro.setOnClickListener {
            AbrirTelaDeCadastro()
        }

    }
    private fun AbrirTelaDeCadastro(){
        var intent = Intent(this,FormCadastro::class.java)
        startActivity(intent)
    }
}