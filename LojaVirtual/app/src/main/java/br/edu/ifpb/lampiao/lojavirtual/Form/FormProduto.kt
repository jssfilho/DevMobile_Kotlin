package br.edu.ifpb.lampiao.lojavirtual.Form

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import br.edu.ifpb.lampiao.lojavirtual.Model.Dados
import br.edu.ifpb.lampiao.lojavirtual.R
import br.edu.ifpb.lampiao.lojavirtual.TelaPrincipal
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.*

class FormProduto : AppCompatActivity() {
    private var selecionarUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_produto)
        var btn_selecionar_foto = findViewById<Button>(R.id.bt_selecionar_foto)
        var btn_cadastrar = findViewById<Button>(R.id.bt_cadastro_produto)
        btn_selecionar_foto.setOnClickListener {
            selecionarFotoGaleria()
        }
        btn_cadastrar.setOnClickListener {
            salvarProduto()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 0){
            selecionarUri = data?.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver,selecionarUri)
            var foto = findViewById<ImageView>(R.id.foto_produto)
            var btn_selecionar_foto = findViewById<Button>(R.id.bt_selecionar_foto)
            foto.setImageBitmap(bitmap)
            btn_selecionar_foto.alpha = 0f

        }
    }
    private fun selecionarFotoGaleria(){
        var intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent,0)
    }
    private fun salvarProduto(){
        var nome = findViewById<EditText>(R.id.nome_produto).text.toString()
        var preco = findViewById<EditText>(R.id.preco_produto).text.toString()
        val nomeArquivo = UUID.randomUUID().toString()
        val referencia = FirebaseStorage.getInstance().getReference(
                "/imagens/${nomeArquivo}")
        selecionarUri?.let {
            referencia.putFile(it)
                    .addOnSuccessListener {
                        referencia.downloadUrl.addOnSuccessListener {
                            val url = it.toString()
                            val uid = FirebaseAuth.getInstance().uid
                            val Produtos = Dados(url,nome,preco)
                            FirebaseFirestore.getInstance().collection("Produtos")
                                .add(Produtos).addOnSuccessListener {
                                    Toast.makeText(this,"Produtos cadastrados com sucesso!", Toast.LENGTH_SHORT).show()
                                    carregarTelasDeProdutos()
                                }.addOnFailureListener {
                                    Toast.makeText(this,"Erro ao cadastrar o produto!", Toast.LENGTH_SHORT).show()
                                }
                        }
                    }
        }

    }
    private fun carregarTelasDeProdutos(){
        var intent = Intent(this,TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }

}