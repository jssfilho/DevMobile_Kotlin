package br.com.ifpb.lampiao.youtubeclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.ifpb.lampiao.youtubeclone.Adapter.VideosAdapter
import br.com.ifpb.lampiao.youtubeclone.Model.addVideos
import br.com.ifpb.lampiao.youtubeclone.OnClick.OnItemClickListener
import br.com.ifpb.lampiao.youtubeclone.OnClick.addOnItemClickListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recycler = findViewById<RecyclerView>(R.id.recycler_videos)
        recycler.adapter = VideosAdapter(addVideos())
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addOnItemClickListener(object: OnItemClickListener{

            override fun onItemClicked(position: Int, view: View) {
                when(position) {
                    0 -> Toast.makeText(applicationContext,"Assistir Minecraft",Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(applicationContext,"Assistir a Receita",Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(applicationContext,"Assistir a Viagem",Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(applicationContext,"Assistir ao Anime",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_youtube,menu)
        return true
    }
}