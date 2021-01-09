package br.com.ifpb.lampiao.calculadoradenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoCalcular = findViewById<Button>(R.id.bt_calcular)
        val resultado = findViewById<TextView>(R.id.resultado)
        botaoCalcular.setOnClickListener {
            val nota1 = Integer.parseInt(findViewById<EditText>(R.id.nota1).text.toString())
            val nota2 = Integer.parseInt(findViewById<EditText>(R.id.nota2).text.toString())
            val faltas = Integer.parseInt(findViewById<EditText>(R.id.faltas).text.toString())
            val media = (nota1 + nota2)/2

            if (media >=6 && faltas <=10){
                resultado.setText("Aluno Aprovado " + "\n" +  "Nota Final: " + media + "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.GREEN)
            }else{
                resultado.setText("Aluno Reprovado "+ "\n" +  "Nota Final: " + media + "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.RED)
            }
        }
    }

}