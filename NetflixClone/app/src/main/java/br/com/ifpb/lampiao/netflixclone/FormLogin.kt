package br.com.ifpb.lampiao.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        verificarUsuarioLogado()
        var entrar = findViewById<Button>(R.id.bt_entrar)
        var cadastro = findViewById<TextView>(R.id.text_cadastrar)
        entrar.setOnClickListener {
            autenticarUsuario()
        }

        cadastro.setOnClickListener {
            AbrirTelaDeCadastro()
        }

    }
    private fun verificarUsuarioLogado(){
        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if(usuarioAtual!=null){
            abrirTelaPrincipal()
        }
    }
    private fun abrirTelaPrincipal(){
        var intent = Intent(this,TelaPrincipal::class.java)
        startActivity(intent)
    }
    private fun autenticarUsuario(){
        var email = findViewById<EditText>(R.id.edit_email).text.toString()
        var senha = findViewById<EditText>(R.id.edit_senha).text.toString()
        var mensagem = findViewById<TextView>(R.id.mensagem_erro)
        if (email.isEmpty() || senha.isEmpty()){
            mensagem.setText("Coloque seu email e senha")
        }else{
            //mensagem.setText(email + "e" +senha)
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,"Login Efetuado!",Toast.LENGTH_SHORT)
                    abrirTelaPrincipal()
                }
            }.addOnFailureListener {
                var erro = it
                when (erro) {
                    is FirebaseAuthInvalidCredentialsException -> mensagem.setText("Email ou senha incorretos")
                    is FirebaseNetworkException -> mensagem.setText("Erro de conexão")
                    else -> mensagem.setText("Erro ao logar")
                }
            }
        }
    }
    private fun AbrirTelaDeCadastro(){
        var intent = Intent(this,FormCadastro::class.java)
        startActivity(intent)
    }
}