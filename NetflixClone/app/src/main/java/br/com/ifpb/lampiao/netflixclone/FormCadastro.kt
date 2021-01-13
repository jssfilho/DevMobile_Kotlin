package br.com.ifpb.lampiao.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.*

class FormCadastro : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        var cadastrar = findViewById<Button>(R.id.bt_cadastrar)
        cadastrar.setOnClickListener {
            CadastrarUsuario()
        }
    }
    private fun CadastrarUsuario(){
        var email = findViewById<EditText>(R.id.edit_email).text.toString()
        var senha = findViewById<EditText>(R.id.edit_senha).text.toString()
        var mensagem = findViewById<TextView>(R.id.mensagem_erro)
        if (email.isEmpty() || senha.isEmpty()){
            mensagem.setText("Coloque o seu e-mail e sua senha")
        }else {

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,"Cadastro Realizado com Sucesso!",Toast.LENGTH_LONG)
                }
            }.addOnFailureListener {
                var erro = it
                when (erro) {
                    is FirebaseAuthWeakPasswordException -> mensagem.setText("Digite a senha com pelo menos 6 digitos")
                    is FirebaseAuthUserCollisionException -> mensagem.setText("E-mail já esta em Uso")
                    is FirebaseAuthInvalidUserException -> mensagem.setText("Digite um e-mail valido!")
                    is FirebaseNetworkException -> mensagem.setText("Erro de Conexão")
                    else -> mensagem.setText("Erro ao Cadastrar")
                }

            }
        }
    }
}