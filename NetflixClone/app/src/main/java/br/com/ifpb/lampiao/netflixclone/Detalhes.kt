package br.com.ifpb.lampiao.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class Detalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodios)
        var imagem_video = findViewById<ImageView>(R.id.imageVideo)
        var play_video = findViewById<ImageView>(R.id.play)
        val imagem = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-c5188.appspot.com/o/imagens%2Fvideo.jpg?alt=media&token=c17a6df9-07f5-42fb-87ef-84ce58c50ca2")
        Picasso.get().load(imagem).fit().placeholder(R.drawable.gif).into(imagem_video)
        play_video.setOnClickListener {
            var intent = Intent(this,Video::class.java)
            startActivity(intent)
        }
    }
}