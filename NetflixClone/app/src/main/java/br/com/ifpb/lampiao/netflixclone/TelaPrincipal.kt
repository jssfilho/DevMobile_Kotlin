package br.com.ifpb.lampiao.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class TelaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)
        var serie_1 = findViewById<ImageView>(R.id.serie1)
        var serie_2 = findViewById<ImageView>(R.id.serie2)
        var serie_3 = findViewById<ImageView>(R.id.serie3)
        var serie_4 = findViewById<ImageView>(R.id.serie4)
        val imagens = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-c5188.appspot.com/o/imagens%2Fwitcher.png?alt=media&token=f34f0ed5-15f2-466b-bcb7-1a98de74a70c")
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie_1)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie_2)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie_3)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie_4)
        serie_1.setOnClickListener {
            var intent = Intent(this,Detalhes::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_tela_principal,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_sair -> {
                FirebaseAuth.getInstance().signOut()
                voltarFormLogin()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun voltarFormLogin(){
        var intent = Intent(this,FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}