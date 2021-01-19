package br.edu.ifpb.lampiao.spotifyclone

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import br.edu.ifpb.lampiao.spotifyclone.Fragment.Home
import com.squareup.picasso.Picasso

class Detalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        intent.extras?.let {
            var album = it.getString("album")
            var tituloAlbum = findViewById<TextView>(R.id.titulo_album)
            var imageAlbum = findViewById<ImageView>(R.id.detalhe_album)
            var titulos: String? = it.getString("titulos")

            Picasso.get().load(album).into(imageAlbum)
            tituloAlbum.setText(titulos)

        }

        var toolbar = findViewById<Toolbar>(R.id.toolbar_detalhes)
        window.statusBarColor = Color.LTGRAY
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_arrow_back))
        toolbar.title = null
        toolbar.setNavigationOnClickListener {
            var intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }
    }

}