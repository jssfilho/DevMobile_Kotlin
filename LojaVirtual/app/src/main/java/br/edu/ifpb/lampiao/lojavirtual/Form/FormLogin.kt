package br.edu.ifpb.lampiao.lojavirtual.Form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import br.edu.ifpb.lampiao.lojavirtual.R

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        supportActionBar!!.hide()
        var edit_email = findViewById<EditText>(R.id.email_login).text.toString()
        var edit_senha = findViewById<EditText>(R.id.senha_login).text.toString()
        var tela_cadastro = findViewById<TextView>(R.id.text_cadastro)
        tela_cadastro.setOnClickListener {
            var intent = Intent(this,FormCadastro::class.java)
            startActivity(intent)
        }
    }
}