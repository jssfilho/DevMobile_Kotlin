package br.com.ifpb.lampiao.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        var email = findViewById<EditText>(R.id.email).text.toString()
        var senha = findViewById<EditText>(R.id.senha).text.toString()
        var mensagem = findViewById<TextView>(R.id.mensagem_erro)
        var cadastrar = findViewById<Button>(R.id.bt_cadastrar)
        cadastrar.setOnClickListener {
            CadastrarUsuario(email,senha,mensagem)
        }
    }
    private fun CadastrarUsuario(email: String,senha: String,mensagem: TextView){

        if (email.isEmpty() || senha.isEmpty()){
            mensagem.setText("Coloque o seu e-mail e sua senha")
        }else {
            mensagem.setText(email +" e "+ senha)
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,"Cadastro Realizado com Sucesso!",Toast.LENGTH_LONG)
                }
            }
        }
    }
}