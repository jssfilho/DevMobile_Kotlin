package br.edu.ifpb.lampiao.lojavirtual.Form

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.edu.ifpb.lampiao.lojavirtual.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        supportActionBar!!.hide()

        var cadastrar = findViewById<TextView>(R.id.bt_cadastro)
        cadastrar.setOnClickListener {
            CadastrarUsuario()
        }

    }

    private fun CadastrarUsuario(){
        var edit_email = findViewById<EditText>(R.id.email_cadastro).text.toString()
        var edit_senha = findViewById<EditText>(R.id.senha_cadastro).text.toString()

        if (edit_email.isEmpty() || edit_senha.isEmpty()){

            var snackbar = Snackbar.make(findViewById(R.id.layout_cadastro),"Coloque seu email e sua senha",Snackbar.LENGTH_INDEFINITE)
                    .setBackgroundTint(Color.WHITE)
                    .setTextColor(Color.BLACK).setAction("OK", View.OnClickListener {

                    })
            snackbar.show()
        }else{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(edit_email,edit_senha).addOnCompleteListener {
                if (it.isSuccessful){

                    var snackbar = Snackbar.make(findViewById(R.id.layout_cadastro),"Cadastro Realizado com Sucesso!",Snackbar.LENGTH_INDEFINITE)
                            .setBackgroundTint(Color.WHITE)
                            .setTextColor(Color.BLACK).setAction("OK", View.OnClickListener {
                                voltarParaLogin()
                            })
                    snackbar.show()
                }
            }.addOnFailureListener {


                var snackbar = Snackbar.make(findViewById(R.id.layout_cadastro),"Erro ao cadastrar usuario",Snackbar.LENGTH_INDEFINITE)
                        .setBackgroundTint(Color.WHITE)
                        .setTextColor(Color.BLACK).setAction("OK", View.OnClickListener {

                        })
                snackbar.show()
            }
        }
    }

    private fun voltarParaLogin() {
        var intent = Intent(this,FormLogin::class.java)
        startActivity(intent)
        finish()
    }


}