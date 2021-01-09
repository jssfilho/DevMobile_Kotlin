package br.com.ifpb.lampiao.blocodenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var salvar = findViewById<FloatingActionButton>(R.id.bt_salvar)
        var editAnotacao = findViewById<EditText>(R.id.editAnotacao)
        var preferencia = PreferenciaAnotacao(applicationContext)

        salvar.setOnClickListener {
            val anotacaoRecuperado = editAnotacao.text.toString()
            if(anotacaoRecuperado == ""){
                Toast.makeText(this,"Digite alguma coisa...",Toast.LENGTH_LONG).show()
            }else {
                preferencia.salvarAnotacao(anotacaoRecuperado)
                Toast.makeText(this,"Anotação Salva Com Sucesso",Toast.LENGTH_SHORT).show()
            }
        }
        var anotacao = preferencia.recuperarAnotacao()
        if(anotacao != " ") {
            editAnotacao.setText(anotacao)
        }
    }
}