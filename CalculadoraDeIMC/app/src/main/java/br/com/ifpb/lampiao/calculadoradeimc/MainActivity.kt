package br.com.ifpb.lampiao.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calcular = findViewById<Button>(R.id.bt_calcular)
        var deletar = findViewById<ImageView>(R.id.icone_deletar)
        val edit_peso =findViewById<EditText>(R.id.edit_peso)
        val edit_altura =findViewById<EditText>(R.id.edit_altura)
        val mensagem = findViewById<TextView>(R.id.mensagem)

        calcular.setOnClickListener{
            var pesoVazio = edit_peso.text.toString()
            var alturaVazio = edit_altura.text.toString()
            if(pesoVazio.isEmpty()){
                mensagem.setText("Informe o PESO!")
            }else if(alturaVazio.isEmpty()){
                mensagem.setText("Informe a ALTURA!")
            }else {
                calcularIMC()
            }
        }


        deletar.setOnTouchListener { v, event ->
            if(event.action == MotionEvent.ACTION_DOWN){
                edit_peso.setText("")
                edit_altura.setText("")
                mensagem.setText("")
            }
            false
        }

    }
    private fun calcularIMC(){
        val edit_peso =findViewById<EditText>(R.id.edit_peso)
        val edit_altura =findViewById<EditText>(R.id.edit_altura)
        val mensagem = findViewById<TextView>(R.id.mensagem)
        var peso  = java.lang.Float.parseFloat(edit_peso.text.toString())
        var altura = java.lang.Float.parseFloat(edit_altura.text.toString())
        var resultado = mensagem
        val imc = peso/(altura * altura)

        val text_mensagem = when {
            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obesidade (Grau 1)"
            imc <= 39.9 -> "Obesidade (Grau 2)"
            else -> "Obesidade Morbida (Grau 3)"
        }

        resultado.text = "IMC" + " " + imc.toString() + "\n" + text_mensagem

    }
}