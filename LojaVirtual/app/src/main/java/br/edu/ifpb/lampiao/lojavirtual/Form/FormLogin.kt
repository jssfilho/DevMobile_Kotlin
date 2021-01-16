package br.edu.ifpb.lampiao.lojavirtual.Form

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import br.edu.ifpb.lampiao.lojavirtual.R
import br.edu.ifpb.lampiao.lojavirtual.TelaPrincipal
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        supportActionBar!!.hide()

        var tela_cadastro = findViewById<TextView>(R.id.text_cadastro)
        var login_bt = findViewById<Button>(R.id.bt_login)
        tela_cadastro.setOnClickListener {
            var intent = Intent(this,FormCadastro::class.java)
            startActivity(intent)
        }
        login_bt.setOnClickListener {
            login()
        }

    }
    private fun login(){
        var edit_email = findViewById<EditText>(R.id.email_login).text.toString()
        var edit_senha = findViewById<EditText>(R.id.senha_login).text.toString()
        if (edit_email.isEmpty() || edit_senha.isEmpty()){

            var snackbar = Snackbar.make(findViewById(R.id.layout_login),"Coloque seu email e sua senha",
                Snackbar.LENGTH_INDEFINITE)
                .setBackgroundTint(Color.WHITE)
                .setTextColor(Color.BLACK).setAction("OK", View.OnClickListener {

                })
            snackbar.show()
        }else{
            FirebaseAuth.getInstance().signInWithEmailAndPassword(edit_email,edit_senha).addOnCompleteListener {
                if (it.isSuccessful){
                    findViewById<FrameLayout>(R.id.frameL).visibility = View.VISIBLE
                    Handler().postDelayed({abrirTelaPrincipal()},3000)
                    

                }
            }.addOnFailureListener {


                var snackbar = Snackbar.make(findViewById(R.id.layout_login),"Erro ao logar usuario",
                    Snackbar.LENGTH_INDEFINITE)
                    .setBackgroundTint(Color.WHITE)
                    .setTextColor(Color.BLACK).setAction("OK", View.OnClickListener {

                    })
                snackbar.show()
            }
        }
    }
    private fun abrirTelaPrincipal(){
        var intent =Intent(this,TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }
}