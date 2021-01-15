package br.edu.ifpb.lampiao.lojavirtual.Form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import br.edu.ifpb.lampiao.lojavirtual.R

class FormCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        supportActionBar!!.hide()
        var edit_email = findViewById<EditText>(R.id.email_cadastro).text.toString()
        var edit_senha = findViewById<EditText>(R.id.senha_cadastro).text.toString()
        var cadastrar = findViewById<TextView>(R.id.text_cadastro)
        cadastrar.setOnClickListener {
           
        }
    }
}